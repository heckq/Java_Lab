/**
 * Підклас, який описує автомобіль типу седан.
 */
class Sedan extends Car {
    private int trunkCapacity; // Об'єм багажника

    /**
     * Конструктор класу.
     *
     * @param model         Модель автомобіля.
     * @param color         Колір автомобіля.
     * @param year          Рік випуску автомобіля.
     * @param price         Ціна автомобіля.
     * @param trunkCapacity Об'єм багажника.
     */
    public Sedan(String model, String color, int year, double price, int trunkCapacity) {
        super(model, color, year, price); // Виклик конструктора суперкласу
        this.trunkCapacity = trunkCapacity;
    }

    /**
     * Метод, який повертає тип автомобіля.
     *
     * @return Тип автомобіля.
     */
    String getType() {
        return "Седан";
    }

    /**
     * Метод, який повертає інформацію про автомобіль.
     *
     * @return Інформація про автомобіль.
     */
    public String getInfo() {
        return super.getInfo() + // Виклик методу суперкласу
                "\n" + "Об'єм багажника: " + trunkCapacity;
    }
}
