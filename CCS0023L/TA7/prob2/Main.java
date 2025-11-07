package TA7.prob2;

public class Main {
    public static void main(String[] args) {
        Arithmetic math = new Arithmetic();

        System.out.println("add(1, 3) = " + math.add(1, 3));
        System.out.println("add(1, 3, 4, 5) = " + math.add(1, 3, 4, 5));
        System.out.println("multiply(2, 3, 4) = " + math.multiply(2, 3, 4));
        System.out.println("multiply(1, 1) = " + math.multiply(1, 1));
        System.out.println("subtract(3, 1) = " + math.subtract(3, 1));
        System.out.println("divide(5, 2) = " + math.divide(5, 2));
    }
}

class Arithmetic {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int multiply(int a, int b, int c) {
        return a * b * c;
    }

    public int multiply(int a, int b, int c, int d) {
        return a * b * c * d;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0;
        }
        return (double) a / b;
    }
}

