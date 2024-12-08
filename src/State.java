import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class State {
    public static final String RESET = "\033[0m";
    public static String COLOR = "";
    ArrayList<ArrayList<Square>> levelBoard;
    static int rows, columns;
    public int cost = 0;
    public int heuristic = 0;
    public int f = 0;

    public int getCost() {
        return cost;
    }

    public void setCost() {
        this.cost += 1;
    }

    State() {
    }

    State(State another) {
        this.cost = another.cost;
        this.heuristic = another.heuristic;
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
            for (int j = 0; j < 12; j++) {
                row.add(new Square());
            }
            board1.add(row);
        }
        board1.get(0).get(2).setBlock(true);
        board1.get(0).get(3).setBlock(true);
        board1.get(0).get(4).setBlock(true);
        board1.get(0).get(5).setBlock(true);
        board1.get(0).get(6).setBlock(true);
        board1.get(0).get(7).setBlock(true);
        board1.get(0).get(8).setBlock(true);
        board1.get(0).get(9).setBlock(true);
        board1.get(1).get(1).setBlock(true);
        board1.get(1).get(2).setBlock(true);
        board1.get(1).get(9).setBlock(true);
        board1.get(1).get(10).setBlock(true);
        board1.get(2).get(0).setBlock(true);
        board1.get(2).get(1).setBlock(true);
        board1.get(2).get(4).setBlock(true);
        board1.get(2).get(7).setBlock(true);
        board1.get(2).get(10).setBlock(true);
        board1.get(2).get(11).setBlock(true);
        board1.get(3).get(0).setBlock(true);
        board1.get(3).get(3).setBlock(true);
        board1.get(3).get(8).setBlock(true);
        board1.get(3).get(11).setBlock(true);
        board1.get(4).get(0).setBlock(true);
        board1.get(4).get(5).setBlock(true);
        board1.get(4).get(8).setBlock(true);
        board1.get(4).get(9).setBlock(true);
        board1.get(4).get(11).setBlock(true);
        board1.get(5).get(0).setBlock(true);
        board1.get(5).get(2).setBlock(true);
        board1.get(5).get(4).setBlock(true);
        board1.get(5).get(5).setBlock(true);
        board1.get(5).get(9).setBlock(true);
        board1.get(5).get(11).setBlock(true);
        board1.get(6).get(0).setBlock(true);
        board1.get(6).get(4).setBlock(true);
        board1.get(6).get(11).setBlock(true);
        board1.get(7).get(0).setBlock(true);
        board1.get(7).get(1).setBlock(true);
        board1.get(7).get(2).setBlock(true);
        board1.get(7).get(3).setBlock(true);
        board1.get(7).get(4).setBlock(true);
        board1.get(7).get(5).setBlock(true);
        board1.get(7).get(6).setBlock(true);
        board1.get(7).get(7).setBlock(true);
        board1.get(7).get(8).setBlock(true);
        board1.get(7).get(9).setBlock(true);
        board1.get(7).get(10).setBlock(true);
        board1.get(7).get(11).setBlock(true);
        board1.get(3).get(5).setGoal(true);
        board1.get(3).get(5).setGoalColor("red");
        board1.get(2).get(6).setGoal(true);
        board1.get(2).get(6).setGoalColor("blue");
        board1.get(5).get(1).setCube(true);
        board1.get(5).get(1).setCubeColor("red");
        board1.get(5).get(10).setCube(true);
        board1.get(5).get(10).setCubeColor("blue");
        board1.get(0).get(0).setOut(true);
        board1.get(0).get(1).setOut(true);
        board1.get(0).get(10).setOut(true);
        board1.get(0).get(11).setOut(true);
        board1.get(1).get(0).setOut(true);
        board1.get(1).get(11).setOut(true);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 12; j++) {
                if (board1.get(i).get(j).block == false && board1.get(i).get(j).out == false
                        &&
                        board1.get(i).get(j).goal == false
                        && board1.get(i).get(j).cube == false && board1.get(i).get(j).trap == false) {
                    board1.get(i).get(j).setRoad(true);
                }
            }
        }
    }

    ArrayList<ArrayList<Square>> board2 = new ArrayList<>();
    {
        for (int i = 0; i < 5; i++) {
            ArrayList<Square> row = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                row.add(new Square());
            }
            board2.add(row);
        }
        board2.get(0).get(3).setBlock(true);
        board2.get(0).get(4).setBlock(true);
        board2.get(0).get(5).setBlock(true);
        board2.get(0).get(6).setBlock(true);
        board2.get(1).get(0).setBlock(true);
        board2.get(1).get(1).setBlock(true);
        board2.get(1).get(2).setBlock(true);
        board2.get(1).get(3).setBlock(true);
        board2.get(1).get(6).setBlock(true);
        board2.get(1).get(7).setBlock(true);
        board2.get(1).get(8).setBlock(true);
        board2.get(2).get(0).setBlock(true);
        board2.get(2).get(8).setBlock(true);
        board2.get(3).get(0).setBlock(true);
        board2.get(3).get(3).setBlock(true);
        board2.get(3).get(6).setBlock(true);
        board2.get(3).get(8).setBlock(true);
        board2.get(4).get(0).setBlock(true);
        board2.get(4).get(1).setBlock(true);
        board2.get(4).get(2).setBlock(true);
        board2.get(4).get(3).setBlock(true);
        board2.get(4).get(4).setBlock(true);
        board2.get(4).get(5).setBlock(true);
        board2.get(4).get(6).setBlock(true);
        board2.get(4).get(7).setBlock(true);
        board2.get(4).get(8).setBlock(true);
        board2.get(1).get(5).setGoal(true);
        board2.get(1).get(5).setGoalColor("yellow");
        board2.get(2).get(1).setGoal(true);
        board2.get(2).get(1).setGoalColor("blue");
        board2.get(3).get(2).setGoal(true);
        board2.get(3).get(2).setGoalColor("pink");
        board2.get(3).get(4).setGoal(true);
        board2.get(3).get(4).setGoalColor("red");
        board2.get(3).get(7).setGoal(true);
        board2.get(3).get(7).setGoalColor("green");
        board2.get(1).get(4).setCube(true);
        board2.get(1).get(4).setCubeColor("red");
        board2.get(2).get(2).setCube(true);
        board2.get(2).get(2).setCubeColor("pink");
        board2.get(2).get(3).setCube(true);
        board2.get(2).get(3).setCubeColor("blue");
        board2.get(3).get(2).setCube(true);
        board2.get(3).get(2).setCubeColor("green");
        board2.get(3).get(7).setCube(true);
        board2.get(3).get(7).setCubeColor("yellow");
        board2.get(0).get(0).setOut(true);
        board2.get(0).get(1).setOut(true);
        board2.get(0).get(2).setOut(true);
        board2.get(0).get(7).setOut(true);
        board2.get(0).get(8).setOut(true);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (board2.get(i).get(j).block == false && board2.get(i).get(j).out == false
                        &&
                        board2.get(i).get(j).goal == false
                        && board2.get(i).get(j).cube == false && board2.get(i).get(j).trap == false) {
                    board2.get(i).get(j).setRoad(true);
                }
            }
        }
    }

    ArrayList<ArrayList<Square>> board3 = new ArrayList<>();
    {
        for (int i = 0; i < 6; i++) {
            ArrayList<Square> row = new ArrayList<>();
            for (int j = 0; j < 16; j++) {
                row.add(new Square());
            }
            board3.add(row);
        }
        board3.get(0).get(3).setBlock(true);
        board3.get(0).get(4).setBlock(true);
        board3.get(0).get(5).setBlock(true);
        board3.get(0).get(6).setBlock(true);
        board3.get(0).get(7).setBlock(true);
        board3.get(0).get(8).setBlock(true);
        board3.get(0).get(10).setBlock(true);
        board3.get(0).get(11).setBlock(true);
        board3.get(0).get(12).setBlock(true);
        board3.get(0).get(13).setBlock(true);
        board3.get(0).get(14).setBlock(true);
        board3.get(0).get(15).setBlock(true);
        board3.get(1).get(0).setBlock(true);
        board3.get(1).get(1).setBlock(true);
        board3.get(1).get(2).setBlock(true);
        board3.get(1).get(3).setBlock(true);
        board3.get(1).get(4).setBlock(true);
        board3.get(1).get(8).setBlock(true);
        board3.get(1).get(9).setBlock(true);
        board3.get(1).get(10).setBlock(true);
        board3.get(1).get(12).setBlock(true);
        board3.get(1).get(13).setBlock(true);
        board3.get(1).get(15).setBlock(true);
        board3.get(2).get(0).setBlock(true);
        board3.get(2).get(6).setBlock(true);
        board3.get(2).get(15).setBlock(true);
        board3.get(3).get(0).setBlock(true);
        board3.get(3).get(12).setBlock(true);
        board3.get(3).get(15).setBlock(true);
        board3.get(4).get(0).setBlock(true);
        board3.get(4).get(1).setBlock(true);
        board3.get(4).get(2).setBlock(true);
        board3.get(4).get(3).setBlock(true);
        board3.get(4).get(4).setBlock(true);
        board3.get(4).get(6).setBlock(true);
        board3.get(4).get(7).setBlock(true);
        board3.get(4).get(9).setBlock(true);
        board3.get(4).get(10).setBlock(true);
        board3.get(4).get(11).setBlock(true);
        board3.get(4).get(12).setBlock(true);
        board3.get(4).get(13).setBlock(true);
        board3.get(4).get(14).setBlock(true);
        board3.get(4).get(15).setBlock(true);
        board3.get(5).get(4).setBlock(true);
        board3.get(5).get(5).setBlock(true);
        board3.get(5).get(6).setBlock(true);
        board3.get(5).get(7).setBlock(true);
        board3.get(5).get(9).setBlock(true);
        board3.get(0).get(0).setOut(true);
        board3.get(0).get(1).setOut(true);
        board3.get(0).get(2).setOut(true);
        board3.get(0).get(9).setOut(true);
        board3.get(5).get(0).setOut(true);
        board3.get(5).get(1).setOut(true);
        board3.get(5).get(2).setOut(true);
        board3.get(5).get(3).setOut(true);
        board3.get(5).get(10).setOut(true);
        board3.get(5).get(11).setOut(true);
        board3.get(5).get(12).setOut(true);
        board3.get(5).get(13).setOut(true);
        board3.get(5).get(14).setOut(true);
        board3.get(5).get(15).setOut(true);
        board3.get(5).get(8).setTrap(true);
        board3.get(2).get(1).setCube(true);
        board3.get(2).get(1).setCubeColor("red");
        board3.get(2).get(2).setCube(true);
        board3.get(2).get(2).setCubeColor("blue");
        board3.get(2).get(3).setCube(true);
        board3.get(2).get(3).setCubeColor("green");
        board3.get(3).get(1).setCube(true);
        board3.get(3).get(1).setCubeColor("yellow");
        board3.get(3).get(2).setCube(true);
        board3.get(3).get(2).setCubeColor("pink");
        board3.get(1).get(7).setGoal(true);
        board3.get(1).get(7).setGoalColor("pink");
        board3.get(1).get(11).setGoal(true);
        board3.get(1).get(11).setGoalColor("yellow");
        board3.get(1).get(14).setGoal(true);
        board3.get(1).get(14).setGoalColor("green");
        board3.get(4).get(5).setGoal(true);
        board3.get(4).get(5).setGoalColor("white");
        board3.get(4).get(8).setGoal(true);
        board3.get(4).get(8).setGoalColor("blue");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 16; j++) {
                if (!board3.get(i).get(j).block && !board3.get(i).get(j).out &&
                        !board3.get(i).get(j).goal
                        && !board3.get(i).get(j).cube && !board3.get(i).get(j).trap) {
                    board3.get(i).get(j).setRoad(true);
                }
            }
        }
    }

    ArrayList<ArrayList<Square>> board4 = new ArrayList<>();
    {
        for (int i = 0; i < 8; i++) {
            ArrayList<Square> row = new ArrayList<>();
            for (int j = 0; j < 11; j++) {
                row.add(new Square());
            }
            board4.add(row);
        }
        board4.get(0).get(0).setBlock(true);
        board4.get(0).get(1).setBlock(true);
        board4.get(0).get(2).setBlock(true);
        board4.get(0).get(3).setBlock(true);
        board4.get(0).get(4).setBlock(true);
        board4.get(0).get(5).setBlock(true);
        board4.get(0).get(6).setBlock(true);
        board4.get(0).get(7).setBlock(true);
        board4.get(0).get(8).setBlock(true);
        board4.get(1).get(8).setBlock(true);
        board4.get(2).get(0).setBlock(true);
        board4.get(2).get(8).setBlock(true);
        board4.get(2).get(9).setBlock(true);
        board4.get(2).get(10).setBlock(true);
        board4.get(3).get(0).setBlock(true);
        board4.get(3).get(10).setBlock(true);
        board4.get(4).get(0).setBlock(true);
        board4.get(4).get(8).setBlock(true);
        board4.get(4).get(10).setBlock(true);
        board4.get(5).get(0).setBlock(true);
        board4.get(5).get(1).setBlock(true);
        board4.get(5).get(2).setBlock(true);
        board4.get(5).get(4).setBlock(true);
        board4.get(5).get(5).setBlock(true);
        board4.get(5).get(6).setBlock(true);
        board4.get(5).get(8).setBlock(true);
        board4.get(5).get(10).setBlock(true);
        board4.get(6).get(2).setBlock(true);
        board4.get(6).get(10).setBlock(true);
        board4.get(7).get(2).setBlock(true);
        board4.get(7).get(3).setBlock(true);
        board4.get(7).get(4).setBlock(true);
        board4.get(7).get(5).setBlock(true);
        board4.get(7).get(6).setBlock(true);
        board4.get(7).get(7).setBlock(true);
        board4.get(7).get(8).setBlock(true);
        board4.get(7).get(9).setBlock(true);
        board4.get(7).get(10).setBlock(true);
        board4.get(1).get(0).setTrap(true);
        board4.get(1).get(1).setGoal(true);
        board4.get(1).get(1).setGoalColor("white");
        board4.get(1).get(2).setGoal(true);
        board4.get(1).get(2).setGoalColor("blue");
        board4.get(2).get(1).setGoal(true);
        board4.get(2).get(1).setGoalColor("green");
        board4.get(1).get(7).setCube(true);
        board4.get(1).get(7).setCubeColor("red");
        board4.get(4).get(3).setCube(true);
        board4.get(4).get(3).setCubeColor("blue");
        board4.get(4).get(4).setCube(true);
        board4.get(4).get(4).setCubeColor("green");
        board4.get(0).get(9).setOut(true);
        board4.get(0).get(10).setOut(true);
        board4.get(1).get(9).setOut(true);
        board4.get(1).get(10).setOut(true);
        board4.get(6).get(0).setOut(true);
        board4.get(6).get(1).setOut(true);
        board4.get(7).get(0).setOut(true);
        board4.get(7).get(1).setOut(true);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 11; j++) {
                if (board4.get(i).get(j).block == false && board4.get(i).get(j).out == false
                        &&
                        board4.get(i).get(j).goal == false
                        && board4.get(i).get(j).cube == false && board4.get(i).get(j).trap == false) {
                    board4.get(i).get(j).setRoad(true);
                }
            }
        }
    }

    ArrayList<ArrayList<Square>> board5 = new ArrayList<>();
    {
        for (int i = 0; i < 7; i++) {
            ArrayList<Square> row = new ArrayList<>();
            for (int j = 0; j < 11; j++) {
                row.add(new Square());
            }
            board5.add(row);
        }
        board5.get(0).get(0).setBlock(true);
        board5.get(0).get(1).setBlock(true);
        board5.get(0).get(2).setBlock(true);
        board5.get(0).get(3).setBlock(true);
        board5.get(0).get(4).setBlock(true);
        board5.get(0).get(5).setBlock(true);
        board5.get(0).get(6).setBlock(true);
        board5.get(0).get(7).setBlock(true);
        board5.get(0).get(8).setBlock(true);
        board5.get(0).get(9).setBlock(true);
        board5.get(0).get(10).setBlock(true);
        board5.get(1).get(0).setBlock(true);
        board5.get(1).get(10).setBlock(true);
        board5.get(2).get(0).setBlock(true);
        board5.get(2).get(10).setBlock(true);
        board5.get(3).get(0).setBlock(true);
        board5.get(3).get(1).setBlock(true);
        board5.get(3).get(10).setBlock(true);
        board5.get(4).get(1).setBlock(true);
        board5.get(4).get(6).setBlock(true);
        board5.get(4).get(7).setBlock(true);
        board5.get(4).get(8).setBlock(true);
        board5.get(4).get(9).setBlock(true);
        board5.get(4).get(10).setBlock(true);
        board5.get(5).get(1).setBlock(true);
        board5.get(5).get(6).setBlock(true);
        board5.get(6).get(1).setBlock(true);
        board5.get(6).get(2).setBlock(true);
        board5.get(6).get(3).setBlock(true);
        board5.get(6).get(4).setBlock(true);
        board5.get(6).get(5).setBlock(true);
        board5.get(6).get(6).setBlock(true);
        board5.get(2).get(6).setGoal(true);
        board5.get(2).get(6).setGoalColor("yellow");
        board5.get(3).get(5).setGoal(true);
        board5.get(3).get(5).setGoalColor("green");
        board5.get(4).get(4).setGoal(true);
        board5.get(4).get(4).setGoalColor("blue");
        board5.get(5).get(3).setGoal(true);
        board5.get(5).get(3).setGoalColor("red");
        board5.get(1).get(1).setCube(true);
        board5.get(1).get(1).setCubeColor("yellow");
        board5.get(1).get(2).setCube(true);
        board5.get(1).get(2).setCubeColor("red");
        board5.get(1).get(3).setCube(true);
        board5.get(1).get(3).setCubeColor("blue");
        board5.get(1).get(4).setCube(true);
        board5.get(1).get(4).setCubeColor("green");
        board5.get(4).get(0).setOut(true);
        board5.get(5).get(0).setOut(true);
        board5.get(5).get(7).setOut(true);
        board5.get(5).get(8).setOut(true);
        board5.get(5).get(9).setOut(true);
        board5.get(5).get(10).setOut(true);
        board5.get(6).get(0).setOut(true);
        board5.get(6).get(7).setOut(true);
        board5.get(6).get(8).setOut(true);
        board5.get(6).get(9).setOut(true);
        board5.get(6).get(10).setOut(true);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 11; j++) {
                if (!board5.get(i).get(j).block && !board5.get(i).get(j).out &&
                        !board5.get(i).get(j).goal
                        && !board5.get(i).get(j).cube && !board5.get(i).get(j).trap) {
                    board5.get(i).get(j).setRoad(true);
                }
            }
        }
    }

    ArrayList<ArrayList<Square>> board6 = new ArrayList<>();
    {
        for (int i = 0; i < 7; i++) {
            ArrayList<Square> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                row.add(new Square());
            }
            board6.add(row);
        }
        board6.get(0).get(3).setBlock(true);
        board6.get(0).get(4).setBlock(true);
        board6.get(0).get(5).setBlock(true);
        board6.get(0).get(6).setBlock(true);
        board6.get(5).get(0).setBlock(true);
        board6.get(6).get(0).setBlock(true);
        board6.get(6).get(1).setBlock(true);
        board6.get(6).get(2).setBlock(true);
        board6.get(6).get(3).setBlock(true);
        board6.get(6).get(4).setBlock(true);
        board6.get(6).get(5).setBlock(true);
        board6.get(6).get(6).setBlock(true);
        board6.get(2).get(0).setBlock(true);
        board6.get(3).get(0).setBlock(true);
        board6.get(3).get(4).setBlock(true);
        board6.get(4).get(0).setBlock(true);
        board6.get(4).get(4).setBlock(true);
        board6.get(1).get(6).setBlock(true);
        board6.get(2).get(6).setBlock(true);
        board6.get(3).get(6).setBlock(true);
        board6.get(4).get(6).setBlock(true);
        board6.get(5).get(6).setBlock(true);
        board6.get(1).get(0).setOut(true);
        board6.get(0).get(0).setOut(true);
        board6.get(0).get(1).setOut(true);
        board6.get(1).get(0).setOut(true);
        board6.get(0).get(2).setTrap(true);
        board6.get(1).get(1).setTrap(true);
        board6.get(2).get(0).setTrap(true);
        board6.get(4).get(1).setCube(true);
        board6.get(4).get(1).setCubeColor("red");
        board6.get(5).get(1).setCube(true);
        board6.get(5).get(1).setCubeColor("blue");
        board6.get(2).get(1).setGoal(true);
        board6.get(2).get(1).setGoalColor("red");
        board6.get(1).get(3).setGoal(true);
        board6.get(1).get(3).setGoalColor("blue");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (!board6.get(i).get(j).block && !board6.get(i).get(j).out &&
                        !board6.get(i).get(j).goal
                        && !board6.get(i).get(j).cube && !board6.get(i).get(j).trap) {
                    board6.get(i).get(j).setRoad(true);
                }
            }
        }
    }

    // define the boared dimensions
    void dimension(int level) {
        switch (level) {
            case 1 -> {
                rows = 8;
                columns = 12;
            }
            case 2 -> {
                rows = 5;
                columns = 9;
            }
            case 3 -> {
                rows = 6;
                columns = 16;
            }
            case 4 -> {
                rows = 8;
                columns = 11;
            }
            case 5 -> {
                rows = 7;
                columns = 11;
            }
            case 6 -> {
                rows = 7;
                columns = 7;
            }
            default -> {
            }
        }
    }

    // choose the level
    void level(int level) {
        switch (level) {
            case 1 -> levelBoard = board1;
            case 2 -> levelBoard = board2;
            case 3 -> levelBoard = board3;
            case 4 -> levelBoard = board4;
            case 5 -> levelBoard = board5;
            case 6 -> levelBoard = board6;
            default -> System.out.println("you can choose only from 1 to 3");
        }
    }

    // moving
    State go(String key) {
        State currentState = new State(this);
        switch (key) {
            case "w" -> {
                int moves = 0;
                Map<ArrayList<ArrayList<Square>>, Integer> ret = new HashMap<>();
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
                                            && currentState.levelBoard.get(i - 1).get(j).block != true) {
                                        ret = goUp(currentState.levelBoard, i, j);
                                        for (Map.Entry<ArrayList<ArrayList<Square>>, Integer> res : ret.entrySet())
                                            moves += res.getValue();
                                    }
                                    if (currentState.levelBoard.get(i + 1).get(j).cube == true)
                                        moving.put(currentState.levelBoard.get(i + 1).get(j).cubeColor, true);
                                }
                            }
                        }
                    }
                }
                for (Map.Entry<ArrayList<ArrayList<Square>>, Integer> res : ret.entrySet())
                    currentState.levelBoard = res.getKey();
                currentState.cost = moves;
                moving.replaceAll((k, v) -> false);
            }
            case "s" -> {
                int moves = 0;
                Map<ArrayList<ArrayList<Square>>, Integer> ret = new HashMap<>();
                for (int i = 0; i < rows - 1; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (currentState.levelBoard.get(i).get(j).cube == true) {
                            if (currentState.levelBoard.get(i + 1).get(j).cube != true
                                    && currentState.levelBoard.get(i + 1).get(j).block != true) {
                                ret = goDown(currentState.levelBoard, i, j);
                                for (Map.Entry<ArrayList<ArrayList<Square>>, Integer> res : ret.entrySet())
                                    moves += res.getValue();
                            }
                        }
                    }
                }
                for (Map.Entry<ArrayList<ArrayList<Square>>, Integer> res : ret.entrySet())
                    currentState.levelBoard = res.getKey();
                currentState.cost = moves;
            }
            case "d" -> {
                int moves = 0;
                Map<ArrayList<ArrayList<Square>>, Integer> ret = new HashMap<>();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns - 1; j++) {
                        if (currentState.levelBoard.get(i).get(j).cube == true) {
                            if (currentState.levelBoard.get(i).get(j + 1).cube != true
                                    && currentState.levelBoard.get(i).get(j + 1).block != true) {
                                ret = goRight(currentState.levelBoard, i, j);
                                for (Map.Entry<ArrayList<ArrayList<Square>>, Integer> res : ret.entrySet())
                                    moves += res.getValue();
                            }
                        }
                    }
                }
                for (Map.Entry<ArrayList<ArrayList<Square>>, Integer> res : ret.entrySet())
                    currentState.levelBoard = res.getKey();
                currentState.cost = moves;
            }
            case "a" -> {
                int moves = 0;
                Map<ArrayList<ArrayList<Square>>, Integer> ret = new HashMap<>();
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
                                            && currentState.levelBoard.get(i).get(j - 1).block != true) {
                                        ret = goLeft(currentState.levelBoard, i, j);
                                        for (Map.Entry<ArrayList<ArrayList<Square>>, Integer> res : ret.entrySet())
                                            moves += res.getValue();
                                    }
                                    if (currentState.levelBoard.get(i).get(j + 1).cube == true) {
                                        moving.put(currentState.levelBoard.get(i).get(j + 1).cubeColor, true);
                                    }
                                }
                            }
                        }
                    }
                }
                for (Map.Entry<ArrayList<ArrayList<Square>>, Integer> res : ret.entrySet())
                    currentState.levelBoard = res.getKey();
                currentState.cost = moves;
                moving.replaceAll((k, v) -> false);
            }
            default -> {
                System.out.println("you can only use (w, a, s, d)");
            }
        }
        return currentState;
    }

    // moving up
    Map<ArrayList<ArrayList<Square>>, Integer> goUp(ArrayList<ArrayList<Square>> levelBoard, int i, int j) {
        Map<ArrayList<ArrayList<Square>>, Integer> ret = new HashMap<>();
        int moves = 0;
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
                    moves++;
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
                    moves++;
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
        ret.put(levelBoard, moves);
        return ret;
    }

    // moving down
    Map<ArrayList<ArrayList<Square>>, Integer> goDown(ArrayList<ArrayList<Square>> levelBoard, int i, int j) {
        Map<ArrayList<ArrayList<Square>>, Integer> ret = new HashMap<>();
        int moves = 0;
        while (i < rows - 1) {
            if (levelBoard.get(i).get(j).cube == true) {
                if (levelBoard.get(i + 1).get(j).road == true) {
                    levelBoard.get(i + 1).get(j).setRoad(false);
                    levelBoard.get(i + 1).get(j).setCube(true);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i + 1).get(j).setCubeColor(levelBoard.get(i).get(j).cubeColor);
                    levelBoard.get(i).get(j).setCubeColor("");
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                    moves++;
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
                    moves++;
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
        ret.put(levelBoard, moves);
        return ret;
    }

    // moving left
    Map<ArrayList<ArrayList<Square>>, Integer> goLeft(ArrayList<ArrayList<Square>> levelBoard, int i, int j) {
        Map<ArrayList<ArrayList<Square>>, Integer> ret = new HashMap<>();
        int moves = 0;
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
                    moves++;
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
                    moves++;
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
        ret.put(levelBoard, moves);
        return ret;
    }

    // moving right
    Map<ArrayList<ArrayList<Square>>, Integer> goRight(ArrayList<ArrayList<Square>> levelBoard, int i, int j) {
        Map<ArrayList<ArrayList<Square>>, Integer> ret = new HashMap<>();
        int moves = 0;
        while (j < columns - 1) {
            if (levelBoard.get(i).get(j).cube == true) {
                if (levelBoard.get(i).get(j + 1).road == true) {
                    levelBoard.get(i).get(j + 1).setRoad(false);
                    levelBoard.get(i).get(j + 1).setCube(true);
                    levelBoard.get(i).get(j + 1).setCubeColor(levelBoard.get(i).get(j).cubeColor);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i).get(j).setCubeColor("");
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                    moves++;
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
                    moves++;
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
        ret.put(levelBoard, moves);
        return ret;
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
                    square.setSymbol("[]");
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
        int goals = 0;
        int cubes = 0;
        boolean repeated;
        ArrayList<String> goalsColor = new ArrayList<>();
        for (ArrayList<Square> row : this.levelBoard) {
            for (Square square : row) {
                if (square.goal == true) {
                    goals++;
                    goalsColor.add(square.goalColor);
                }
                if (square.cube == true) {
                    cubes++;
                }
            }
        }
        HashSet<String> set = new HashSet<>(goalsColor);
        repeated = set.size() != goalsColor.size();
        return goals != cubes || repeated;
    }

    // check if two states are the same
    // boolean sameState(State first, State second) {
    //     for (int i = 0; i < first.levelBoard.size(); i++) {
    //         for (int j = 0; j < first.levelBoard.get(i).size(); j++) {
    //             if (first.levelBoard.get(i).get(j).block != second.levelBoard.get(i).get(j).block)
    //                 return false;
    //             if (first.levelBoard.get(i).get(j).cube != second.levelBoard.get(i).get(j).cube)
    //                 return false;
    //             if (first.levelBoard.get(i).get(j).goal != second.levelBoard.get(i).get(j).goal)
    //                 return false;
    //             if (first.levelBoard.get(i).get(j).out != second.levelBoard.get(i).get(j).out)
    //                 return false;
    //             if (first.levelBoard.get(i).get(j).road != second.levelBoard.get(i).get(j).road)
    //                 return false;
    //             if (first.levelBoard.get(i).get(j).trap != second.levelBoard.get(i).get(j).trap)
    //                 return false;
    //             if (!first.levelBoard.get(i).get(j).symbol.equals(second.levelBoard.get(i).get(j).symbol))
    //                 return false;
    //             if (!first.levelBoard.get(i).get(j).cubeColor.equals(second.levelBoard.get(i).get(j).cubeColor))
    //                 return false;
    //             if (!first.levelBoard.get(i).get(j).goalColor.equals(second.levelBoard.get(i).get(j).goalColor))
    //                 return false;
    //         }
    //     }
    //     return true;
    // }

    boolean sameState(State first) {
        for (int i = 0; i < first.levelBoard.size(); i++) {
            for (int j = 0; j < first.levelBoard.get(i).size(); j++) {
                if (first.levelBoard.get(i).get(j).block != this.levelBoard.get(i).get(j).block)
                    return false;
                if (first.levelBoard.get(i).get(j).cube != this.levelBoard.get(i).get(j).cube)
                    return false;
                if (first.levelBoard.get(i).get(j).goal != this.levelBoard.get(i).get(j).goal)
                    return false;
                if (first.levelBoard.get(i).get(j).out != this.levelBoard.get(i).get(j).out)
                    return false;
                if (first.levelBoard.get(i).get(j).road != this.levelBoard.get(i).get(j).road)
                    return false;
                if (first.levelBoard.get(i).get(j).trap != this.levelBoard.get(i).get(j).trap)
                    return false;
                if (!first.levelBoard.get(i).get(j).symbol.equals(this.levelBoard.get(i).get(j).symbol))
                    return false;
                if (!first.levelBoard.get(i).get(j).cubeColor.equals(this.levelBoard.get(i).get(j).cubeColor))
                    return false;
                if (!first.levelBoard.get(i).get(j).goalColor.equals(this.levelBoard.get(i).get(j).goalColor))
                    return false;
            }
        }
        return true;
    }

    // all of the possible coming moves
    ArrayList<State> nextStates(int level) {
        ArrayList<State> possibleMoves = new ArrayList<>();
        State parent = new State(this);

        State up = parent.go("w");
        if (!up.loseState() && !up.sameState(parent))
            possibleMoves.add(up);

        State down = parent.go("s");
        if (!down.loseState() && !down.sameState(parent))
            possibleMoves.add(down);

        State left = parent.go("a");
        if (!left.loseState() && !left.sameState(parent))
            possibleMoves.add(left);

        State right = parent.go("d");
        if (!right.loseState() && !right.sameState(parent))
            possibleMoves.add(right);

        return possibleMoves;
    }

}