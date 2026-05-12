package tienda;

import tienda.service.ProductoService;
import tienda.exception.ProductoNoEncontradoException;
import tienda.exception.ProductoDuplicadoException;
import tienda.ui.MenuProducto;
import tienda.util.Validador;
import tienda.model.Producto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ProductoService service =
                new ProductoService();

        Scanner sc =
                new Scanner(System.in);

        MenuProducto menu =
                new MenuProducto(sc, service);

        // Productos de prueba
        try {
            cargarDatosDePrueba(service);
        } catch (ProductoDuplicadoException e) {
            System.out.println("Error en carga inicial: " + e.getMessage());
        }

        int opcion;

        do {
            menu.mostrarMenu();
            opcion =
                    Validador.leerEntero(
                            sc,
                            "Seleccione una opción: ");

            try {
                switch (opcion) {
                    case 1 -> menu.agregarProducto();
                    case 2 -> menu.listarProductos();
                    case 3 -> menu.buscarProducto();
                    case 4 -> menu.actualizarProducto();
                    case 5 -> menu.eliminarProducto();
                    case 0 -> System.out.println(
                        "\n🌸 Gracias por usar IKENOBO");

                    default -> System.out.println(
                        "Opción inválida");
                }

            } catch (
                    ProductoNoEncontradoException | ProductoDuplicadoException e) {

                System.out.println(
                        e.getMessage());

            } catch (
                    IllegalArgumentException e) {
                System.out.println(
                        "Dato inválido: "
                                + e.getMessage());
            }

            System.out.println();

        } while (opcion != 0);

        sc.close();
    }

    
    // PRODUCTOS DE PRUEBA
    
    private static void cargarDatosDePrueba(
            ProductoService service) throws ProductoDuplicadoException {

        service.guardar(
                new Producto(
                        "Ramo de rosas rojas",
                        15000,
                        10,
                        "Gifts"
                )
        );

        service.guardar(
                new Producto(
                        "Centro de mesa gerberas",
                        22000,
                        5,
                        "Deco"
                )
        );

        service.guardar(
                new Producto(
                        "Bouquet primaveral",
                        18000,
                        8,
                        "Aniversario"
                )
        );

        System.out.println(
                "Productos de prueba cargados\n");
    }
}