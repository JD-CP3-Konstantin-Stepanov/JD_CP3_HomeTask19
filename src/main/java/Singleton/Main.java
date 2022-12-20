package Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер списка: ");
        int size = scanner.nextInt();

        System.out.print("Введите верхнюю границу для значений: ");
        int upperBound = scanner.nextInt();

        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        StringBuilder listElements = new StringBuilder();

        for(int i = 0; i < size; i++)
        {
            list.add(random.nextInt(upperBound));
            listElements = listOut(size, list.get(i).toString(), listElements);
        }
        System.out.println("Вот случайный список: " + listElements);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int filterMax = scanner.nextInt();

        Filter filter = new Filter(filterMax);
        list = filter.filterOut(list);

        listElements = new StringBuilder();
        for (Integer integer : list) {
            listElements = listOut(size, integer.toString(), listElements);
        }
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + listElements);
        logger.log("Завершаем программу");
        scanner.close();
    }

    private static StringBuilder listOut(int size, String value, StringBuilder listElements){
        if (size != 1){
            listElements = new StringBuilder(listElements + value + " ");
        }
        else {
            listElements = new StringBuilder(listElements + value);
        }
        return listElements;
    }
}
