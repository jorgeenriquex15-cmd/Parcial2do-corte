import java.util.Scanner;

public class EjerciciosEmpleados {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Datos Empleado por Horas
        System.out.println("=== EMPLEADO POR HORAS ===");
        System.out.print("Ingrese el nombre: ");
        String nombre1 = sc.nextLine();

        System.out.print("Ingrese el documento: ");
        String doc1 = sc.nextLine();

        System.out.print("Ingrese horas trabajadas: ");
        int horas = sc.nextInt();

        System.out.print("Ingrese valor por hora: ");
        double valorHora = sc.nextDouble();
        sc.nextLine(); 

        Empleado emp1 = new EmpleadoPorHoras(nombre1, doc1, horas, valorHora);

        System.out.println("\n=== EMPLEADO ASALARIADO ===");
        System.out.print("Ingrese el nombre: ");
        String nombre2 = sc.nextLine();

        System.out.print("Ingrese el documento: ");
        String doc2 = sc.nextLine();

        System.out.print("Ingrese salario mensual: ");
        double salario = sc.nextDouble();

        Empleado emp2 = new EmpleadoAsalariado(nombre2, doc2, salario);

        // 3. Resultados
        System.out.println("\n=== RESULTADOS DE PAGO ===");
        System.out.println(emp1 + " | Pago Total: $" + emp1.calcularPago());
        System.out.println(emp2 + " | Pago Total: $" + emp2.calcularPago());

        sc.close();
    }
}

// Clase base abstracta
abstract class Empleado {
    protected String nombre;
    protected String documento;

    public Empleado(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public abstract double calcularPago();

    @Override
    public String toString() {
        return "Empleado: " + nombre + " (Doc: " + documento + ")";
    }
}


class EmpleadoPorHoras extends Empleado {
    private int horas;
    private double valorHora;

    public EmpleadoPorHoras(String nombre, String documento, int horas, double valorHora) {
        super(nombre, documento);
        this.horas = horas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularPago() {
        return horas * valorHora;
    }
}

// Subclase EmpleadoAsalariado
class EmpleadoAsalariado extends Empleado {
    private double salarioMensual;

    public EmpleadoAsalariado(String nombre, String documento, double salarioMensual) {
        super(nombre, documento);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularPago() {
        return salarioMensual;
    }
}