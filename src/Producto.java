public class Producto {

    public String CodProducto;
    public String name;
    public double precio;
    private double costo;
    public String Desc;
    public boolean Status;

    public Producto(String codprod, String name, double precio, double costo, String desc) {
        this.CodProducto = codprod;
        this.name = name;
        this.precio= precio;
        this.costo= costo;
        this.Desc = desc;
        this.Status = true;
    }

    public double getCosto(){
        return costo;
    }

    public void setcosto (double costo) {
        this.costo = costo;
    }
}
