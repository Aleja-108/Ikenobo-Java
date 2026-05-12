#  E-commerce de 🌸 Arreglos Florales 🌸

Proyecto en Java que simula un sistema básico de gestión de productos (arreglos florales).

##  Funcionalidades

- Agregar productos
- Listar productos
- Buscar por ID
- Actualizar precio y stock
- Eliminar productos


##  Conceptos aplicados

- Programación Orientada a Objetos (POO)
- Encapsulamiento
- Manejo de excepciones personalizadas
    - Productos duplicados por nombre.
    - Búsqueda de IDs inexistentes.
    - Formatos de datos incorrectos.
- Colecciones (ArrayList)
- Separación en capas (model, service, ui, util)

##  Estructura

- model → entidades
- service → lógica de negocio
- ui → interacción con usuario
- util → validaciones
- exception → errores personalizados

text
src/
 └── tienda/
      ├── model/      # Clases de entidad (Producto)
      ├── service/    # Lógica de negocio e inventario
      ├── ui/         # Interfaz de usuario (Menú)
      ├── util/       # Validadores de entrada
      ├── exception/  # Excepciones personalizadas
      └── Main.java   # Punto de entrada de la aplicación

## Cómo ejecutar

1. Compilar:
dir /s /b src\*.java > fuentes.txt && javac -encoding UTF-8 -d bin @fuentes.txt && del fuentes.txt
2. Ejecutar:
java -cp bin tienda.Main


Desarrollado por ALEJANDRA ESTEO - 2026