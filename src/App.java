import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static String CodProducto;
    public static String name;
    public static double precio;
    private static double costo;
    public static String Desc;

    public static Producto newproducto;
    public static ArrayList<Producto> productos = new ArrayList<Producto>();
    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        boolean salir = true;

        do {

            System.out.println("Ingrese una opcion");
            System.out.println("1-Agregar");
            System.out.println("2-Mostrar Catalogo");
            System.out.println("3- Modificar");
            System.out.println("4 - Eliminar");
            System.out.println("5- Salir");
            int op = leer.nextInt();
            leer.nextLine();

            switch (op) {
                case 1:
                    AddProduct();
                    break;
                case 2:
                    MostrarCatalogo();
                    break;
                case 3:
                    Modificarproducto();
                    break;
                case 4:
                    EliminarProducto();
                    break;
                case 5:
                    salir = false;
                    break;

                default:
                    break;
            }
        } while (salir);

    }

    public static void AddProduct() {
        System.out.println("Ingrese los datos de un producto");
        System.out.println("Cod ");
        CodProducto = leer.nextLine();
        System.out.println("name");
        name = leer.nextLine();
        System.out.println("costo");
        precio = leer.nextDouble();
        System.out.println("precio");
        costo = leer.nextDouble();
        leer.nextLine();
        System.out.println("Desc");
        Desc = leer.nextLine();
        newproducto = new Producto(CodProducto, name, costo, precio, Desc);
        productos.add(newproducto);
        // return newproducto;
    }

    public static void MostrarCatalogo() {
        for (Producto producto : productos) {
            System.out.println("Cod: " + producto.CodProducto);
            System.out.println("name: " + producto.name);
            System.out.println("costo: " + producto.getCosto());
            System.out.println("precio: " + producto.precio);
            System.out.println("Desc: " + producto.Desc);
            System.out.println("=========================");
        }
    }

    public static Producto BuscarProducto(String codProducto) {
        Producto PSearch = null;
        
        for (Producto producto : productos) {

            if (producto.CodProducto.equals(codProducto)) {
                PSearch = producto;
                break;
            }
        }
        return PSearch;
    }

    public static void Modificarproducto() {
        boolean productoencontrado = false;
    
        do {
            System.out.println("Ingrese el codigo del producto que desea modificar");
            String codProducto = leer.nextLine();
    
            Producto producto = BuscarProducto(codProducto);
            if (producto != null) {
                productoencontrado = true;
                
                System.out.println("El producto ha sido encontrado");
                System.out.println("Producto: " + producto.name);
                System.out.println("Ingrese los nuevos datos a modificar");
    
                System.out.println("Nuevo costo:");
                if (leer.hasNextDouble()) {
                    double nuevocosto = leer.nextDouble();
                    producto.setcosto(nuevocosto);
                }
                leer.nextLine();  // Limpiar el buffer
    
                System.out.println("Nuevo precio: ");
                if (leer.hasNextDouble()) {
                    double nuevoprecio = leer.nextDouble();
                    producto.precio = nuevoprecio;
                }
                leer.nextLine();  // Limpiar el buffer
    
                System.out.println("Producto modificado");
            } else {
                System.out.println("Producto no encontrado. Intente nuevamente.");

            }
        } while (!productoencontrado);
    }
    
    public static void EliminarProducto() {

        boolean productoencontrado = false;

        do {
            System.out.println("Ingrese el codigo del producto que desea eleminar");
        String codProducto = leer.nextLine();

        Producto producto = BuscarProducto(codProducto);

        if (producto !=null) {

            productoencontrado = true;

            System.out.println("Producto encontrado");
            System.out.println("Producto: "+producto.name);
            boolean cancelar = true;

            do {
                System.out.println("Ingrese 1 para confirmar eliminacion");
                System.out.println("Ingrese 0 para cancelar");
                int resp = leer.nextInt();
                if (resp == 1) {
                    productos.remove(producto);
                    System.out.println("Producto eliminado");
                    cancelar = false;
                } else {
                    System.out.println("Cancelando...");
                    cancelar = false;
                }
            } while (cancelar);
        } else {
            System.out.println("Producto no encontrado");
        }
        } while (!productoencontrado);
        
    }


}
