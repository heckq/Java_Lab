package Game_logic;

import java.util.Scanner;


/**Метод makeGuess() запитує користувача про рядок, стовпець та дію, яку він хоче здійснити.
 Якщо користувач вибирає “free”, то метод revealNeighbours() викликається з відповідними параметрами.
 Якщо користувач вибирає “mark”, то метод markCell() викликається з відповідними параметрами.
 Якщо користувач вибирає “exit”, то програма завершується.
 Якщо користувач вибирає будь-яку іншу дію, то виводиться повідомлення про вибір неправильної опції.*/
public class MakeGuess {

    public static void makeGuess() {

        Scanner sc = new Scanner(System.in);
        int row, col;
        String action;

        System.out.print("> ");
        row = sc.nextInt();
        col = sc.nextInt();
        action = sc.next();


        switch (action) {
            case "free" -> Field.revealNeighbours(row - 1, col - 1);
            case "mark" -> Field.markCell(row - 1, col - 1);
            case "exit" -> System.exit(1);
            default -> System.out.println("Select a valid option!");
        }
    }
}
