import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu extends AlmacenarDatos {

    public static void ejecutar() {

        Scanner scanner = new Scanner(System.in);
        int option = 0;
        int cc ;
        Cliente consultaCliente = new Cliente();

        while (option != 6) {


            try {
                System.out.println("Ingrese una opción del menú: \n" +
                        "1) Agregar productos\n" +
                        "2) Agregar clientes\n" +
                        "3) Editar clientes\n" +
                        "4) Eliminar cliente\n" +
                        "5) Consultar cliente\n" +
                        "6) Cerrar\n");
                option = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("!!!!!!!!!!Ingresó una opción invalida¡¡¡¡¡¡¡¡¡¡¡¡");
                e.printStackTrace();

            }
            switch (option) {
                case 1:
                    Producto p = new Producto();
                    System.out.println("Ingrese identificador del producto");
                    p.setId(Integer.parseInt(scanner.next()));
                    System.out.println("Ingrese nombre del producto");
                    p.setNombre(scanner.next());
                    System.out.println("Ingrese precio del producto");
                    p.setPrecio(Double.parseDouble(scanner.next()));

                    Producto.agregarProducto(p, datosProdctos);
                    break;

                case 2:
                    Cliente c = new Cliente();
                    System.out.println("Ingrese cedula del cliente");
                    c.setCedula(Integer.parseInt(scanner.next()));
                    System.out.println("Ingrese nombre completo del cliente");
                    c.setNombre(scanner.next());
                    System.out.println("Ingrese telefono del cliente");
                    c.setTelefono(scanner.next());
                    System.out.println("Cuantos productos desea ingrear");
                    int x = Integer.parseInt(scanner.next());
                    List<Object> pro = new ArrayList<>();
                    for (int i = 0; i < x; i++) {
                        System.out.println("ingrese nombre del producto");
                        pro.add(scanner.next());
                    }

                    c.agregarCliente(c, datosClientes, pro);
                    break;

                case 3:
                    System.out.println("Ingrese el numero de documento del cliente que desea editar");
                    cc = Integer.parseInt(scanner.next());
                    System.out.println("Ingrese el nuevo telefono del cliente");
                    String tel = scanner.next();
                    consultaCliente.editarCliente(cc,tel,scanner);

                    break;

                case 4:
                    System.out.println("Ingrese el numero de documento del cliente que desea eliminar");
                    cc = Integer.parseInt(scanner.next());
                    consultaCliente.eliminarCliente(cc, scanner);


                    break;

                case 5:
                    System.out.println("Ingrese el numero de documento del cliente:");
                    cc = Integer.parseInt(scanner.next());
                    consultaCliente.consultarCliente(cc);

                    break;

                case 6:
                    break;

                default:

                    break;
            }
        }


    }
}


