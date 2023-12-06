/**
 * Абстрактний клас, який описує загальні характеристики автомобіля.
 */
public abstract class Car {
    protected String model; // Модель автомобіля
    protected String color; // Колір автомобіля
    protected int year; // Рік випуску автомобіля
    protected double price; // Ціна автомобіля

    /**
     * Конструктор класу.
     *
     * @param model Модель автомобіля.
     * @param color Колір автомобіля.
     * @param year  Рік випуску автомобіля.
     * @param price Ціна автомобіля.
     */
    public Car(String model, String color, int year, double price) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    /**
     * Абстрактний метод, який повертає тип автомобіля.
     *
     * @return Тип автомобіля.
     */
    abstract String getType();

    /**
     * Звичайний метод, який повертає інформацію про автомобіль.
     *
     * @return Інформація про автомобіль.
     */
    public String getInfo() {
        return "Модель: " + model + "\n" + "Колір: " +
                color + "\n" + "Рік: " + year + "\n" +
                "Ціна: " + price + "\n" + "Тип: " + getType();
    }
}