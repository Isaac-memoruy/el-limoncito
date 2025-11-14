package limoncito.domain;


import java.util.ArrayList;
import java.util.List;

public class Orden {
    private Cliente cliente;
    private List<ItemOrden> items;
    private boolean servicioExpress;
    private boolean confirmada;

    public Orden(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.servicioExpress = false;
        this.confirmada = false;
    }

    public void agregarItem(ItemOrden item) {
        if (confirmada) {
            System.out.println(" No se pueden agregar ítems a una orden confirmada.");
            return;
        }
        items.add(item);
    }

    public void setServicioExpress(boolean express) {
        if (confirmada) {
            System.out.println(" No se puede cambiar el tipo de servicio después de confirmar.");
            return;
        }
        this.servicioExpress = express;
    }

    public void confirmar() {
        this.confirmada = true;
        System.out.println(" Orden confirmada. No se permiten más cambios.");
    }

    public void mostrarResumen() {
        System.out.println("\n----- RESUMEN DE ORDEN -----");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("-----------------------------");

        double totalBruto = 0;
        for (ItemOrden i : items) {
            System.out.println(i.getProducto().getNombre() + " x" + i.getCantidad() +
                    " @ " + i.getPrecioAplicado() + " = $" + i.getSubtotal());
            totalBruto += i.getSubtotal();
        }

        double recargo = servicioExpress ? totalBruto * 0.10 : 0;
        double subtotalConRecargo = totalBruto + recargo;
        double descuento = subtotalConRecargo > 60000 ? subtotalConRecargo * 0.05 : 0;
        double totalFinal = subtotalConRecargo - descuento;

        System.out.println("-----------------------------");
        System.out.println("Subtotal bruto: $" + totalBruto);
        System.out.println("Recargo exprés: $" + recargo);
        System.out.println("Descuento: $" + descuento);
        System.out.println("TOTAL FINAL: $" + totalFinal);
        System.out.println("-----------------------------\n");
    }
}
