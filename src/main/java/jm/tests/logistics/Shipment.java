package jm.tests.logistics;

import java.util.Objects;

/**
 * Товар предназначенный для доставки.
 */
public class Shipment {
    private final String name;
    private final int weight;
    private final int cost;

    public Shipment(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    /**
     * Создает экземпляр Shipment используя строковое представление.
     * @param s строковое представление в формате название/вес/цена
     * @return экземпляр
     */
    public static Shipment parse(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Отсутствует описание предмета: " + s);
        }
        String[] tokens = s.split("/");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Неполное описание предмета: " + s);
        }
        String name = tokens[0];
        int cost, weight;
        try {
            weight = Integer.parseInt(tokens[1]);
            cost = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Некорректное описание предмета: " + s, nfe);
        }
        return new Shipment(name, weight, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return cost == shipment.cost &&
                weight == shipment.weight &&
                Objects.equals(name, shipment.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, weight);
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}
