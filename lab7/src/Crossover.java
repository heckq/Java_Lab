/**
 * Підклас, який описує автомобіль типу кросовер.
 */
class Crossover extends Car {
    private boolean fourWheelDrive; // Наявність повного приводу

    /**
     * Конструктор класу.
     *
     * @param model          Модель автомобіля.
     * @param color          Колір автомобіля.
     * @param year           Рік випуску автомобіля.
     * @param price          Ціна автомобіля.
     * @param fourWheelDrive Наявність повного приводу.
     */
    public Crossover(String model, String color, int year, double price, boolean fourWheelDrive) {
        super(model, color, year, price); // Виклик конструктора суперкласу
        this.fourWheelDrive = fourWheelDrive;
    }

    /**
     * Метод, який повертає тип автомобіля.
     *
     * @return Тип автомобіля.
     */
    @Override
    String getType() {
        return "Кросовер";
    }

    /**
     * Метод, який повертає інформацію про автомобіль.
     *
     * @return Інформація про автомобіль.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + // Виклик методу суперкласу
                "\n" + "Повний привід: " + (fourWheelDrive ? "Так" : "Ні");
    }
}
