package tienda.util;

import java.util.Scanner;

public class Validador {

    // VALIDAR TEXTO VACÍO
    public static String validarTexto(
            String texto) {

        if (texto == null ||
                texto.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "El texto no puede estar vacío");
        }

        return texto;
    }

    // VALIDAR PRECIO
    public static double validarPrecio(
            double precio) {

        if (precio <= 0) {

            throw new IllegalArgumentException(
                    "El precio debe ser mayor a 0");
        }

        return precio;
    }

    // VALIDAR STOCK
    public static int validarStock(
            int stock) {

        if (stock < 0) {

            throw new IllegalArgumentException(
                    "El stock no puede ser negativo");
        }

        return stock;
    }

    // LEER ENTERO
    public static int leerEntero(
            Scanner sc,
            String mensaje) {

        System.out.print(mensaje);

        while (!sc.hasNextInt()) {

            System.out.println(
                    "Debe ingresar un número entero");

            sc.next();

            System.out.print(mensaje);
        }

        return sc.nextInt();
    }

    // LEER DOUBLE
    public static double leerDouble(
            Scanner sc,
            String mensaje) {

        System.out.print(mensaje);

        while (!sc.hasNextDouble()) {

            System.out.println(
                    "Debe ingresar un número válido");

            sc.next();

            System.out.print(mensaje);
        }

        return sc.nextDouble();
    }

    // LEER TEXTO
    public static String leerTexto(
            Scanner sc,
            String mensaje) {

        System.out.print(mensaje);

        String texto = sc.nextLine();

        while (texto.trim().isEmpty()) {

            System.out.println(
                    "El texto no puede estar vacío");

            System.out.print(mensaje);

            texto = sc.nextLine();
        }

        return texto;
    }
}
