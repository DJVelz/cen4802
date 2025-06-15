public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("2 + 3 = " + calc.add(2, 3));
        System.out.println("4 - 1 = " + calc.subtract(4, 1));
        System.out.println("10 / 2 = " + calc.divide(10, 2));
    }
}
