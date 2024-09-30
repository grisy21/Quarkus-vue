package com.example.miapp;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    // Obtener todos los usuarios
    @GET
    public List<Usuario> getAll() {
        return Usuario.listAll();
    }

    // Crear un nuevo usuario o autenticar uno existente
    @POST
    @Path("/login")
    @Transactional
    public Response authenticateOrCreate(Usuario usuario) {
        // Verificar si el usuario ya existe en la base de datos
        Usuario existingUser = Usuario.find("email", usuario.email).firstResult();

        if (existingUser != null) {
            // El usuario existe, verificar la contraseña
            if (existingUser.password.equals(usuario.password)) {
                // Autenticación exitosa
                return Response.ok()
                    .entity("{\"message\":\"Login successful\"}")
                    .build();
            } else {
                // Contraseña incorrecta
                return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"message\":\"Invalid password\"}")
                    .build();
            }
        } else {
            // El usuario no existe, crear uno nuevo
            usuario.persist();
            return Response.status(Response.Status.CREATED)
                .entity("{\"message\":\"User created successfully\"}")
                .build();
        }
    }
}

