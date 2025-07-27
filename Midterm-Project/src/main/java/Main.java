import org.apache.logging.log4j.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        try {
            int result = calc.add(2, 3);
            logger.info("Operation=ADD, Inputs=2,3, Result={}", result);
        } catch (Exception e) {
            logger.error("ADD operation failed", e);
        }

        try {
            int result = calc.divide(10, 0);
            logger.info("Operation=DIVIDE, Inputs=10,0, Result={}", result);
        } catch (Exception e) {
            logger.error("DIVIDE operation failed", e);
        }

        System.out.println("2 + 3 = " + calc.add(2, 3));
        System.out.println("4 - 1 = " + calc.subtract(4, 1));
        System.out.println("10 / 2 = " + calc.divide(10, 2));
    }
}
