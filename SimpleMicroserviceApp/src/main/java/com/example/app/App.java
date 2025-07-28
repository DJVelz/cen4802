package com.example.app;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            int a = rand.nextInt(100) + 1;
            int b = rand.nextInt(100) + 1;
            int op = rand.nextInt(3);
            double result = 0;
            String operation = "";

            try {
                switch (op) {
                    case 0:
                        result = a + b;
                        operation = "ADD";
                        break;
                    case 1:
                        result = a - b;
                        operation = "SUBTRACT";
                        break;
                    case 2:
                        result = (double) a / b;
                        operation = "DIVIDE";
                        break;
                }
                String logEntry = String.format("%s | %s: %d and %d = %.2f",
                        LocalDateTime.now(), operation, a, b, result);
                logger.info(logEntry);
                try (FileWriter fw = new FileWriter("logs.txt", true)) {
                    fw.write(logEntry + "\n");
                }
            } catch (Exception e) {
                logger.severe("Exception: " + e.getMessage());
            }
        }
    }
}