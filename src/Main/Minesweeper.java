package Main;

import Game_logic.GameController;

/**Метод main() створює новий об’єкт Game_logic.GameController і запускає гру.*/
public class Minesweeper {

    public static void main(String[] args) {
        System.out.println("Правила гри : \n спочатку вводите координати клітинки потім одну з трьох команд :\n free-якщо вважаєте що в клітинці немає міни \n mark-якщо вважаєте що в клітинці є міна \n exit-якщо бажаєте вийти з гри");
        GameController gc = new GameController();
    }
}
