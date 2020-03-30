import java.util.ArrayList;

public class DepthSearch {
    public static void depthSearch(int[][]labyrinth, ArrayList<Integer> open, ArrayList<Integer> closed) {

        int finishLine = Board.getAndSetFinishLine();
        int finishColumn = Board.getAndSetFinishColumn();
        int currentLine, currentColumn;

        link1:
        while (open.get(0) < labyrinth.length | open.get(1) < labyrinth.length) {
            currentLine = open.get(0); currentColumn = open.get(1);
            if (open.get(0) == finishLine & open.get(1) == finishColumn) {
                System.out.println("Персонаж в заданной точке '4'");
                closed.add(currentLine); closed.add(currentColumn);
                labyrinth[currentLine][currentColumn] = 4;
                break;
            }
            open.remove(0);
            open.remove(0);
            for (int index = 0; index < closed.size() - 1; index += 2)
                if (closed.get(index) == currentLine && closed.get(index + 1) == currentColumn)
                    continue link1; // перейти к link1
            if (currentLine < labyrinth.length - 1 && labyrinth[currentLine + 1][currentColumn] == 1) {
                open.add(0, currentColumn);
                open.add(0, currentLine + 1);
            }
            if (currentColumn < labyrinth.length - 1 && labyrinth[currentLine][currentColumn + 1] == 1) {
                open.add(0, currentColumn + 1);
                open.add(0, currentLine);
            }
            if (currentColumn > 0 && currentColumn < labyrinth.length - 1 & labyrinth[currentLine][currentColumn - 1] == 1) {
                open.add(0, currentColumn - 1);
                open.add(0, currentLine);
            }
            if (currentLine > 0 && labyrinth[currentLine - 1][currentColumn] == 1) {
                open.add(0, currentColumn);
                open.add(0, currentLine - 1);
            }
            closed.add(currentLine);
            closed.add(currentColumn);
        }
        Board.print(closed, labyrinth);
    }
}
