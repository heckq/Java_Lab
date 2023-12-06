/**
 * Підклас, який описує автомобіль типу пікап.
 */
class Pickup extends Car {
    // Вантажопідйомність
    private double loadCapacity;

    /**
     * Конструктор класу.
     *
     * @param model        Модель автомобіля.
     * @param color        Колір автомобіля.
     * @param year         Рік випуску автомобіля.
     * @param price        Ціна автомобіля.
     * @param loadCapacity Вантажопідйомність.
     */
    public Pickup(String model, String color, int year, double price, double loadCapacity) {
        super(model, color, year, price);
        this.loadCapacity = loadCapacity;
    }

    /**
     * Метод, який повертає тип автомобіля.
     *
     * @return Тип автомобіля.
     */
    @Override
    String getType() {
        return "Пікап";
    }

    /**
     * Метод, який повертає інформацію про автомобіль.
     *
     * @return Інформація про автомобіль.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + "\n" + "Вантажопідйомність: " + loadCapacity;
    }
}
