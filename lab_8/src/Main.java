import java.util.Scanner;

/**
 * Власний клас виключення для віку.
 */
class AgeOutOfRangeException extends Exception {
    /**
     * Конструктор класу AgeOutOfRangeException.
     *
     * @param message Повідомлення про помилку.
     */
    public AgeOutOfRangeException(String message) {
        super(message);
    }
}

/**
 * Власний клас виключення для імені.
 */
class NameLengthException extends Exception {
    /**
     * Конструктор класу NameLengthException.
     *
     * @param message Повідомлення про помилку.
     */
    public NameLengthException(String message) {
        super(message);
    }
}

/**
 * Власний клас виключення для неправильного імені.
 */
class InvalidNameException extends Exception {
    /**
     * Конструктор класу InvalidNameException.
     *
     * @param message Повідомлення про помилку.
     */
    public InvalidNameException(String message) {
        super(message);
    }
}

/**
 * Власний клас виключення для ставки депозиту.
 */
class DepositOutOfRangeException extends Exception {
    /**
     * Конструктор класу DepositOutOfRangeException.
     *
     * @param message Повідомлення про помилку.
     */
    public DepositOutOfRangeException(String message) {
        super(message);
    }
}

/**
 * Клас для перевірки введення користувача.
 */
class InputValidator {
    private Scanner scanner;

    /**
     * Конструктор класу InputValidator.
     */
    public InputValidator() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Метод для отримання та перевірки віку користувача.
     *
     * @return Вік користувача.
     * @throws AgeOutOfRangeException Якщо вік не відповідає вимогам.
     */
    public int getValidAge() throws AgeOutOfRangeException {
        while (!scanner.hasNextInt()) {
            System.out.println("Введіть ціле число:");
            scanner.next();
        }
        int age = scanner.nextInt();
        if (age < 18 || age > 100) {
            throw new AgeOutOfRangeException("Вік повинен бути від 18 до 100 років");
        }
        return age;
    }

    /**
     * Метод для отримання та перевірки імені користувача.
     *
     * @return Ім'я користувача.
     * @throws NameLengthException  Якщо ім'я не відповідає вимогам.
     * @throws InvalidNameException Якщо ім'я містить недопустимі символи.
     */
    public String getValidName() throws NameLengthException, InvalidNameException {
        String name = scanner.nextLine();
        if (name.length() < 2 || name.length() > 100) {
            throw new NameLengthException("Ім'я повинно містити від 2 до 100 символів");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new InvalidNameException("Ім'я може містити лише букви");
        }
        return name;
    }

    /**
     * Метод для отримання та перевірки ставки депозиту користувача.
     *
     * @return Ставка депозиту користувача.
     * @throws DepositOutOfRangeException Якщо ставка депозиту не відповідає вимогам.
     */
    public double getValidDepositRate() throws DepositOutOfRangeException {
        while (!scanner.hasNextDouble()) {
            System.out.println("Введіть дробове число:");
            scanner.next();
        }
        double rate = scanner.nextDouble();
        if (rate < 0.1 || rate > 100.0) {
            throw new DepositOutOfRangeException("Ставка депозиту повинна бути від 0.1 до 100.0");
        }
        return rate;
    }
}

/**
 * Головний клас програми.
 */
public class Main {
    /**
     * Головна функція програми.
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        InputValidator validator = new InputValidator();

        try {
            int age;
            do {
                System.out.println("Введіть свій вік:");
                try {
                    age = validator.getValidAge();
                    System.out.println("Ваш вік: " + age);
                    break;
                } catch (AgeOutOfRangeException e) {
                    System.out.println(e.getMessage());
                }
            } while (true);

            double rate;
            do {
                System.out.println("Введіть ставку депозиту:");
                try {
                    rate = validator.getValidDepositRate();
                    System.out.println("Ваша ставка депозиту: " + rate);
                    break;
                } catch (DepositOutOfRangeException e) {
                    System.out.println(e.getMessage());
                }
            } while (true);

            String name;
            do {
                System.out.println("Введіть своє ім'я:");
                try {
                    name = validator.getValidName();
                    System.out.println("Ваше ім'я: " + name);
                    break;
                } catch (NameLengthException | InvalidNameException e) {
                    System.out.println(e.getMessage());
                }
            } while (true);

        } catch (Exception e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        }
    }
}
