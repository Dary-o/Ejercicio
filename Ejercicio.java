
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Producto {

    public int id;
    public String producto;
    public double precio;
    public String comercio;
    public boolean promocion;

    public Producto(int id, String producto, double precio, String comercio, boolean promocion) {
        this.id = id;
        this.producto = producto;
        this.precio = precio;
        this.comercio = comercio;
        this.promocion = promocion;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", producto=" + producto + ", precio=" + precio + ", comercio=" + comercio + ", promocion=" + promocion + '}';
    }

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getComercio() {
        return comercio;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public boolean isPromocion() {
        return promocion;
    }

    public void setPromocion(boolean promocion) {
        this.promocion = promocion;
    }

    

    public static void main(String[] args) {

        List<Producto> producto = new <Producto> ArrayList();
        Producto pro1 = new Producto(1, "Zapatillas", 19999.99, "Nike", false);
        Producto pro2 = new Producto(2, "Campera", 14999.99, "Nike", false);
        Producto pro3 = new Producto(3, "Remera", 5999.99, "Nike", true);
        Producto pro4 = new Producto(10, "Zapatillas", 14999.99, "Adidas", false);
        Producto pro5 = new Producto(11, "Cempera", 11999.99, "Adidas", false);
        Producto pro6 = new Producto(12, "Remera", 3500.50, "Adidas", true);

        producto.add(pro1);
        producto.add(pro2);
        producto.add(pro3);
        producto.add(pro4);
        producto.add(pro5);
        producto.add(pro6);
    

        System.out.println("-----------------------------------------------");

        System.out.println("Lista de forma Ascendente: ");
        producto.stream()
                .filter(p -> p.precio > 0)
                .sorted(Comparator.comparingDouble(p -> p.precio * p.precio))
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------");
        
        System.out.println("Producto de menor valor: ");
        producto.stream()
                .filter(p -> p.precio < 4000)
                .sorted(Comparator.comparingDouble(p -> p.precio))
                .forEach(System.out::println);
        
        System.out.println("Precio:");
        producto.stream()
                .mapToDouble(Producto::getPrecio)
                .min()
                .ifPresent(System.out::println);

        System.out.println("-----------------------------------------------");

        System.out.println("El comercio con el producto con precio mas bajo es: ");
        producto.stream()
                .filter(p -> p.precio < 4000)
                .map(p -> p.comercio)
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------");

        
        System.out.println("El producto con el mayor precio es: ");
        producto.stream()
                .mapToDouble(Producto::getPrecio)
                .max()
                .ifPresent(System.out::println);

        System.out.println("-----------------------------------------------");

        
        System.out.println("El promedio de precios de productos de Linea es : " + producto
                                                                .stream()
                                                                .filter(p -> p.isPromocion() == false)
                                                                .mapToDouble(Producto::getPrecio)
                                                                .average());
        
        System.out.println("-----------------------------------------------");
        
        System.out.println("El promedio de precios de productos de Promocion es : " + producto
                                                                .stream()
                                                                .filter(p -> p.isPromocion() == true)
                                                                .mapToDouble(Producto::getPrecio)
                                                                .average());
        
        
        System.out.println("-----------------------------------------------");
        

        
        /*String str = producto.get(4).toString();
        System.out.println("String value: "+str);*/
        
        System.out.println("Los productos del comercio de Adidas son: ");
        producto.stream()
                .filter(p -> p.comercio == "Adidas")
                .forEach(System.out::println);
        
        System.out.println("-----------------------------------------------");
        
        System.out.println("Los productos del comercio de Nike son: ");
        producto.stream()
                .filter(p -> p.comercio == "Nike")
                .forEach(System.out::println);
        
    }
}