import java.lang.Math;

public class Triangulo extends FiguraGeometrica {
    private double lado1;
    private double lado2;
    private double lado3;
    private double base;
    private double altura;

    // Constructor 1: Con base y altura
    public Triangulo(String nombre, double base, double altura) {
        super(nombre); // Llama al constructor de FiguraGeometrica
        this.base = base;
        this.altura = altura;
        // System.out.println("Constructor de Triangulo (base, altura) llamado.");
    }

    // Constructor 2: Con los tres lados
    public Triangulo(String nombre, double lado1, double lado2, double lado3) {
        super(nombre); // Llama al constructor de FiguraGeometrica
        if (!((lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1))) {
            throw new IllegalArgumentException("Los lados proporcionados no pueden formar un triángulo válido.");
        }
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        // System.out.println("Constructor de Triangulo (lados) llamado.");
    }

    @Override
    public double area() {
        if (base != 0 && altura != 0) {
            double calculatedArea = 0.5 * base * altura;
            super.setArea(calculatedArea); // Llama al setter de la superclase FiguraGeometrica
            return calculatedArea;
        } else if (lado1 != 0 && lado2 != 0 && lado3 != 0) {
            double s = (lado1 + lado2 + lado3) / 2;
            double calculatedArea = Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
            super.setArea(calculatedArea); // Llama al setter de la superclase FiguraGeometrica
            return calculatedArea;
        } else {
            System.out.println("No se puede calcular el area para este triangulo: informacion de lados/base y altura incompleta.");
            super.setArea(0.0);
            return 0.0;
        }
    }

    @Override
    public double perimetro() {
        if (lado1 != 0 && lado2 != 0 && lado3 != 0) {
            double calculatedPerimeter = lado1 + lado2 + lado3;
            super.setPerimetro(calculatedPerimeter); // Llama al setter de la superclase FiguraGeometrica
            return calculatedPerimeter;
        } else if (base != 0 && altura != 0) {
            System.out.println("No se puede calcular el perimetro directamente con solo base y altura para un triángulo generico. Se necesitan los tres lados.");
            super.setPerimetro(0.0);
            return 0.0;
        } else {
            System.out.println("No se puede calcular el perimetro para este triangulo: informacion de lados incompleta.");
            super.setPerimetro(0.0);
            return 0.0;
        }
    }

    @Override
    public String toString() {
        // Llama al toString de la superclase FiguraGeometrica
        String baseInfo = super.toString();
        if (base != 0 && altura != 0) {
            return baseInfo + " [Tipo: Por Base/Altura, Base: " + base + ", Altura: " + altura + "]";
        } else if (lado1 != 0 && lado2 != 0 && lado3 != 0) {
            return baseInfo + " [Tipo: Por Lados, Lados: " + lado1 + ", " + lado2 + ", " + lado3 + "]";
        } else {
            return baseInfo + " [Tipo: Triangulo indefinido]";
        }
    }
}
