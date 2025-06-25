import java.lang.Math;

public class TrianguloEquilatero extends Triangulo {
    private double lado;

    public TrianguloEquilatero(String nombre, double lado) {
        super(nombre, lado, lado, lado); // Llama al constructor de la superclase Triangulo
        this.lado = lado;
    }

    @Override
    public double area() {
        double calculatedArea = (Math.sqrt(3) / 4) * (lado * lado);
        super.setArea(calculatedArea);
        return calculatedArea;
    }

    @Override
    public double perimetro() {
        double calculatedPerimeter = 3 * lado;
        super.setPerimetro(calculatedPerimeter);
        return calculatedPerimeter;
    }

    @Override
    public String toString() {
        return super.toString() + " [Tipo: Equilátero, Lado: " + lado + "]";
    }
}
