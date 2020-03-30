import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Board {
    private static int currentIndex = -1;

    public static int[][] createLabyrinth() {
        try {
            FileInputStream inputStream = new FileInputStream("board.txt");
            byte[] str = new byte[inputStream.available()];
            inputStream.read(str);
            String text = new String(str);

            String[] numbers = text.split("\\D");
            int labyrinthSize = next(numbers);
            int[][] board = new int[labyrinthSize][labyrinthSize];

            for (int i = 0; i < labyrinthSize; ++i) {
                for (int j = 0; j < labyrinthSize; ++j) {
                    board[i][j] = next(numbers);
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            inputStream.close();
            return  board;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Integer next(String[] numbers) {
        ++currentIndex;
        while (currentIndex < numbers.length
                && numbers[currentIndex].equals(""))
            ++currentIndex;
        return currentIndex < numbers.length ? Integer
                .parseInt(numbers[currentIndex]) : null;
    }

    public static void print(ArrayList<Integer> close, int[][]labyrinth) {
        System.out.println("\nВывод пути:");
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth.length; j++) {
                for (int j_index = 0; j_index < close.size() - 1; j_index += 2) {
                    if (close.get(j_index) == i && close.get(j_index + 1) == j) {
                        System.out.print(labyrinth[i][j]);
                        break;
                    }
                }
                if (labyrinth[i][j] ==0)
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("Весь лабиринт:");
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth.length; j++) {
                System.out.print(labyrinth[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int getAndSetFinishLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Введите конечную строку: ");
            return (Integer.parseInt(reader.readLine()) - 1);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getAndSetFinishColumn() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Введите конечный столбец: ");
            return (Integer.parseInt(reader.readLine()) - 1);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getAndSetStartLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Введите начальную строку: ");
            return (Integer.parseInt(reader.readLine()) - 1);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getAndSetStartColumn() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Введите начальный столбец: ");
            return (Integer.parseInt(reader.readLine()) - 1);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
