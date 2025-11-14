package limoncito.domain;


public class ItemOrden {
    private Producto producto;
    private int cantidad;
    private double precioAplicado;
    private double subtotal;

    public ItemOrden(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida, debe ser mayor a 0.");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioAplicado = producto.getPrecioPorCantidad(cantidad);
        this.subtotal = precioAplicado * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioAplicado() {
        return precioAplicado;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
