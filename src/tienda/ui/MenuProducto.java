package tienda.ui;

import tienda.service.ProductoService;
import tienda.exception.ProductoNoEncontradoException;
import tienda.exception.ProductoDuplicadoException;
import tienda.model.Producto;
import tienda.util.Validador;

import java.util.Scanner;
import java.util.List;

public class MenuProducto {

    private Scanner sc;
    private ProductoService service;

    // CONSTRUCTOR
    public MenuProducto(
            Scanner sc,
            ProductoService service) {
        this.sc = sc;
        this.service = service;
    }

    // MOSTRAR MENÚ
    public void mostrarMenu() {

        System.out.println("\n===== ARREGLOS FLORALES =====");

        System.out.println("1. Agregar producto");
        System.out.println("2. Listar productos");
        System.out.println("3) Buscar producto por ID");
        System.out.println("4) Actualizar producto");
        System.out.println("5) Eliminar producto");
        System.out.println("0. Salir");
        System.out.println("========== IKENOBO ===========");
    }

    // AGREGAR PRODUCTO
    public void agregarProducto() 
        throws ProductoDuplicadoException {

        System.out.println("- Nuevo producto -");

        String nombre =
                Validador.leerTexto(
                        sc,
                        "Nombre: ");

        double precio =
                Validador.leerDouble(
                        sc,
                        "Precio: ");

        int stock =
                Validador.leerEntero(
                        sc,
                        "Stock: ");

        String categoria =
                Validador.leerTexto(
                        sc,
                        "Categoría: ");

        Producto p =
                new Producto(
                        nombre,
                        precio,
                        stock,
                        categoria
                );

        Producto guardado =
                service.guardar(p);

        System.out.println(
                "Producto agregado con id "
                        + guardado.getId());
    }

    // LISTAR PRODUCTOS
    public void listarProductos() 
        throws ProductoNoEncontradoException {

        List<Producto> lista =
                service.listarTodos();

        if (lista.isEmpty()) {

            System.out.println(
                    "No hay productos cargados.");

            return;
        }

        System.out.println("\n- CATÁLOGO -");

        for (Producto p : lista) {

            System.out.println(p);
        }
    }

    // BUSCAR PRODUCTO
    public void buscarProducto()
        throws ProductoNoEncontradoException {

        int id =
                Validador.leerEntero(
                        sc,
                        "Ingrese ID: ");

        Producto p =
                service.obtenerPorId(id);

        System.out.println(
                "\nProducto encontrado:");

        System.out.println(p);
    }

    // ACTUALIZAR PRODUCTO

    public void actualizarProducto() 
        throws ProductoNoEncontradoException {

        int id =
                Validador.leerEntero(
                        sc,
                        "Ingrese ID a actualizar: ");

        // Si no existe, lanza la excepción y salta al Main automáticamente
        // 
        Producto actual =
                service.obtenerPorId(id);

        System.out.println(
                "\nDatos actuales: " + actual);

        System.out.println(actual);

        System.out.println(
                "\n- Nuevos datos -");

        String nombre =
                Validador.leerTexto(
                        sc,
                        "Nombre: ");

        double precio =
                Validador.leerDouble(
                        sc,
                        "Precio: ");

        int stock =
                Validador.leerEntero(
                        sc,
                        "Stock: ");

        String categoria =
                Validador.leerTexto(
                        sc,
                        "Categoría: ");

        Producto datos =
                new Producto(
                        nombre,
                        precio,
                        stock,
                        categoria
                );

        Producto actualizado =
                service.actualizar(
                        id,
                        datos);

        System.out.println(
                "\n Producto actualizado:");

        System.out.println(actualizado);
    }

    // ELIMINAR PRODUCTO

     public void eliminarProducto() 
        throws ProductoNoEncontradoException {

        int id =
                Validador.leerEntero(
                        sc,
                        "Ingrese el ID a eliminar: ");

        service.eliminar(id);

        System.out.println(
                "Producto eliminado");
    }
}