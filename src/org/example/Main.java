package org.example;

import java.io.IOException;
import java.util.logging.*;

class DebugMaria {
    // Логгер для записи сообщений о тестировании
    private static final Logger logger = Logger.getLogger(DebugMaria.class.getName());
    static {
        try {
            // Создание обработчика файлового лога с дописыванием в файл
            FileHandler fileHandler = new FileHandler("debug.log", true);//если файл существует то логи записываются внизу этого файла
            fileHandler.setFormatter(new SimpleFormatter()); // вывод логов текстом
            logger.addHandler(fileHandler); // Добавление обработчика к логгеру
            logger.setLevel(Level.ALL); // обработка всех уровней логов
        } catch (IOException e) {
            // В случае ошибки при создании файла логируем в консоль
            System.err.println("Ошибка при создании лог-файла: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        logger.info("Начало тестирования NotDebugKode...");

        // Тестируем метод generateRandomArray с корректным значением
        try {
            logger.info("Тестирование generateRandomArray(10)...");
            int[] arr1 = NotDebugKode.generateRandomArray(10);
            logger.info("Массив успешно сгенерирован.");
        } catch (Exception e) {
            logger.severe("Ошибка в generateRandomArray: " + e.getMessage());
        }

        // Тестируем метод generateRandomArray с некорректным значением (-1)
        try {
            logger.info("Тестирование generateRandomArray(-1)... (ожидается ошибка)");
            NotDebugKode.generateRandomArray(-1);
        } catch (Exception e) {
            logger.info("Ожидаемая ошибка: " + e.getMessage());
        }

        // Тестируем метод printArray с корректным массивом
        try {
            logger.info("Тестирование printArray...");
            int[] testArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
            NotDebugKode.printArray(testArray);
            logger.info("Массив успешно выведен.");
        } catch (Exception e) {
            logger.severe("Ошибка в printArray: " + e.getMessage());
        }

        // Тестируем printArray с null (ожидается ошибка)
        try {
            logger.info("Тестирование printArray(null)... (ожидается ошибка)");
            NotDebugKode.printArray(null);
        } catch (Exception e) {
            logger.info("Ожидаемая ошибка: " + e.getMessage());
        }

        // Тестируем метод findMaxSquareSum с корректным массивом
        try {
            logger.info("Тестирование findMaxSquareSum...");
            int[] testArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
            int result = NotDebugKode.findMaxSquareSum(testArray);
            logger.info("Результат findMaxSquareSum: " + result);
        } catch (Exception e) {
            logger.severe("Ошибка в findMaxSquareSum: " + e.getMessage());
        }

        // Тестируем findMaxSquareSum с массивом из одного элемента (ожидается ошибка)
        try {
            logger.info("Тестирование findMaxSquareSum({5})... (ожидается ошибка)");
            NotDebugKode.findMaxSquareSum(new int[]{5});
        } catch (Exception e) {
            logger.info("Ожидаемая ошибка: " + e.getMessage());
        }

        // Завершение тестирования
        logger.info("Тестирование завершено.");
    }
}
