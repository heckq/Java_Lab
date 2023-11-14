package Game_logic;

import java.util.Scanner;

/**метод який відповідає за створення гри, і за вивід її результатів*/public class GameController {
    Field field;
    int size, nMines;

    public GameController() {
        initGame();
        gameLoop();
    }

    /**Метод initGame() ініціалізує гру, запитуючи користувача про розмір
     поля та кількість мін, а потім створює новий об’єкт Game_logic.Field*/
    private void initGame() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Field size > ");
        this.size = sc.nextInt();
        System.out.print("Number of mines > ");
        this.nMines = sc.nextInt();
        this.field = new Field(size, nMines);
    }

    /**Метод gameLoop() запускає головний цикл гри, доки всі міни не будуть
    знайдені або не буде виявлено міну. Якщо всі міни знайдені, гра закінчується з
    повідомленням про перемогу. Якщо виявлено міну, гра закінчується з повідомленням про поразку.*/
    private void gameLoop() {

        while(!Field.minesRevealed) {
            field.printField();
            MakeGuess.makeGuess();
            field.checkMarkedMines();

            if(field.allMinesMarked) {
                break;
            }
        }

        if(Field.minesRevealed) {
            field.printField();
            System.out.println("You lost!");
        } else {
            field.printField();
            System.out.println("You found all the mines!");
        }
    }
}
