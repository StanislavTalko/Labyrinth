import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Labyrinth {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите метод поиска: \n1 - в глубину, \n2 - в ширину");
        int method = 0;

        try { method = Integer.parseInt(reader.readLine());
        } catch (IOException e) { e.printStackTrace(); }

        ArrayList<Integer> open = new ArrayList<>();
        ArrayList<Integer> closed =  new ArrayList<>();

        int[][]labyrinth = Board.createLabyrinth();
        open.add(Board.getAndSetStartLine());
        open.add(Board.getAndSetStartColumn());

        switch (method) {
            case 1:
                DepthSearch.depthSearch(labyrinth, open, closed);
                break;
            case 2:
                WidthSearch.widthSearch(labyrinth, open, closed);
                break;
        }
    }
}
