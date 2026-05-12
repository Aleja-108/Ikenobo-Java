package tienda.exception;

public class ProductoDuplicadoException
        extends Exception {

    public ProductoDuplicadoException(
            String mensaje) {

        super(mensaje);
    }
}