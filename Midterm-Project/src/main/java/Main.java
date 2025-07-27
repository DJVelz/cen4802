import org.apache.logging.log4j.*;

import java.util.Random;

public class Main {
    private static final Logger logger = LogManager.getLogger("calculate");

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int a = random.nextInt(10);
            int b = random.nextInt(10);
            int operation = random.nextInt(3);

            try {
                int result = 0;
                switch (operation) {
                    case 0:
                        result = calc.add(a, b);
                        logger.info("Operation=ADD, Inputs=" + a + "," + b + ", Result=" + result);
                        break;
                    case 1:
                        result = calc.subtract(a, b);
                        logger.info("Operation=SUBTRACT, Inputs=" + a + "," + b + ", Result=" + result);
                        break;
                    case 2:
                        result = calc.divide(a, b);
                        logger.info("Operation=DIVIDE, Inputs=" + a + "," + b + ", Result=" + result);
                        break;
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }
}
