public class FibonacciCalculator {

    /**
     * Returns the nth term in a Fibonacci sequence
     * @param n the term that will be used for the sequence
     * @return the value of the term after calculating the sequence
     */
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;
        int result = fibonacci(n);
        System.out.println("The " + n + "th term of the fibonacci sequence is " + result + ".");
    }
}
