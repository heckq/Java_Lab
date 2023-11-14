package Game_logic;

import java.util.Objects;
import java.util.Random;

/** клас який відповідає за створення поля, мін, і дій на полі*/
public class Field {
    /** Масив, що містить ігрове поле*/static Cell[][] field;
    /** Розмір ігрового поля*/int size;
    /**Кількість мін на ігровому полі*/int nMines;
    /** Поле, що відповідає за відображення мін на ігровому полі*/public static boolean minesRevealed = false;
    /**Поле, що відповідає за позначення всіх мін на ігровому полі*/ public boolean allMinesMarked = false;

    /**Конструктор класу Game_logic.Field*/public Field (int size, int nMines) {
        //Ініціалізація поля size
        this.size = size;
        //Ініціалізація поля nMines
        this.nMines = nMines;

        //Генерація ігрового поля
        generateField();
       //Пошук мін на ігровому полі
        findMines();
    }

    /**Метод, що виводить на екран поточний стан ігрового поля*/
    public void printField() {
        System.out.println();
        System.out.print("  | ");
        for(int i = 0; i < size; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();

        System.out.println(new String(new char[(size*2)+3]).replace('\0', '_'));
        for(int row = 0; row < field.length; row++) {
            System.out.print(row+1 + " | ");
            for(int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col].getStatus() + " ");
            }
            System.out.println();
        }
    }

    /**Метод, що перевіряє, чи всі міни на полі позначені як "?"*/
    public void checkMarkedMines() {
        int auxCounter = 0;
        for (Cell[] cells : field) {
            for (Cell cell : cells) {
                if (Objects.equals(cell.getValue(), "X") && Objects.equals(cell.getPlaceholder(), "?")) {
                    auxCounter++;
                }
            }
        }

        this.allMinesMarked = auxCounter == nMines;
    }
    /**Метод що генерує поле, міни.*/
    public void generateField() {

        Random random = new Random();

        field = new Cell[size][size]; // Ініціалізація масиву field
        for (Cell[] row: field) // Ініціалізація рядків масиву
            for(int cell = 0; cell < row.length; cell++) { // Ініціалізація комірок масиву
                row[cell] = new Cell();
            }

        // генерація мін
        int minesToAdd = nMines;
        while(minesToAdd > 0) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);

            // якщо клітинка не містить міни
            if (!Objects.equals(field[x][y].getValue(), "X")) {
                field[x][y].setValue("X"); // Встановлення значення комірки на "X", тобто ставимо міну
                minesToAdd--;//зменшуємо кількість мін які залишилось поставити
            }
        }
    }

    /**метод findMines(), перевіряє кожну комірку на ігровому полі,
    щоб знайти міни та встановити значення поля auxCounter відповідно.
    Якщо значення поля auxCounter більше 0, то встановлюється значення комірки на auxCounter.*/
    public void findMines() {

        int auxCounter = 0;

        for(int row = 0; row < field.length; row++) {
            for(int col = 0; col < field[row].length; col++) {
                if(Objects.equals(field[row][col].getValue(), ".")) {
                    if(row != 0 && col != 0 && Objects.equals(field[row - 1][col - 1].getValue(), "X")) {
                        auxCounter++;
                    }
                    if(row != 0 && Objects.equals(field[row - 1][col].getValue(), "X")) {
                        auxCounter++;
                    }
                    if(row != 0 && col != field[row].length-1 && Objects.equals(field[row - 1][col + 1].getValue(), "X")) {
                        auxCounter++;
                    }
                    if(col != 0 && Objects.equals(field[row][col - 1].getValue(), "X")) {
                        auxCounter++;
                    }
                    if(col != field[row].length-1 && Objects.equals(field[row][col + 1].getValue(), "X")) {
                        auxCounter++;
                    }
                    if(row != field.length-1 && col != 0 && Objects.equals(field[row + 1][col - 1].getValue(), "X")) {
                        auxCounter++;
                    }
                    if(row != field.length-1 && Objects.equals(field[row + 1][col].getValue(), "X")) {
                        auxCounter++;
                    }
                    if(row != field.length-1 && col != field.length-1 && Objects.equals(field[row + 1][col + 1].getValue(), "X")) {
                        auxCounter++;
                    }
                }
                if (auxCounter > 0) {
                    field[row][col].setValue(String.valueOf(auxCounter));
                }
                auxCounter = 0;
            }
        }
    }

    /**метод revealNeighbours(), який відкриває всі сусідні комірки,
    якщо вибрана комірка не містить міну. Якщо вибрана комірка містить міну,
    то гра закінчується. Якщо вибрана комірка має число, то вона стає видимою.*/
    public static void revealNeighbours(int row, int col) {

        String selectedCellValue = field[row][col].getValue();
        switch (selectedCellValue) {
            case "." -> {
                field[row][col].setValue("/");
                field[row][col].enableVisibility();
            }
            case "X" -> {
                Field.minesRevealed = true;
                field[row][col].setValue("X");
                field[row][col].enableVisibility();
                return;
            }
            default -> {
                field[row][col].enableVisibility();
                return;
            }
        }
        if(row != 0 && col != 0) {
            String cellValue = field[row - 1][col - 1].getValue();
            switch(cellValue) {
                case ".":
                    revealNeighbours(row-1, col-1);
                    break;
                case "X":
                    break;
                default:
                    field[row - 1][col - 1].enableVisibility();
            }
        }
        if(row != 0) {
            String cellValue = field[row - 1][col].getValue();
            switch(cellValue) {
                case ".":
                    revealNeighbours(row-1, col);
                    break;
                case "X":
                    break;
                default:
                    field[row - 1][col].enableVisibility();
            }
        }
        if(row != 0 && col != field[row].length-1) {
            String cellValue = field[row - 1][col+1].getValue();
            switch(cellValue) {
                case ".":
                    revealNeighbours(row-1, col+1);
                    break;
                case "X":
                    break;
                default:
                    field[row - 1][col+1].enableVisibility();
            }
        }
        if(col != 0) {
            String cellValue = field[row][col-1].getValue();
            switch(cellValue) {
                case ".":
                    revealNeighbours(row, col-1);
                    break;
                case "X":
                    break;
                default:
                    field[row][col-1].enableVisibility();
            }
        }
        if(col != field[row].length-1) {
            String cellValue = field[row][col+1].getValue();
            switch(cellValue) {
                case ".":
                    revealNeighbours(row, col+1);
                    break;
                case "X":
                    break;
                default:
                    field[row][col+1].enableVisibility();
            }
        }
        if(row != field.length-1 && col != 0) {
            String cellValue = field[row + 1][col-1].getValue();
            switch(cellValue) {
                case ".":
                    revealNeighbours(row+1, col-1);
                    break;
                case "X":
                    break;
                default:
                    field[row + 1][col-1].enableVisibility();
            }
        }
        if(row != field.length-1) {
            String cellValue = field[row + 1][col].getValue();
            switch(cellValue) {
                case ".":
                    revealNeighbours(row+1, col);
                    break;
                case "X":
                    break;
                default:
                    field[row + 1][col].enableVisibility();
            }
        }
        if(row != field.length-1 && col != field.length-1) {
            String cellValue = field[row + 1][col+1].getValue();
            switch(cellValue) {
                case ".":
                    revealNeighbours(row+1, col+1);
                    break;
                case "X":
                    break;
                default:
                    field[row + 1][col+1].enableVisibility();
            }
        }
    }

    /**метод markCell відповідає за дію mark, тобто він помічає клітинку в якій, на думку гравця знаходиться міна*/
    public static void markCell(int row, int col) {

        field[row][col].setPlaceholder("?");
    }
}
