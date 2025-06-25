public class FiguraGeometrica {
    private String nombre;
    protected double area = 0.0;
    protected double perimetro = 0.0;

    public FiguraGeometrica(String nombre) {
        this.nombre = nombre;
        // Mensaje para ver la llamada al constructor
        // System.out.println("Constructor de FiguraGeometrica (nombre) llamado para: " + nombre);
    }

    public FiguraGeometrica(String nombre, double area) {
        this.nombre = nombre;
        this.area = area;
        // System.out.println("Constructor de FiguraGeometrica (nombre, area) llamado para: " + nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public double area() {
        System.out.println("Calculo de area no implementado para FiguraGeometrica generica.");
        return 0.0;
    }

    public double perimetro() {
        System.out.println("Calculo de perimetro no implementado para FiguraGeometrica generica.");
        return 0.0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    @Override
    public String toString() {
        return "FiguraGeometrica [nombre=" + nombre + ", area=" + area + ", perimetro=" + perimetro + "]";
    }

    public String toString(boolean dato) {
        if (dato) {
            return "Area: " + this.area;
        }
        return "Perimetro: " + this.perimetro;
    }
}
