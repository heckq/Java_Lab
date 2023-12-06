import java.util.Scanner;

/**
 * Головний клас програми.
 */
public class CarDemo {
    /**
     * Головний метод програми.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        // Створення масиву автомобілів
        Car[] cars = new Car[6];
        cars[0] = new Sedan("Toyota Camry", "Білий", 2021, 30000, 500);
        cars[1] = new Hatchback("Ford Fiesta", "Червоний", 2019, 15000, 5);
        cars[2] = new Crossover("Nissan Qashqai", "Сірий", 2020, 25000, true);
        cars[3] = new Convertible("BMW Z4", "Синій", 202, 40000, false);
        cars[4] = new Pickup("Ford F-150", "Чорний", 2021, 35000, 1000);
        cars[5] = new Sportcar("Lamborghini Aventador", "Жовтий", 2022, 500000, 350);

        // Створення сканера для зчитування вводу користувача
        Scanner scanner = new Scanner(System.in);
        System.out.println("Оберіть опцію:");
        System.out.println("1. Переглянути список доступних автомобілів");
        System.out.println("2. Переглянути детальну інформацію про певний автомобіль");
        System.out.println("3. Вийти з програми");
        boolean fl = true;
        while (fl) {
            // Зчитування вибору користувача
            int choice = scanner.nextInt();
            switch (choice) {
                case 0 -> {
                    System.out.println("Оберіть опцію:");
                    System.out.println("1. Переглянути список доступних автомобілів");
                    System.out.println("2. Переглянути детальну інформацію про певний автомобіль");
                    System.out.println("3. Вийти з програми");
                }
                case 1 -> {
                    System.out.println("Список доступних автомобілів:");
                    for (int i = 0; i < cars.length; i++) {
                        System.out.println((i + 1) + ". " + cars[i].model + " (" + cars[i].getType() + ")");
                    }
                    System.out.println("повернутись в меню(натисніть '0')");
                }
                case 2 -> {
                    System.out.println("Введіть номер автомобіля, про який ви хочете дізнатися більше (від 1 до 6):");
                    int number = scanner.nextInt();
                    if (number >= 1 && number <= 6) {
                        System.out.println("Детальна інформація про автомобіль:");
                        System.out.println(cars[number - 1].getInfo());
                        System.out.println("повернутись в меню(натисніть '0')");
                    } else {
                        System.out.println("Неправильний номер автомобіля!");
                    }
                }
                case 3 -> fl = false;
                default -> System.out.println("Невірний вибір! Спробуйте ще раз!");
            }
        }
        scanner.close();
    }
}
