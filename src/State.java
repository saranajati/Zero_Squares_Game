import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class State {
    public static final String RESET = "\033[0m";
    public static String COLOR = "";
    ArrayList<ArrayList<Square>> levelBoard;
    static int rows, columns;
    public int cost = 1;

    public int getCost() {
        return cost;
    }

    State() {
    }

    State(State another) {
        this.levelBoard = new ArrayList<>();
        for (ArrayList<Square> row : another.levelBoard) {
            ArrayList<Square> anotherRow = new ArrayList<>();
            for (Square square : row) {
                anotherRow.add(new Square(square));
            }
            this.levelBoard.add(anotherRow);
        }
    }

    ArrayList<ArrayList<Square>> board1 = new ArrayList<>();
    {
    for (int i = 0; i < 8; i++) {
    ArrayList<Square> row = new ArrayList<>();
    for (int j = 0; j < 11; j++) {
    row.add(new Square());
    }
    board1.add(row);
    }
    board1.get(0).get(0).setBlock(true);
    board1.get(0).get(1).setBlock(true);
    board1.get(0).get(2).setBlock(true);
    board1.get(0).get(3).setBlock(true);
    board1.get(0).get(4).setBlock(true);
    board1.get(0).get(5).setBlock(true);
    board1.get(0).get(6).setBlock(true);
    board1.get(0).get(7).setBlock(true);
    board1.get(0).get(8).setBlock(true);
    board1.get(1).get(8).setBlock(true);
    board1.get(2).get(0).setBlock(true);
    board1.get(2).get(8).setBlock(true);
    board1.get(2).get(9).setBlock(true);
    board1.get(2).get(10).setBlock(true);
    board1.get(3).get(0).setBlock(true);
    board1.get(3).get(10).setBlock(true);
    board1.get(4).get(0).setBlock(true);
    board1.get(4).get(8).setBlock(true);
    board1.get(4).get(10).setBlock(true);
    board1.get(5).get(0).setBlock(true);
    board1.get(5).get(1).setBlock(true);
    board1.get(5).get(2).setBlock(true);
    board1.get(5).get(4).setBlock(true);
    board1.get(5).get(5).setBlock(true);
    board1.get(5).get(6).setBlock(true);
    board1.get(5).get(8).setBlock(true);
    board1.get(5).get(10).setBlock(true);
    board1.get(6).get(2).setBlock(true);
    board1.get(6).get(10).setBlock(true);
    board1.get(7).get(2).setBlock(true);
    board1.get(7).get(3).setBlock(true);
    board1.get(7).get(4).setBlock(true);
    board1.get(7).get(5).setBlock(true);
    board1.get(7).get(6).setBlock(true);
    board1.get(7).get(7).setBlock(true);
    board1.get(7).get(8).setBlock(true);
    board1.get(7).get(9).setBlock(true);
    board1.get(7).get(10).setBlock(true);
    board1.get(1).get(0).setTrap(true);
    board1.get(1).get(1).setGoal(true);
    board1.get(1).get(1).setGoalColor("white");
    board1.get(1).get(2).setGoal(true);
    board1.get(1).get(2).setGoalColor("blue");
    board1.get(2).get(1).setGoal(true);
    board1.get(2).get(1).setGoalColor("green");
    board1.get(1).get(7).setCube(true);
    board1.get(1).get(7).setCubeColor("red");
    board1.get(4).get(3).setCube(true);
    board1.get(4).get(3).setCubeColor("blue");
    board1.get(4).get(4).setCube(true);
    board1.get(4).get(4).setCubeColor("green");
    board1.get(0).get(9).setOut(true);
    board1.get(0).get(10).setOut(true);
    board1.get(1).get(9).setOut(true);
    board1.get(1).get(10).setOut(true);
    board1.get(6).get(0).setOut(true);
    board1.get(6).get(1).setOut(true);
    board1.get(7).get(0).setOut(true);
    board1.get(7).get(1).setOut(true);
    for (int i = 0; i < 8; i++) {
    for (int j = 0; j < 11; j++) {
    if (board1.get(i).get(j).block == false && board1.get(i).get(j).out == false
    &&
    board1.get(i).get(j).goal == false
    && board1.get(i).get(j).cube == false && board1.get(i).get(j).trap == false)
    {
    board1.get(i).get(j).setRoad(true);
    }
    }
    }
    }

    ArrayList<ArrayList<Square>> board2 = new ArrayList<>();
    {
    for (int i = 0; i < 7; i++) {
    ArrayList<Square> row = new ArrayList<>();
    for (int j = 0; j < 11; j++) {
    row.add(new Square());
    }
    board2.add(row);
    }
    board2.get(0).get(0).setBlock(true);
    board2.get(0).get(1).setBlock(true);
    board2.get(0).get(2).setBlock(true);
    board2.get(0).get(3).setBlock(true);
    board2.get(0).get(4).setBlock(true);
    board2.get(0).get(5).setBlock(true);
    board2.get(0).get(6).setBlock(true);
    board2.get(0).get(7).setBlock(true);
    board2.get(0).get(8).setBlock(true);
    board2.get(0).get(9).setBlock(true);
    board2.get(0).get(10).setBlock(true);
    board2.get(1).get(0).setBlock(true);
    board2.get(1).get(10).setBlock(true);
    board2.get(2).get(0).setBlock(true);
    board2.get(2).get(10).setBlock(true);
    board2.get(3).get(0).setBlock(true);
    board2.get(3).get(1).setBlock(true);
    board2.get(3).get(10).setBlock(true);
    board2.get(4).get(1).setBlock(true);
    board2.get(4).get(6).setBlock(true);
    board2.get(4).get(7).setBlock(true);
    board2.get(4).get(8).setBlock(true);
    board2.get(4).get(9).setBlock(true);
    board2.get(4).get(10).setBlock(true);
    board2.get(5).get(1).setBlock(true);
    board2.get(5).get(6).setBlock(true);
    board2.get(6).get(1).setBlock(true);
    board2.get(6).get(2).setBlock(true);
    board2.get(6).get(3).setBlock(true);
    board2.get(6).get(4).setBlock(true);
    board2.get(6).get(5).setBlock(true);
    board2.get(6).get(6).setBlock(true);
    board2.get(2).get(6).setGoal(true);
    board2.get(2).get(6).setGoalColor("yellow");
    board2.get(3).get(5).setGoal(true);
    board2.get(3).get(5).setGoalColor("green");
    board2.get(4).get(4).setGoal(true);
    board2.get(4).get(4).setGoalColor("blue");
    board2.get(5).get(3).setGoal(true);
    board2.get(5).get(3).setGoalColor("red");
    board2.get(1).get(1).setCube(true);
    board2.get(1).get(1).setCubeColor("yellow");
    board2.get(1).get(2).setCube(true);
    board2.get(1).get(2).setCubeColor("red");
    board2.get(1).get(3).setCube(true);
    board2.get(1).get(3).setCubeColor("blue");
    board2.get(1).get(4).setCube(true);
    board2.get(1).get(4).setCubeColor("green");
    board2.get(4).get(0).setOut(true);
    board2.get(5).get(0).setOut(true);
    board2.get(5).get(7).setOut(true);
    board2.get(5).get(8).setOut(true);
    board2.get(5).get(9).setOut(true);
    board2.get(5).get(10).setOut(true);
    board2.get(6).get(0).setOut(true);
    board2.get(6).get(7).setOut(true);
    board2.get(6).get(8).setOut(true);
    board2.get(6).get(9).setOut(true);
    board2.get(6).get(10).setOut(true);
    for (int i = 0; i < 7; i++) {
    for (int j = 0; j < 11; j++) {
    if (!board2.get(i).get(j).block && !board2.get(i).get(j).out &&
    !board2.get(i).get(j).goal
    && !board2.get(i).get(j).cube && !board2.get(i).get(j).trap) {
    board2.get(i).get(j).setRoad(true);
    }
    }
    }
    }

    ArrayList<ArrayList<Square>> board3 = new ArrayList<>();
    {
    for (int i = 0; i < 7; i++) {
    ArrayList<Square> row = new ArrayList<>();
    for (int j = 0; j < 7; j++) {
    row.add(new Square());
    }
    board3.add(row);
    }
    board3.get(0).get(3).setBlock(true);
    board3.get(0).get(4).setBlock(true);
    board3.get(0).get(5).setBlock(true);
    board3.get(0).get(6).setBlock(true);
    board3.get(5).get(0).setBlock(true);
    board3.get(6).get(0).setBlock(true);
    board3.get(6).get(1).setBlock(true);
    board3.get(6).get(2).setBlock(true);
    board3.get(6).get(3).setBlock(true);
    board3.get(6).get(4).setBlock(true);
    board3.get(6).get(5).setBlock(true);
    board3.get(6).get(6).setBlock(true);
    board3.get(2).get(0).setBlock(true);
    board3.get(3).get(0).setBlock(true);
    board3.get(3).get(4).setBlock(true);
    board3.get(4).get(0).setBlock(true);
    board3.get(4).get(4).setBlock(true);
    board3.get(1).get(6).setBlock(true);
    board3.get(2).get(6).setBlock(true);
    board3.get(3).get(6).setBlock(true);
    board3.get(4).get(6).setBlock(true);
    board3.get(5).get(6).setBlock(true);
    board3.get(1).get(0).setOut(true);
    board3.get(0).get(0).setOut(true);
    board3.get(0).get(1).setOut(true);
    board3.get(1).get(0).setOut(true);
    board3.get(0).get(2).setTrap(true);
    board3.get(1).get(1).setTrap(true);
    board3.get(2).get(0).setTrap(true);
    board3.get(4).get(1).setCube(true);
    board3.get(4).get(1).setCubeColor("red");
    board3.get(5).get(1).setCube(true);
    board3.get(5).get(1).setCubeColor("blue");
    board3.get(2).get(1).setGoal(true);
    board3.get(2).get(1).setGoalColor("red");
    board3.get(1).get(3).setGoal(true);
    board3.get(1).get(3).setGoalColor("blue");
    for (int i = 0; i < 7; i++) {
    for (int j = 0; j < 7; j++) {
    if (!board3.get(i).get(j).block && !board3.get(i).get(j).out &&
    !board3.get(i).get(j).goal
    && !board3.get(i).get(j).cube && !board3.get(i).get(j).trap) {
    board3.get(i).get(j).setRoad(true);
    }
    }
    }
    }

    // ArrayList<ArrayList<Square>> board1 = new ArrayList<>();
    // {
    //     for (int i = 0; i < 8; i++) {
    //         ArrayList<Square> row = new ArrayList<>();
    //         for (int j = 0; j < 12; j++) {
    //             row.add(new Square());
    //         }
    //         board1.add(row);
    //     }
    //     board1.get(0).get(2).setBlock(true);
    //     board1.get(0).get(3).setBlock(true);
    //     board1.get(0).get(4).setBlock(true);
    //     board1.get(0).get(5).setBlock(true);
    //     board1.get(0).get(6).setBlock(true);
    //     board1.get(0).get(7).setBlock(true);
    //     board1.get(0).get(8).setBlock(true);
    //     board1.get(0).get(9).setBlock(true);
    //     board1.get(1).get(1).setBlock(true);
    //     board1.get(1).get(2).setBlock(true);
    //     board1.get(1).get(9).setBlock(true);
    //     board1.get(1).get(10).setBlock(true);
    //     board1.get(2).get(0).setBlock(true);
    //     board1.get(2).get(1).setBlock(true);
    //     board1.get(2).get(4).setBlock(true);
    //     board1.get(2).get(7).setBlock(true);
    //     board1.get(2).get(10).setBlock(true);
    //     board1.get(2).get(11).setBlock(true);
    //     board1.get(3).get(0).setBlock(true);
    //     board1.get(3).get(3).setBlock(true);
    //     board1.get(3).get(8).setBlock(true);
    //     board1.get(3).get(11).setBlock(true);
    //     board1.get(4).get(0).setBlock(true);
    //     board1.get(4).get(5).setBlock(true);
    //     board1.get(4).get(8).setBlock(true);
    //     board1.get(4).get(9).setBlock(true);
    //     board1.get(4).get(11).setBlock(true);
    //     board1.get(5).get(0).setBlock(true);
    //     board1.get(5).get(2).setBlock(true);
    //     board1.get(5).get(4).setBlock(true);
    //     board1.get(5).get(5).setBlock(true);
    //     board1.get(5).get(9).setBlock(true);
    //     board1.get(5).get(11).setBlock(true);
    //     board1.get(6).get(0).setBlock(true);
    //     board1.get(6).get(4).setBlock(true);
    //     board1.get(6).get(11).setBlock(true);
    //     board1.get(7).get(0).setBlock(true);
    //     board1.get(7).get(1).setBlock(true);
    //     board1.get(7).get(2).setBlock(true);
    //     board1.get(7).get(3).setBlock(true);
    //     board1.get(7).get(4).setBlock(true);
    //     board1.get(7).get(5).setBlock(true);
    //     board1.get(7).get(6).setBlock(true);
    //     board1.get(7).get(7).setBlock(true);
    //     board1.get(7).get(8).setBlock(true);
    //     board1.get(7).get(9).setBlock(true);
    //     board1.get(7).get(10).setBlock(true);
    //     board1.get(7).get(11).setBlock(true);
    //     board1.get(3).get(5).setGoal(true);
    //     board1.get(3).get(5).setGoalColor("red");
    //     board1.get(2).get(6).setGoal(true);
    //     board1.get(2).get(6).setGoalColor("blue");
    //     board1.get(5).get(1).setCube(true);
    //     board1.get(5).get(1).setCubeColor("red");
    //     board1.get(5).get(10).setCube(true);
    //     board1.get(5).get(10).setCubeColor("blue");
    //     board1.get(0).get(0).setOut(true);
    //     board1.get(0).get(1).setOut(true);
    //     board1.get(0).get(10).setOut(true);
    //     board1.get(0).get(11).setOut(true);
    //     board1.get(1).get(0).setOut(true);
    //     board1.get(1).get(11).setOut(true);
    //     for (int i = 0; i < 8; i++) {
    //         for (int j = 0; j < 12; j++) {
    //             if (board1.get(i).get(j).block == false && board1.get(i).get(j).out == false &&
    //                     board1.get(i).get(j).goal == false
    //                     && board1.get(i).get(j).cube == false && board1.get(i).get(j).trap == false) {
    //                 board1.get(i).get(j).setRoad(true);
    //             }
    //         }
    //     }
    // }

    // ArrayList<ArrayList<Square>> board2 = new ArrayList<>();
    // {
    //     for (int i = 0; i < 5; i++) {
    //         ArrayList<Square> row = new ArrayList<>();
    //         for (int j = 0; j < 9; j++) {
    //             row.add(new Square());
    //         }
    //         board2.add(row);
    //     }
    //     board2.get(0).get(3).setBlock(true);
    //     board2.get(0).get(4).setBlock(true);
    //     board2.get(0).get(5).setBlock(true);
    //     board2.get(0).get(6).setBlock(true);
    //     board2.get(1).get(0).setBlock(true);
    //     board2.get(1).get(1).setBlock(true);
    //     board2.get(1).get(2).setBlock(true);
    //     board2.get(1).get(3).setBlock(true);
    //     board2.get(1).get(6).setBlock(true);
    //     board2.get(1).get(7).setBlock(true);
    //     board2.get(1).get(8).setBlock(true);
    //     board2.get(2).get(0).setBlock(true);
    //     board2.get(2).get(8).setBlock(true);
    //     board2.get(3).get(0).setBlock(true);
    //     board2.get(3).get(3).setBlock(true);
    //     board2.get(3).get(6).setBlock(true);
    //     board2.get(3).get(8).setBlock(true);
    //     board2.get(4).get(0).setBlock(true);
    //     board2.get(4).get(1).setBlock(true);
    //     board2.get(4).get(2).setBlock(true);
    //     board2.get(4).get(3).setBlock(true);
    //     board2.get(4).get(4).setBlock(true);
    //     board2.get(4).get(5).setBlock(true);
    //     board2.get(4).get(6).setBlock(true);
    //     board2.get(4).get(7).setBlock(true);
    //     board2.get(4).get(8).setBlock(true);
    //     board2.get(1).get(5).setGoal(true);
    //     board2.get(1).get(5).setGoalColor("yellow");
    //     board2.get(2).get(1).setGoal(true);
    //     board2.get(2).get(1).setGoalColor("blue");
    //     board2.get(3).get(2).setGoal(true);
    //     board2.get(3).get(2).setGoalColor("pink");
    //     board2.get(3).get(4).setGoal(true);
    //     board2.get(3).get(4).setGoalColor("red");
    //     board2.get(3).get(7).setGoal(true);
    //     board2.get(3).get(7).setGoalColor("green");
    //     board2.get(1).get(4).setCube(true);
    //     board2.get(1).get(4).setCubeColor("red");
    //     board2.get(2).get(2).setCube(true);
    //     board2.get(2).get(2).setCubeColor("pink");
    //     board2.get(2).get(3).setCube(true);
    //     board2.get(2).get(3).setCubeColor("blue");
    //     board2.get(3).get(2).setCube(true);
    //     board2.get(3).get(2).setCubeColor("green");
    //     board2.get(3).get(7).setCube(true);
    //     board2.get(3).get(7).setCubeColor("yellow");
    //     board2.get(0).get(0).setOut(true);
    //     board2.get(0).get(1).setOut(true);
    //     board2.get(0).get(2).setOut(true);
    //     board2.get(0).get(7).setOut(true);
    //     board2.get(0).get(8).setOut(true);
    //     for (int i = 0; i < 5; i++) {
    //         for (int j = 0; j < 9; j++) {
    //             if (board2.get(i).get(j).block == false && board2.get(i).get(j).out == false &&
    //                     board2.get(i).get(j).goal == false
    //                     && board2.get(i).get(j).cube == false && board2.get(i).get(j).trap == false) {
    //                 board2.get(i).get(j).setRoad(true);
    //             }
    //         }
    //     }
    // }

    // ArrayList<ArrayList<Square>> board3 = new ArrayList<>();
    // {
    //     for (int i = 0; i < 6; i++) {
    //         ArrayList<Square> row = new ArrayList<>();
    //         for (int j = 0; j < 16; j++) {
    //             row.add(new Square());
    //         }
    //         board3.add(row);
    //     }
    //     board3.get(0).get(3).setBlock(true);
    //     board3.get(0).get(4).setBlock(true);
    //     board3.get(0).get(5).setBlock(true);
    //     board3.get(0).get(6).setBlock(true);
    //     board3.get(0).get(7).setBlock(true);
    //     board3.get(0).get(8).setBlock(true);
    //     board3.get(0).get(10).setBlock(true);
    //     board3.get(0).get(11).setBlock(true);
    //     board3.get(0).get(12).setBlock(true);
    //     board3.get(0).get(13).setBlock(true);
    //     board3.get(0).get(14).setBlock(true);
    //     board3.get(0).get(15).setBlock(true);
    //     board3.get(1).get(0).setBlock(true);
    //     board3.get(1).get(1).setBlock(true);
    //     board3.get(1).get(2).setBlock(true);
    //     board3.get(1).get(3).setBlock(true);
    //     board3.get(1).get(4).setBlock(true);
    //     board3.get(1).get(8).setBlock(true);
    //     board3.get(1).get(9).setBlock(true);
    //     board3.get(1).get(10).setBlock(true);
    //     board3.get(1).get(12).setBlock(true);
    //     board3.get(1).get(13).setBlock(true);
    //     board3.get(1).get(15).setBlock(true);
    //     board3.get(2).get(0).setBlock(true);
    //     board3.get(2).get(6).setBlock(true);
    //     board3.get(2).get(15).setBlock(true);
    //     board3.get(3).get(0).setBlock(true);
    //     board3.get(3).get(12).setBlock(true);
    //     board3.get(3).get(15).setBlock(true);
    //     board3.get(4).get(0).setBlock(true);
    //     board3.get(4).get(1).setBlock(true);
    //     board3.get(4).get(2).setBlock(true);
    //     board3.get(4).get(3).setBlock(true);
    //     board3.get(4).get(4).setBlock(true);
    //     board3.get(4).get(6).setBlock(true);
    //     board3.get(4).get(7).setBlock(true);
    //     board3.get(4).get(9).setBlock(true);
    //     board3.get(4).get(10).setBlock(true);
    //     board3.get(4).get(11).setBlock(true);
    //     board3.get(4).get(12).setBlock(true);
    //     board3.get(4).get(13).setBlock(true);
    //     board3.get(4).get(14).setBlock(true);
    //     board3.get(4).get(15).setBlock(true);
    //     board3.get(5).get(4).setBlock(true);
    //     board3.get(5).get(5).setBlock(true);
    //     board3.get(5).get(6).setBlock(true);
    //     board3.get(5).get(7).setBlock(true);
    //     board3.get(5).get(9).setBlock(true);
    //     board3.get(0).get(0).setOut(true);
    //     board3.get(0).get(1).setOut(true);
    //     board3.get(0).get(2).setOut(true);
    //     board3.get(0).get(9).setOut(true);
    //     board3.get(5).get(0).setOut(true);
    //     board3.get(5).get(1).setOut(true);
    //     board3.get(5).get(2).setOut(true);
    //     board3.get(5).get(3).setOut(true);
    //     board3.get(5).get(10).setOut(true);
    //     board3.get(5).get(11).setOut(true);
    //     board3.get(5).get(12).setOut(true);
    //     board3.get(5).get(13).setOut(true);
    //     board3.get(5).get(14).setOut(true);
    //     board3.get(5).get(15).setOut(true);
    //     board3.get(5).get(8).setTrap(true);
    //     board3.get(2).get(1).setCube(true);
    //     board3.get(2).get(1).setCubeColor("red");
    //     board3.get(2).get(2).setCube(true);
    //     board3.get(2).get(2).setCubeColor("blue");
    //     board3.get(2).get(3).setCube(true);
    //     board3.get(2).get(3).setCubeColor("green");
    //     board3.get(3).get(1).setCube(true);
    //     board3.get(3).get(1).setCubeColor("yellow");
    //     board3.get(3).get(2).setCube(true);
    //     board3.get(3).get(2).setCubeColor("pink");
    //     board3.get(1).get(7).setGoal(true);
    //     board3.get(1).get(7).setGoalColor("pink");
    //     board3.get(1).get(11).setGoal(true);
    //     board3.get(1).get(11).setGoalColor("yellow");
    //     board3.get(1).get(14).setGoal(true);
    //     board3.get(1).get(14).setGoalColor("green");
    //     board3.get(4).get(5).setGoal(true);
    //     board3.get(4).get(5).setGoalColor("white");
    //     board3.get(4).get(8).setGoal(true);
    //     board3.get(4).get(8).setGoalColor("blue");
    //     for (int i = 0; i < 6; i++) {
    //         for (int j = 0; j < 16; j++) {
    //             if (!board3.get(i).get(j).block && !board3.get(i).get(j).out &&
    //                     !board3.get(i).get(j).goal
    //                     && !board3.get(i).get(j).cube && !board3.get(i).get(j).trap) {
    //                 board3.get(i).get(j).setRoad(true);
    //             }
    //         }
    //     }
    // }

    // choose the level
    void level(int level) {
        switch (level) {
            case 1 -> levelBoard = board1;
            case 2 -> levelBoard = board2;
            case 3 -> levelBoard = board3;
            default -> System.out.println("you can choose only from 1 to 3");
        }
    }

    // define the boared dimensions
    // void dimension(int level) {
    //     switch (level) {
    //         case 1 -> {
    //             rows = 8;
    //             columns = 12;
    //         }
    //         case 2 -> {
    //             rows = 5;
    //             columns = 9;
    //         }
    //         case 3 -> {
    //             rows = 6;
    //             columns = 16;
    //         }
    //         default -> {
    //         }
    //     }
    // }
    
    void dimension(int level) {
        switch (level) {
            case 1 -> {
                rows = 8;
                columns = 11;
            }
            case 2 -> {
                rows = 7;
                columns = 11;
            }
            case 3 -> {
                rows = 7;
                columns = 7;
            }
            default -> {
            }
        }
    }

    // moving
    State go(String key) {
        State currentState = new State(this);
        switch (key) {
            case "w" -> {
                Map<String, Boolean> moving = new HashMap<>();
                moving.put("green", false);
                moving.put("red", false);
                moving.put("yellow", false);
                moving.put("blue", false);
                moving.put("pink", false);
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (i > 0) {
                            if (currentState.levelBoard.get(i).get(j).cube == true) {
                                if (moving.get(currentState.levelBoard.get(i).get(j).cubeColor)) {
                                } else {
                                    if (currentState.levelBoard.get(i - 1).get(j).cube != true
                                            && currentState.levelBoard.get(i - 1).get(j).block != true)
                                        currentState.levelBoard = goUp(currentState.levelBoard, i, j);
                                    if (currentState.levelBoard.get(i + 1).get(j).cube == true)
                                        moving.put(currentState.levelBoard.get(i + 1).get(j).cubeColor, true);
                                }
                            }
                        }
                    }
                }
                moving.replaceAll((k, v) -> false);
            }
            case "s" -> {
                for (int i = 0; i < rows - 1; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (currentState.levelBoard.get(i).get(j).cube == true) {
                            if (currentState.levelBoard.get(i + 1).get(j).cube != true
                                    && currentState.levelBoard.get(i + 1).get(j).block != true)
                                currentState.levelBoard = goDown(currentState.levelBoard, i, j);
                        }
                    }
                }
            }
            case "d" -> {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns - 1; j++) {
                        if (currentState.levelBoard.get(i).get(j).cube == true) {
                            if (currentState.levelBoard.get(i).get(j + 1).cube != true
                                    && currentState.levelBoard.get(i).get(j + 1).block != true)
                                currentState.levelBoard = goRight(currentState.levelBoard, i, j);
                        }
                    }
                }
            }
            case "a" -> {
                Map<String, Boolean> moving = new HashMap<>();
                moving.put("green", false);
                moving.put("red", false);
                moving.put("yellow", false);
                moving.put("blue", false);
                moving.put("pink", false);
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (j > 0) {
                            if (currentState.levelBoard.get(i).get(j).cube == true) {
                                if (moving.get(currentState.levelBoard.get(i).get(j).cubeColor)) {
                                } else {
                                    if (currentState.levelBoard.get(i).get(j - 1).cube != true
                                            && currentState.levelBoard.get(i).get(j - 1).block != true)
                                        currentState.levelBoard = goLeft(currentState.levelBoard, i, j);
                                    if (currentState.levelBoard.get(i).get(j + 1).cube == true) {
                                        moving.put(currentState.levelBoard.get(i).get(j + 1).cubeColor, true);
                                    }
                                }
                            }
                        }
                    }
                }
                moving.replaceAll((k, v) -> false);
            }
            default -> {
                System.out.println("you can only use (w, a, s, d)");
            }
        }
        return currentState;
    }

    // moving up
    ArrayList<ArrayList<Square>> goUp(ArrayList<ArrayList<Square>> levelBoard, int i, int j) {
        while (i > 0) {
            if (levelBoard.get(i).get(j).cube == true) {
                if (levelBoard.get(i - 1).get(j).block == true || levelBoard.get(i - 1).get(j).cube == true) {
                    break;
                } else if (levelBoard.get(i - 1).get(j).road == true) {
                    levelBoard.get(i - 1).get(j).setRoad(false);
                    levelBoard.get(i - 1).get(j).setCube(true);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i - 1).get(j).setCubeColor(levelBoard.get(i).get(j).cubeColor);
                    levelBoard.get(i).get(j).setCubeColor("");
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                } else if (levelBoard.get(i - 1).get(j).goal == true && levelBoard.get(i - 1).get(j).cube == false) {
                    if (levelBoard.get(i - 1).get(j).goalColor.equals(levelBoard.get(i).get(j).cubeColor)) {
                        levelBoard.get(i - 1).get(j).setGoal(false);
                        levelBoard.get(i - 1).get(j).setGoalColor("");
                        levelBoard.get(i - 1).get(j).setRoad(true);
                        levelBoard.get(i).get(j).setCube(false);
                        levelBoard.get(i).get(j).setCubeColor("");
                        if (levelBoard.get(i).get(j).goal != true) {
                            levelBoard.get(i).get(j).setRoad(true);
                        }
                    } else if ("white".equals(levelBoard.get(i - 1).get(j).goalColor)) {
                        levelBoard.get(i - 1).get(j).setCube(true);
                        levelBoard.get(i - 1).get(j)
                                .setCubeColor(levelBoard.get(i).get(j).cubeColor);
                        levelBoard.get(i - 1).get(j)
                                .setGoalColor(levelBoard.get(i).get(j).cubeColor);
                        levelBoard.get(i).get(j).setCube(false);
                        levelBoard.get(i).get(j).setCubeColor("");
                        if (levelBoard.get(i).get(j).goal != true) {
                            levelBoard.get(i).get(j).setRoad(true);
                        }
                    } else {
                        levelBoard.get(i - 1).get(j).setCube(true);
                        levelBoard.get(i - 1).get(j)
                                .setCubeColor(levelBoard.get(i).get(j).cubeColor);
                        levelBoard.get(i).get(j).setCube(false);
                        levelBoard.get(i).get(j).setCubeColor("");
                        if (levelBoard.get(i).get(j).goal != true) {
                            levelBoard.get(i).get(j).setRoad(true);
                        }
                    }
                } else if (levelBoard.get(i - 1).get(j).trap == true) {
                    levelBoard.get(i - 1).get(j).setOut(true);
                    levelBoard.get(i - 1).get(j).setTrap(false);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i).get(j).setCubeColor("");
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                    break;
                }
            }
            i--;
        }
        return levelBoard;
    }

    // moving down
    ArrayList<ArrayList<Square>> goDown(ArrayList<ArrayList<Square>> levelBoard, int i, int j) {
        while (i < rows - 1) {
            if (levelBoard.get(i).get(j).cube == true) {
                if (levelBoard.get(i + 1).get(j).block == true || levelBoard.get(i + 1).get(j).cube == true) {
                    break;
                } else if (levelBoard.get(i + 1).get(j).road == true) {
                    levelBoard.get(i + 1).get(j).setRoad(false);
                    levelBoard.get(i + 1).get(j).setCube(true);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i + 1).get(j).setCubeColor(levelBoard.get(i).get(j).cubeColor);
                    levelBoard.get(i).get(j).setCubeColor("");
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                } else if (levelBoard.get(i + 1).get(j).goal == true && levelBoard.get(i + 1).get(j).cube == false) {
                    if (levelBoard.get(i + 1).get(j).goalColor.equals(levelBoard.get(i).get(j).cubeColor)) {
                        levelBoard.get(i + 1).get(j).setGoal(false);
                        levelBoard.get(i + 1).get(j).setGoalColor("");
                        levelBoard.get(i + 1).get(j).setRoad(true);
                        levelBoard.get(i).get(j).setCube(false);
                        levelBoard.get(i).get(j).setCubeColor("");
                        if (levelBoard.get(i).get(j).goal != true) {
                            levelBoard.get(i).get(j).setRoad(true);
                        }
                    } else if ("white".equals(levelBoard.get(i + 1).get(j).goalColor)) {
                        levelBoard.get(i + 1).get(j).setCube(true);
                        levelBoard.get(i + 1).get(j)
                                .setCubeColor(levelBoard.get(i).get(j).cubeColor);
                        levelBoard.get(i + 1).get(j)
                                .setGoalColor(levelBoard.get(i).get(j).cubeColor);
                        levelBoard.get(i).get(j).setCube(false);
                        levelBoard.get(i).get(j).setCubeColor("");
                        if (levelBoard.get(i).get(j).goal != true) {
                            levelBoard.get(i).get(j).setRoad(true);
                        }
                    } else {
                        levelBoard.get(i + 1).get(j).setCube(true);
                        levelBoard.get(i + 1).get(j)
                                .setCubeColor(levelBoard.get(i).get(j).cubeColor);
                        levelBoard.get(i).get(j).setCube(false);
                        levelBoard.get(i).get(j).setCubeColor("");
                        if (levelBoard.get(i).get(j).goal != true) {
                            levelBoard.get(i).get(j).setRoad(true);
                        }
                    }
                } else if (levelBoard.get(i + 1).get(j).trap == true) {
                    levelBoard.get(i + 1).get(j).setOut(true);
                    levelBoard.get(i + 1).get(j).setTrap(false);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i).get(j).setCubeColor("");
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                    break;
                }
            }
            i++;
        }
        return levelBoard;
    }

    // moving left
    ArrayList<ArrayList<Square>> goLeft(ArrayList<ArrayList<Square>> levelBoard, int i, int j) {
        while (j > 0) {
            if (levelBoard.get(i).get(j).cube == true) {
                if (levelBoard.get(i).get(j - 1).block == true || levelBoard.get(i).get(j - 1).cube == true) {
                    break;
                } else if (levelBoard.get(i).get(j - 1).road == true) {
                    levelBoard.get(i).get(j - 1).setRoad(false);
                    levelBoard.get(i).get(j - 1).setCube(true);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i).get(j - 1).setCubeColor(levelBoard.get(i).get(j).cubeColor);
                    levelBoard.get(i).get(j).setCubeColor("");
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                } else if (levelBoard.get(i).get(j - 1).goal == true && levelBoard.get(i).get(j - 1).cube == false) {
                    if (levelBoard.get(i).get(j - 1).goalColor.equals(levelBoard.get(i).get(j).cubeColor)) {
                        levelBoard.get(i).get(j - 1).setGoal(false);
                        levelBoard.get(i).get(j - 1).setGoalColor("");
                        levelBoard.get(i).get(j - 1).setRoad(true);
                        levelBoard.get(i).get(j).setCube(false);
                        levelBoard.get(i).get(j).setCubeColor("");
                        if (levelBoard.get(i).get(j).goal != true) {
                            levelBoard.get(i).get(j).setRoad(true);
                        }
                    } else if ("white".equals(levelBoard.get(i).get(j - 1).goalColor)) {
                        levelBoard.get(i).get(j - 1).setCube(true);
                        levelBoard.get(i).get(j - 1)
                                .setCubeColor(levelBoard.get(i).get(j).cubeColor);
                        levelBoard.get(i).get(j - 1)
                                .setGoalColor(levelBoard.get(i).get(j).cubeColor);
                        levelBoard.get(i).get(j).setCube(false);
                        levelBoard.get(i).get(j).setCubeColor("");
                        if (levelBoard.get(i).get(j).goal != true) {
                            levelBoard.get(i).get(j).setRoad(true);
                        }
                    } else {
                        levelBoard.get(i).get(j - 1).setCube(true);
                        levelBoard.get(i).get(j - 1)
                                .setCubeColor(levelBoard.get(i).get(j).cubeColor);
                        levelBoard.get(i).get(j).setCube(false);
                        levelBoard.get(i).get(j).setCubeColor("");
                        if (levelBoard.get(i).get(j).goal != true) {
                            levelBoard.get(i).get(j).setRoad(true);
                        }
                    }
                } else if (levelBoard.get(i).get(j - 1).trap == true) {
                    levelBoard.get(i).get(j - 1).setOut(true);
                    levelBoard.get(i).get(j - 1).setTrap(false);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i).get(j).setCubeColor("");
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                    break;
                }
            }
            j--;
        }
        return levelBoard;
    }

    // moving right
    ArrayList<ArrayList<Square>> goRight(ArrayList<ArrayList<Square>> levelBoard, int i, int j) {
        while (j < columns - 1) {
            if (levelBoard.get(i).get(j).cube == true) {
                if (levelBoard.get(i).get(j + 1).block == true || levelBoard.get(i).get(j + 1).cube == true) {
                    break;
                } else if (levelBoard.get(i).get(j + 1).road == true) {
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                    levelBoard.get(i).get(j + 1).setRoad(false);
                    levelBoard.get(i).get(j + 1).setCube(true);
                    levelBoard.get(i).get(j + 1).setCubeColor(levelBoard.get(i).get(j).cubeColor);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i).get(j).setCubeColor("");
                } else if (levelBoard.get(i).get(j + 1).goal == true && levelBoard.get(i).get(j + 1).cube == false) {
                    if (levelBoard.get(i).get(j + 1).goalColor.equals(levelBoard.get(i).get(j).cubeColor)) {
                        levelBoard.get(i).get(j + 1).setGoal(false);
                        levelBoard.get(i).get(j + 1).setGoalColor("");
                        levelBoard.get(i).get(j + 1).setRoad(true);
                        levelBoard.get(i).get(j).setCube(false);
                        levelBoard.get(i).get(j).setCubeColor("");
                        if (levelBoard.get(i).get(j).goal != true) {
                            levelBoard.get(i).get(j).setRoad(true);
                        }
                    } else if ("white".equals(levelBoard.get(i).get(j + 1).goalColor)) {
                        levelBoard.get(i).get(j + 1).setCube(true);
                        levelBoard.get(i).get(j + 1)
                                .setCubeColor(levelBoard.get(i).get(j).cubeColor);
                        levelBoard.get(i).get(j + 1)
                                .setGoalColor(levelBoard.get(i).get(j).cubeColor);
                        levelBoard.get(i).get(j).setCube(false);
                        levelBoard.get(i).get(j).setCubeColor("");
                        if (levelBoard.get(i).get(j).goal != true) {
                            levelBoard.get(i).get(j).setRoad(true);
                        }
                    } else {
                        levelBoard.get(i).get(j + 1).setCube(true);
                        levelBoard.get(i).get(j + 1)
                                .setCubeColor(levelBoard.get(i).get(j).cubeColor);
                        levelBoard.get(i).get(j).setCube(false);
                        levelBoard.get(i).get(j).setCubeColor("");
                        if (levelBoard.get(i).get(j).goal != true) {
                            levelBoard.get(i).get(j).setRoad(true);
                        }
                    }
                } else if (levelBoard.get(i).get(j + 1).trap == true) {
                    levelBoard.get(i).get(j + 1).setOut(true);
                    levelBoard.get(i).get(j + 1).setTrap(false);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i).get(j).setCubeColor("");
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                    break;
                }
            }
            j++;
        }
        return levelBoard;
    }

    // printing the boared
    void printBoard() {
        System.out.println();
        for (ArrayList<Square> row : this.levelBoard) {
            for (Square square : row) {
                if (square.out == true) {
                    square.setSymbol("  ");
                    COLOR = "";
                }
                if (square.road == true) {
                    square.setSymbol("  ");
                    COLOR = "\033[0;107m";
                }
                if (square.block == true) {
                    square.setSymbol(". ");
                    COLOR = "\033[0;100m";
                }
                if (square.trap == true) {
                    square.setSymbol("()");
                    COLOR = "\033[1;30m";
                }
                if (square.goal == true) {
                    if ("red".equals(square.goalColor)) {
                        square.setSymbol("[]");
                        COLOR = "\033[1;91m";
                    }
                    if ("green".equals(square.goalColor)) {
                        square.setSymbol("[]");
                        COLOR = "\033[1;92m";
                    }
                    if ("yellow".equals(square.goalColor)) {
                        square.setSymbol("[]");
                        COLOR = "\033[1;93m";
                    }
                    if ("blue".equals(square.goalColor)) {
                        square.setSymbol("[]");
                        COLOR = "\033[1;94m";
                    }
                    if ("pink".equals(square.goalColor)) {
                        square.setSymbol("[]");
                        COLOR = "\033[1;95m";
                    }
                    if ("white".equals(square.goalColor)) {
                        square.setSymbol("[]");
                        COLOR = "\033[1;97m";
                    }
                }
                if (square.cube == true) {
                    if ("red".equals(square.cubeColor)) {
                        square.setSymbol("  ");
                        COLOR = "\033[41m";
                    }
                    if ("green".equals(square.cubeColor)) {
                        square.setSymbol("  ");
                        COLOR = "\033[42m";
                    }
                    if ("yellow".equals(square.cubeColor)) {
                        square.setSymbol("  ");
                        COLOR = "\033[43m";
                    }
                    if ("blue".equals(square.cubeColor)) {
                        square.setSymbol("  ");
                        COLOR = "\033[44m";
                    }
                    if ("pink".equals(square.cubeColor)) {
                        square.setSymbol("  ");
                        COLOR = "\033[45m";
                    }
                }
                System.out.print(COLOR + square.symbol + RESET);
            }
            System.out.println();
        }
        System.out.println();
    }

    // check if the game is ended
    boolean winState() {
        int counter = 0;
        for (ArrayList<Square> row : this.levelBoard) {
            for (Square square : row) {
                if (square.goal == true) {
                    counter++;
                }
            }
        }
        return counter == 0;
    }

    // check if you are a loser
    boolean loseState() {
        int goales = 0;
        int cubes = 0;
        for (ArrayList<Square> row : this.levelBoard) {
            for (Square square : row) {
                if (square.goal == true) {
                    goales++;
                }
                if (square.cube == true) {
                    cubes++;
                }
            }
        }
        return goales != cubes;
    }

    // check if two states are the same
    boolean sameState(State first, State second) {
        for (int i = 0; i < first.levelBoard.size(); i++) {
            for (int j = 0; j < first.levelBoard.get(i).size(); j++) {
                if (first.levelBoard.get(i).get(j).block != second.levelBoard.get(i).get(j).block)
                    return false;
                if (first.levelBoard.get(i).get(j).cube != second.levelBoard.get(i).get(j).cube)
                    return false;
                if (first.levelBoard.get(i).get(j).goal != second.levelBoard.get(i).get(j).goal)
                    return false;
                if (first.levelBoard.get(i).get(j).out != second.levelBoard.get(i).get(j).out)
                    return false;
                if (first.levelBoard.get(i).get(j).road != second.levelBoard.get(i).get(j).road)
                    return false;
                if (first.levelBoard.get(i).get(j).trap != second.levelBoard.get(i).get(j).trap)
                    return false;
                if (!first.levelBoard.get(i).get(j).symbol.equals(second.levelBoard.get(i).get(j).symbol))
                    return false;
                if (!first.levelBoard.get(i).get(j).cubeColor.equals(second.levelBoard.get(i).get(j).cubeColor))
                    return false;
                if (!first.levelBoard.get(i).get(j).goalColor.equals(second.levelBoard.get(i).get(j).goalColor))
                    return false;
            }
        }
        return true;
    }

    // all of the possible coming moves
    ArrayList<State> nextStates(int level) {
        ArrayList<State> possibleMoves = new ArrayList<>();

        State upState = new State(this);
        State up = upState.go("w");
        if (!up.loseState() && !sameState(up, upState))
            possibleMoves.add(up);

        State downState = new State(this);
        State down = downState.go("s");
        if (!down.loseState() && !sameState(down, downState))
            possibleMoves.add(down);

        State leftState = new State(this);
        State left = leftState.go("a");
        if (!left.loseState() && !sameState(left, leftState))
            possibleMoves.add(left);

        State rightState = new State(this);
        State right = rightState.go("d");
        if (!right.loseState() && !sameState(right, rightState))
            possibleMoves.add(right);

        return possibleMoves;
    }

    // void check() {
    // System.out.println();
    // for (ArrayList<Square> row : this.levelBoard) {
    // for (Square square : row) {
    // if (square.out == true)
    // System.out.print("o");
    // if (square.road == true)
    // System.out.print("r");
    // if (square.block == true)
    // System.out.print("b");
    // if (square.trap == true)
    // System.out.print("t");
    // if (square.goal == true) {
    // if ("green".equals(square.goalColor))
    // System.out.print("gg");
    // if ("yellow".equals(square.goalColor))
    // System.out.print("yg");
    // if ("blue".equals(square.goalColor))
    // System.out.print("bg");
    // if ("pink".equals(square.goalColor))
    // System.out.print("pg");
    // if ("red".equals(square.goalColor))
    // System.out.print("rg");
    // if ("white".equals(square.goalColor))
    // System.out.print("wg");
    // }
    // if (square.cube == true) {
    // if ("green".equals(square.cubeColor))
    // System.out.print("gc");
    // if ("yellow".equals(square.cubeColor))
    // System.out.print("yc");
    // if ("blue".equals(square.cubeColor))
    // System.out.print("bc");
    // if ("pink".equals(square.cubeColor))
    // System.out.print("pc");
    // if ("red".equals(square.cubeColor))
    // System.out.print("rc");
    // }
    // System.out.print(" | ");
    // }
    // System.out.println();
    // }
    // System.out.println();
    // }
}