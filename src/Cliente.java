import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cliente {

    private int cedula;
    private String nombre;
    private String telefono;
    private List<Integer> productos;
    private static String NO_ENCUENTRA_REGISTRO = "!!!!!!!!!!Este cliente No se encuentra registrado!!!!!!!!!!\n";

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Integer> getProductos() {
        return productos;
    }

    public void setProductos(List<Integer> productos) {
        this.productos = productos;
    }

    public static void agregarCliente(Cliente c, Map<Integer, List<Object>> clientes, List<Object> products){
        List<Object> datos = new ArrayList<>();
        datos.add(c.getCedula());
        datos.add(c.getNombre());
        datos.add(c.getTelefono());
        datos.add(products);

        clientes.put(c.getCedula(),datos);
        System.out.println("!!!!!!!!!!El cliente ha sido registrado con exito!!!!!!!!!!\n");
    }

    public static void consultarCliente(int cedula){
        if (AlmacenarDatos.datosClientes.get(cedula)==null){
            System.out.println(NO_ENCUENTRA_REGISTRO);
        }else{
            System.out.println("Cedula: "+AlmacenarDatos.datosClientes.get(cedula).get(0)+
                    "\nNombre: "+AlmacenarDatos.datosClientes.get(cedula).get(1)+
                    "\nTelefono: "+AlmacenarDatos.datosClientes.get(cedula).get(2)+
                    "\nProductos: "+AlmacenarDatos.datosClientes.get(cedula).get(3));
        }

    }

    public static void eliminarCliente(int cedula, Scanner s){
        if (AlmacenarDatos.datosClientes.get(cedula)==null){
            System.out.println(NO_ENCUENTRA_REGISTRO);
        }else{
            System.out.println("Está seguro que desea eliminar el registro S/N\n");
            String opt = s.next();
            if(opt.equalsIgnoreCase("s")){
                AlmacenarDatos.datosClientes.remove(cedula);
                System.out.println("El cliente ha sido eliminado con exito! :D\n");
            }else if(opt.equalsIgnoreCase("n")){
                System.out.println("No se elimino el cliente\n");
            }
        }


}

    public static void editarCliente(int cedula, String tel, Scanner s){
        if (AlmacenarDatos.datosClientes.get(cedula)==null){
            System.out.println(NO_ENCUENTRA_REGISTRO);
        }else{
            System.out.println("Está seguro que desea editar el registro S/N\n");
            String opt = s.next();
            if(opt.equalsIgnoreCase("s")){
                List<Object> actual = AlmacenarDatos.datosClientes.get(cedula);
                actual.add(2,tel);
                AlmacenarDatos.datosClientes.put(cedula, actual);
                System.out.println("El cliente ha sido Actualizado con exito! :D\n");
            }else if(opt.equalsIgnoreCase("n")){
                System.out.println("No se edito el telefono del cliente\n");
            }
        }
    }
}
