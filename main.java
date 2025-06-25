public class main {
    public static void main(String[] args) {
        System.out.println("--- PRUEBA DE POLIMORFISMO ---");
        System.out.println("------------------------------\n");

        // --- 1. Testing de FiguraGeometrica genérica ---
        System.out.println("### 1. Test FiguraGeometrica genérica ###");
        // Se instancia una FiguraGeometrica base.
        // Sus métodos 'area()' y 'perimetro()' llamarán a las implementaciones por defecto.
        FiguraGeometrica figuraGenerica = new FiguraGeometrica("Figura Cualquiera");
        System.out.println("Información: " + figuraGenerica);
        System.out.println("Área (genérica): " + figuraGenerica.area());
        System.out.println("Perímetro (genérica): " + figuraGenerica.perimetro());
        System.out.println("------------------------------\n");


        // --- 2. Testing de Triangulo ---
        System.out.println("### 2. Test Triangulo ###");

        // 2.1. Triángulo usando Constructor 1 (base y altura)
        System.out.println("\nCreando triangulo1 (Base y Altura)...");
        // Este objeto usará el constructor de Triangulo que toma base y altura.
        Triangulo triangulo1 = new Triangulo("Mi Triángulo Base/Altura", 10.0, 5.0);
        System.out.println("Información inicial: " + triangulo1);
        System.out.println("Calculando para " + triangulo1.getNombre() + ":");
        // Las llamadas a 'area()' y 'perimetro()' ejecutarán los métodos sobrescritos en Triangulo.
        System.out.println("  Área: " + triangulo1.area());
        System.out.println("  Perímetro: " + triangulo1.perimetro()); // Este método en Triangulo indicará que necesita los lados
        System.out.println("Información final: " + triangulo1); // 'area' debería estar actualizada en el toString

        // 2.2. Triángulo usando Constructor 2 (tres lados)
        System.out.println("\nCreando triangulo2 (Tres Lados - 3-4-5 Rectángulo)...");
        // Este objeto usará el constructor de Triangulo que toma los tres lados.
        Triangulo triangulo2 = null;
        try {
            triangulo2 = new Triangulo("Triángulo 3-4-5", 3.0, 4.0, 5.0);
            System.out.println("Información inicial: " + triangulo2);
            System.out.println("Calculando para " + triangulo2.getNombre() + ":");
            // Estos métodos ejecutarán las implementaciones de Triangulo basadas en lados.
            System.out.println("  Área: " + triangulo2.area());
            System.out.println("  Perímetro: " + triangulo2.perimetro());
            System.out.println("Información final: " + triangulo2); // 'area' y 'perimetro' deberían estar actualizados
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear triangulo2: " + e.getMessage());
        }

        // 2.3. Triángulo con lados inválidos (prueba de validación del constructor)
        System.out.println("\nIntentando crear triangulo3 (Lados Inválidos - 1-2-5)...");
        Triangulo triangulo3 = null;
        try {
            triangulo3 = new Triangulo("Triángulo Inválido", 1.0, 2.0, 5.0); // Esto debería lanzar una excepción
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado al crear triangulo3: " + e.getMessage());
        }
        System.out.println("------------------------------\n");


        // --- 3. Testing de TrianguloEquilatero ---
        System.out.println("### 3. Test TrianguloEquilatero ###");

        System.out.println("\nCreando trianguloEquilatero1 (Lado 6.0)...");
        // Se instancia un TrianguloEquilatero. Notar que se usa el constructor específico.
        TrianguloEquilatero trianguloEquilatero1 = new TrianguloEquilatero("Triángulo Equilátero L6", 6.0);
        System.out.println("Información inicial: " + trianguloEquilatero1);
        System.out.println("Calculando para " + trianguloEquilatero1.getNombre() + ":");
        // 'area()' y 'perimetro()' llamarán a las implementaciones *específicas* de TrianguloEquilatero.
        System.out.println("  Área: " + trianguloEquilatero1.area());
        System.out.println("  Perímetro: " + trianguloEquilatero1.perimetro());
        System.out.println("Información final: " + trianguloEquilatero1); // Área y perímetro actualizados

        System.out.println("------------------------------\n");


        // --- 4. Demostración de Polimorfismo Dinámico (Referencias de la superclase) ---
        System.out.println("### 4. Demostración de Polimorfismo Dinámico (Referencias) ###");
        // Referencias de tipo 'FiguraGeometrica' apuntando a objetos de sus subclases.
        // Aquí es donde el polimorfismo dinámico brilla:
        // Aunque la referencia es FiguraGeometrica, el método ejecutado será el de la clase real del objeto.
        FiguraGeometrica figuraRef1 = triangulo1; // figuraRef1 es de tipo Triangulo
        FiguraGeometrica figuraRef2 = trianguloEquilatero1; // figuraRef2 es de tipo TrianguloEquilatero

        System.out.println("\nLlamando a métodos a través de referencias de FiguraGeometrica:");
        System.out.println("Figura 1 (Triángulo): Nombre=" + figuraRef1.getNombre() + ", Área=" + figuraRef1.area() + ", Perímetro=" + figuraRef1.perimetro());
        System.out.println("Figura 2 (Triángulo Equilátero): Nombre=" + figuraRef2.getNombre() + ", Área=" + figuraRef2.area() + ", Perímetro=" + figuraRef2.perimetro());

        // Usando la sobrecarga de toString (polimorfismo estático)
        System.out.println("\nUsando la sobrecarga de toString para figuraRef1 (Triángulo):");
        System.out.println(figuraRef1.toString(true));  // Solo área
        System.out.println(figuraRef1.toString(false)); // Solo perímetro

        System.out.println("\nUsando la sobrecarga de toString para figuraRef2 (Triángulo Equilátero):");
        System.out.println(figuraRef2.toString(true));
        System.out.println(figuraRef2.toString(false));

        System.out.println("------------------------------");
        System.out.println("--- FIN DE LA PRUEBA ---");
    }
}
