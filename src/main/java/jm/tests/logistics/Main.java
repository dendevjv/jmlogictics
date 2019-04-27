package jm.tests.logistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>Программа для логистической компании.</h3>
 *
 * Последовательность выполнения программы в консоли:<br><ol>
 * <li>Пользователь вводит грузоподъёмность машины - целое число в килограммах.</li>
 * <li>Пользователь указывает предметы для перевозки в формате название_предмета/вес/цена отделенных пробелом друг
 *      от друга. Описание каждого следующего предмета должно быть отделено пробелом.</li>
 * <li>Программа выводит в консоль названия всех предметов, которые надо загрузить в машину и их суммарную стоимость.</li>
 * </ol>
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int loadCapacity = readCapacity(in);
        List<Item> items = readShipments(in);
        List<Item> selected = new ItemSelectorByCostWeightRatio().select(loadCapacity, items);
        Instruction instruction = new Instruction(selected);
        System.out.println(instruction);
    }

    private static int readCapacity(Scanner in) {
        int loadCapacity = -1;
        boolean reading = true;
        while (reading) {
            System.out.print("Грузоподъемность машины в килограммах: ");
            String loadString = in.nextLine();
            try {
                loadCapacity = Integer.parseInt(loadString);
                if (loadCapacity <= 0) {
                    System.out.println("Грузоподъемность должна быть положительным числом.");
                } else {
                    reading = false;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Неверный формат грузоподъемности: " + loadString);
            }
        }
        return loadCapacity;
    }

    private static List<Item> readShipments(Scanner in) {
        List<Item> items = new ArrayList<>();
        boolean reading = true;
        while (reading) {
            System.out.print("Введите через пробел предметы в формате название/вес/цена: ");
            String input = in.nextLine();
            String[] tokens = input.split(" ");
            try {
                for (String token : tokens) {
                    items.add(Item.parse(token));
                }
                reading = false;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return items;
    }
}
