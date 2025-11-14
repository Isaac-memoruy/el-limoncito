package limoncito.domain;

public class Producto {
    private String nombre;
    private double precioNormal;
    private double precioVolumen;

    public Producto(String nombre, double precioNormal, double precioVolumen) {
        this.nombre = nombre;
        this.precioNormal = precioNormal;
        this.precioVolumen = precioVolumen;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioPorCantidad(int cantidad) {
        if (cantidad >= 5) {
            return precioVolumen;
        } else {
            return precioNormal;
        }
    }
}

    
