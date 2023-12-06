/**
 * Підклас, який описує автомобіль типу кабріолет.
 */
class Convertible extends Car {
    private boolean roofOpen; // Стан даху

    /**
     * Конструктор класу.
     *
     * @param model    Модель автомобіля.
     * @param color    Колір автомобіля.
     * @param year     Рік випуску автомобіля.
     * @param price    Ціна автомобіля.
     * @param roofOpen Стан даху.
     */
    public Convertible(String model, String color, int year, double price, boolean roofOpen) {
        super(model, color, year, price); // Виклик конструктора суперкласу
        this.roofOpen = roofOpen;
    }

    /**
     * Метод, який повертає тип автомобіля.
     *
     * @return Тип автомобіля.
     */
    @Override
    String getType() {
        return "Кабріолет";
    }

    /**
     * Метод, який повертає інформацію про автомобіль.
     *
     * @return Інформація про автомобіль.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + // Виклик методу суперкласу
                "\n" + "Дах відкритий: " + (roofOpen ? "Так" : "Ні");
    }
}
