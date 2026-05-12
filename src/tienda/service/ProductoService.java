package tienda.service;

import tienda.exception.ProductoNoEncontradoException;
import tienda.exception.ProductoDuplicadoException;
import tienda.model.Producto;
import tienda.util.Validador;

import java.util.ArrayList;
import java.util.List;

public class ProductoService {

    private List<Producto> productos =
            new ArrayList<>();

    private static int contadorId = 1;

    // CREATE
    public Producto guardar(Producto p) throws ProductoDuplicadoException {
        

        // 1. REVISAR SI EL NOMBRE YA EXISTE
        for (Producto existente : productos) {
        if (existente.getNombre().equalsIgnoreCase(p.getNombre())) {
            throw new ProductoDuplicadoException(
                "Ya existe un producto con el nombre: " + p.getNombre());
        }
    }

    // 2. Si no existe, seguimos con las validaciones y guardamos

        Validador.validarTexto(p.getNombre());

        Validador.validarTexto(p.getCategoria());

        Validador.validarPrecio(p.getPrecio());

        Validador.validarStock(p.getStock());

        p.setId(contadorId);

        contadorId++;

        productos.add(p);

        return p;
    }

    // READ
    public List<Producto> listarTodos() {
        return productos;
    }

    // READ BY ID
    public Producto obtenerPorId(int id) 
            throws ProductoNoEncontradoException {

        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }

        throw new ProductoNoEncontradoException(
                "No se encontró el producto con ID "
                        + id);
    }

    // UPDATE
    public Producto actualizar(
            int id,
            Producto datos) 
            throws ProductoNoEncontradoException {

        Producto p =
                obtenerPorId(id);

        Validador.validarTexto(datos.getNombre());

        Validador.validarTexto(datos.getCategoria());

        Validador.validarPrecio(datos.getPrecio());

        Validador.validarStock(datos.getStock());

        p.setNombre(datos.getNombre());

        p.setCategoria(datos.getCategoria());

        p.setPrecio(datos.getPrecio());

        p.setStock(datos.getStock());

        return p;
    }

    // DELETE
    public void eliminar(int id) 
            throws ProductoNoEncontradoException {

        Producto p =
                obtenerPorId(id);

        productos.remove(p);
    }
}