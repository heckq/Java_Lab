/**
 * Підклас, який описує автомобіль типу хетчбек.
 */
class Hatchback extends Car {
    private int doorNumber; // Кількість дверей

    /**
     * Конструктор класу.
     *
     * @param model      Модель автомобіля.
     * @param color      Колір автомобіля.
     * @param year       Рік випуску автомобіля.
     * @param price      Ціна автомобіля.
     * @param doorNumber Кількість дверей.
     */
    public Hatchback(String model, String color, int year, double price, int doorNumber) {
        super(model, color, year, price); // Виклик конструктора суперкласу
        this.doorNumber = doorNumber;
    }

    /**
     * Метод, який повертає тип автомобіля.
     *
     * @return Тип автомобіля.
     */
    @Override
    String getType() {
        return "Хетчбек";
    }

    /**
     * Метод, який повертає інформацію про автомобіль.
     *
     * @return Інформація про автомобіль.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + // Виклик методу суперкласу
                "\n" + "Кількість дверей: " + doorNumber;
    }
}
