import sqlite3
import os

# Ruta donde deseas crear la base de datos dentro del proyecto
ruta_bd = os.path.join(os.path.dirname(__file__), 'mi_base_de_datos.db')

# Conectar a la base de datos (se creará si no existe)
conexion = sqlite3.connect(ruta_bd)

# Crear un cursor
cursor = conexion.cursor()

# Crear tabla de ejemplo: usuarios
cursor.execute('''
CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    correo TEXT NOT NULL UNIQUE
)
''')

# Crear tabla de ejemplo: productos
cursor.execute('''
CREATE TABLE IF NOT EXISTS productos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    precio REAL NOT NULL
)
''')

# Crear tabla de premios
cursor.execute('''
CREATE TABLE IF NOT EXISTS premios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    archivo_audio TEXT NOT NULL
)
''')

# Confirmar los cambios
conexion.commit()

# Cerrar la conexión
conexion.close()

print("Base de datos y tablas creadas exitosamente.")
