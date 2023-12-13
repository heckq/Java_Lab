import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Головний клас програми.
 */
public class Main {
    /**
     * Головна функція програми.
     * Створює колоду карт, роздає гравцю 6 карт, а потім дозволяє гравцю викидати або добирати карту з колоди.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        // Створюємо списки мастей та рангів
        List<String> suits = Arrays.asList("♠", "♣", "♥", "♦");
        List<String> ranks = Arrays.asList("6", "7", "8", "9", "10", "J", "Q", "K", "A");
        // Створюємо колоду карт
        List<String> deck = new ArrayList<>();

        // Заповнюємо колоду картами
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + suit);
            }
        }

        // Тасуємо колоду
        Collections.shuffle(deck);

        // Роздаємо гравцю 6 карт
        List<String> playerHand = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            playerHand.add(deck.remove(deck.size() - 1));
        }

        // Створюємо сканер для зчитування вводу гравця
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Сортуємо картки гравця
            Collections.sort(playerHand);
            // Виводимо картки гравця
            System.out.println("Карти гравця: " + playerHand);
            // Запитуємо у гравця, яку картку він хоче викинути
            System.out.println("Введіть номер картки, яку хочете скинути, або 0 для добирання нової картки:");

            // Перевіряємо, чи ввів гравець число
            if (!scanner.hasNextInt()) {
                System.out.println("Будь ласка, введіть число.");
                scanner.next();
                continue;
            }

            // Зчитуємо номер картки, яку гравець хоче викинути
            int cardIndex = scanner.nextInt() - 1;

            // Викидаємо картку або добираємо нову
            if (cardIndex >= 0 && cardIndex < playerHand.size()) {
                String discardedCard = playerHand.remove(cardIndex);
                System.out.println("Ви скинули карту: " + discardedCard);
            } else if (cardIndex == -1) {
                if (!deck.isEmpty()) {
                    playerHand.add(deck.remove(deck.size() - 1));
                    System.out.println("Ви добрали нову карту.");
                } else {
                    System.out.println("Колода порожня, не можна добрати нову карту.");
                }
            } else {
                System.out.println("Неправильний номер картки.");
            }

            // Перевіряємо, чи виграв гравець
            if (playerHand.isEmpty()) {
                System.out.println("Ви виграли! У вас немає карт.");
                break;
            }
        }
    }
}
