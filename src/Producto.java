import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Producto {

    private int id;
    private String nombre;
    private double precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public static void agregarProducto(Producto p, Map<Integer, List<Object>> productos){

        List<Object> datos = new ArrayList<>();
        datos.add(p.getId());
        datos.add(p.getNombre());
        datos.add(p.getPrecio());

        productos.put(p.getId(), datos);

    }
}
