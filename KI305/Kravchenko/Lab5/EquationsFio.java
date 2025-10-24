package KI305.Kravchenko.Lab5;

import KI305.Kravchenko.Lab4.Equations;
import KI305.Kravchenko.Lab4.CalcException;
import java.io.*;
import java.util.Scanner;

public class EquationsFio {
    private double result;

    public void calculate(double x) throws CalcException {
        Equations eq = new Equations();
        result = eq.calculate(x);
    }

    public double getResult() {
        return result;
    }

    public void writeResTxt(String fName) throws IOException {
        try (PrintWriter writer = new PrintWriter(fName)) {
            writer.printf("%.10f%n", result);
        }
    }

    public void readResTxt(String fName) throws IOException {
        try (Scanner sc = new Scanner(new File(fName))) {
            if (sc.hasNextDouble()) result = sc.nextDouble();
        }
    }

    public void writeResBin(String fName) throws IOException {
        System.out.println("➡ Починаю запис у двійковий файл...");
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(fName)))) {
            out.writeDouble(result);
            out.flush();
            System.out.println("✅ Запис у двійковий файл завершено успішно.");
        }
    }

    public void readResBin(String fName) throws IOException {
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream(fName)))) {
            result = in.readDouble();
        }
    }
}
