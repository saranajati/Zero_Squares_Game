import java.util.ArrayList;
@SuppressWarnings("unused")

public class State {
    State() {
    }

    State(State another) {
        this.levelBoard = another.levelBoard;
    }

    public static final String RESET = "\033[0m";
    public static String COLOR = "";
    ArrayList<ArrayList<Square>> levelBoard;
    int rows, columns;

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
                if (board1.get(i).get(j).block == false && board1.get(i).get(j).out == false &&
                        board1.get(i).get(j).goal == false
                        && board1.get(i).get(j).cube == false && board1.get(i).get(j).trap == false) {
                    board1.get(i).get(j).setRoad(true);
                }
            }
        }
    }
    ArrayList<ArrayList<Square>> board2 = new ArrayList<>();
    {
        for (int i = 0; i < 7; i++) {
            ArrayList<Square> row = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
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
        board2.get(6).get(1).setBlock(true);
        board2.get(6).get(2).setBlock(true);
        board2.get(6).get(3).setBlock(true);
        board2.get(6).get(4).setBlock(true);
        board2.get(6).get(5).setBlock(true);
        board2.get(6).get(6).setBlock(true);
        board2.get(4).get(1).setBlock(true);
        board2.get(5).get(1).setBlock(true);
        board2.get(1).get(0).setBlock(true);
        board2.get(2).get(0).setBlock(true);
        board2.get(3).get(0).setBlock(true);
        board2.get(4).get(0).setBlock(true);
        board2.get(1).get(6).setBlock(true);
        board2.get(2).get(6).setBlock(true);
        board2.get(3).get(6).setBlock(true);
        board2.get(4).get(6).setBlock(true);
        board2.get(5).get(6).setBlock(true);

        board2.get(1).get(1).setGoal(true);
        board2.get(1).get(1).setGoalColor("blue");
        board2.get(1).get(1).setCube(true);
        board2.get(1).get(1).setCubeColor("yellow");

        board2.get(1).get(3).setGoal(true);
        board2.get(1).get(3).setGoalColor("yellow");
        board2.get(1).get(3).setCube(true);
        board2.get(1).get(3).setCubeColor("red");

        board2.get(1).get(5).setGoal(true);
        board2.get(1).get(5).setGoalColor("red");
        board2.get(1).get(5).setCube(true);
        board2.get(1).get(5).setCubeColor("blue");

        board2.get(5).get(0).setOut(true);
        board2.get(6).get(0).setOut(true);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (!board2.get(i).get(j).block && !board2.get(i).get(j).out && !board2.get(i).get(j).goal
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
                if (!board3.get(i).get(j).block && !board3.get(i).get(j).out && !board3.get(i).get(j).goal
                        && !board3.get(i).get(j).cube && !board3.get(i).get(j).trap) {
                    board3.get(i).get(j).setRoad(true);
                }
            }
        }
    }

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
    void dimension(int level) {
        switch (level) {
            case 1 -> {
                rows = 8;
                columns = 11;
            }
            case 2 -> {
                rows = 7;
                columns = 7;
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
    State go(String key, State currentState) {
        switch (key) {
            case "w" -> {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (currentState.levelBoard.get(i).get(j).cube == true) {
                            if (i > 0) {
                                if (currentState.levelBoard.get(i - 1).get(j).cube != true
                                        && currentState.levelBoard.get(i - 1).get(j).block != true)
                                    currentState.levelBoard = goUp(currentState.levelBoard, i, j);
                            }
                        }
                    }
                }
                printBoard(currentState.levelBoard);
                if (winState(currentState.levelBoard)) {
                    System.out.println("\033[1;36m" + "________Winner________" + RESET);
                }
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
                printBoard(currentState.levelBoard);
                if (winState(currentState.levelBoard)) {
                    System.out.println("\033[1;36m" + "________Winner________" + RESET);
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
                printBoard(currentState.levelBoard);
                if (winState(currentState.levelBoard)) {
                    System.out.println("\033[1;36m" + "________Winner________" + RESET);
                }
            }
            case "a" -> {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        if (currentState.levelBoard.get(i).get(j).cube == true) {
                            if (j > 0) {
                                if (currentState.levelBoard.get(i).get(j - 1).cube != true
                                        && currentState.levelBoard.get(i).get(j - 1).block != true)
                                    currentState.levelBoard = goLeft(currentState.levelBoard, i, j);
                            }
                        }
                    }
                }
                printBoard(currentState.levelBoard);
                if (winState(currentState.levelBoard)) {
                    System.out.println("\033[1;36m" + "________Winner________" + RESET);
                }
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
                if (levelBoard.get(i - 1).get(j).road == true) {
                    levelBoard.get(i - 1).get(j).setRoad(false);
                    levelBoard.get(i - 1).get(j).setCube(true);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i - 1).get(j).setCubeColor(levelBoard.get(i).get(j).cubeColor);
                    levelBoard.get(i).get(j).setCubeColor("");
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                } else if (levelBoard.get(i - 1).get(j).goal == true) {
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
                    System.out.println("\033[1;36m" + "________GAME OVER________" + RESET);
                    System.out.println();
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
                if (levelBoard.get(i + 1).get(j).road == true) {
                    levelBoard.get(i + 1).get(j).setRoad(false);
                    levelBoard.get(i + 1).get(j).setCube(true);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i + 1).get(j).setCubeColor(levelBoard.get(i).get(j).cubeColor);
                    levelBoard.get(i).get(j).setCubeColor("");
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                } else if (levelBoard.get(i + 1).get(j).goal == true) {
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
                    System.out.println("\033[1;36m" + "________GAME OVER________" + RESET);
                    System.out.println();
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
                if (levelBoard.get(i).get(j - 1).road == true) {
                    levelBoard.get(i).get(j - 1).setRoad(false);
                    levelBoard.get(i).get(j - 1).setCube(true);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i).get(j - 1).setCubeColor(levelBoard.get(i).get(j).cubeColor);
                    levelBoard.get(i).get(j).setCubeColor("");
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                } else if (levelBoard.get(i).get(j - 1).goal == true) {
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
                    System.out.println("\033[1;36m" + "________GAME OVER________" + RESET);
                    System.out.println();
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
                if (levelBoard.get(i).get(j + 1).road == true) {
                    if (levelBoard.get(i).get(j).goal != true) {
                        levelBoard.get(i).get(j).setRoad(true);
                    }
                    levelBoard.get(i).get(j + 1).setRoad(false);
                    levelBoard.get(i).get(j + 1).setCube(true);
                    levelBoard.get(i).get(j + 1).setCubeColor(levelBoard.get(i).get(j).cubeColor);
                    levelBoard.get(i).get(j).setCube(false);
                    levelBoard.get(i).get(j).setCubeColor("");
                } else if (levelBoard.get(i).get(j + 1).goal == true) {
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
                    System.out.println("\033[1;36m" + "________GAME OVER________" + RESET);
                    System.out.println();
                    break;
                }
            }
            j++;
        }
        return levelBoard;
    }

    // printing the boared
    void printBoard(ArrayList<ArrayList<Square>> levelBoard) {
        System.out.println();
        for (ArrayList<Square> row : levelBoard) {
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
                }
                System.out.print(COLOR + square.symbol + RESET);
            }
            System.out.println();
        }
        System.out.println();
    }

    // check if the game is ended
    boolean winState(ArrayList<ArrayList<Square>> levelBoard) {
        int counter = 0;
        for (ArrayList<Square> row : levelBoard) {
            for (Square square : row) {
                if (square.goal == true) {
                    counter++;
                }
            }
        }
        return counter == 0;
    }

    // all of the possible coming moves
    ArrayList<State> nextStates(State currentState) {
        ArrayList<State> possibleMoves = new ArrayList<>();
        State upState = new State(currentState);
        if (!sameState(go("w", upState), currentState))
            possibleMoves.add(upState);
        State downState = new State(currentState);
        if (!sameState(go("s", downState), currentState))
            possibleMoves.add(downState);
        State rightState = new State(currentState);
        if (!sameState(go("d", rightState), currentState))
            possibleMoves.add(rightState);
        State leftState = new State(currentState);
        if (!sameState(go("a", leftState), currentState))
            possibleMoves.add(leftState);
        return possibleMoves;
    }
    
    // for (State state1 : possibleMoves) {
    // for (State state2 : possibleMoves) {
    // if (sameState(state1, state2))
    // possibleMoves.remove(state2);
    // }
    // }

    // check if two states are the same
    boolean sameState(State first, State second) {
        return first.equals(second);
    }
}