/**
 * Підклас, який описує автомобіль типу спорткар.
 */
class Sportcar extends Car {
    // Максимальна швидкість
    private double maxSpeed;

    /**
     * Конструктор класу.
     *
     * @param model    Модель автомобіля.
     * @param color    Колір автомобіля.
     * @param year     Рік випуску автомобіля.
     * @param price    Ціна автомобіля.
     * @param maxSpeed Максимальна швидкість.
     */
    public Sportcar(String model, String color, int year, double price, double maxSpeed) {
        super(model, color, year, price);
        this.maxSpeed = maxSpeed;
    }

    /**
     * Метод, який повертає тип автомобіля.
     *
     * @return Тип автомобіля.
     */
    @Override
    String getType() {
        return "Спорткар";
    }

    /**
     * Метод, який повертає інформацію про автомобіль.
     *
     * @return Інформація про автомобіль.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + "\n" + "Максимальна швидкість: " + maxSpeed;
    }
}
