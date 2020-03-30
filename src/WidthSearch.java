import java.util.ArrayList;

public class WidthSearch {
    public static void widthSearch(int[][]labyrinth, ArrayList<Integer> open, ArrayList<Integer> closed) {

        int finishLine = Board.getAndSetFinishLine();
        int finishColumn = Board.getAndSetFinishColumn();
        int currentLine, currentColumn;

        link1:
        while (open.get(0) < labyrinth.length || open.get(1) < labyrinth.length) {
            currentLine = open.get(0); currentColumn = open.get(1);
            if (open.get(0) == finishLine & open.get(1) == finishColumn) {
                System.out.println("Персонаж в заданной точке '5'");
                closed.add(currentLine); closed.add(currentColumn);
                labyrinth[currentLine][currentColumn] = 5;
                break;
            }
            open.remove(0);
            open.remove(0);
            for (int index = 0; index < closed.size() - 1; index += 2) {
                if (closed.get(index) == currentLine && closed.get(index + 1) == currentColumn)
                        continue link1;
            }
            if (currentLine < labyrinth.length - 1 && labyrinth[currentLine + 1][currentColumn] == 1) {
                open.add(currentLine + 1); // добавить в конец списка
                open.add(currentColumn);
            }
            if (currentColumn < labyrinth.length - 1 && labyrinth[currentLine][currentColumn + 1] == 1) {
                open.add(currentLine);
                open.add(currentColumn + 1);
            }
            if (currentColumn > 0 && currentColumn < labyrinth.length - 1 & labyrinth[currentLine][currentColumn - 1] == 1) {
                open.add(currentLine);
                open.add(currentColumn - 1);
            }
            if (currentLine > 0 && labyrinth[currentLine - 1][currentColumn] == 1) {
                open.add(currentLine - 1);
                open.add(currentColumn);
            }
            closed.add(currentLine);
            closed.add(currentColumn);
        }
        Board.print(closed, labyrinth);
    }
}
