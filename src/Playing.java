import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("ConvertToTryWithResources")

public class Playing {

      Playing() {
      }

      void startPlaying(int level) {
            ArrayList<State> steps = new ArrayList<>();
            State initState = new State();
            initState.level(level);
            initState.dimension(level);
            initState.printBoard();
            Scanner scanner = new Scanner(System.in);
            String key = scanner.nextLine();
            steps.add(initState.go(key));
            steps.get(steps.size() - 1).printBoard();
            while (steps.get(steps.size() - 1).winState() != true && steps.get(steps.size() - 1).loseState() != true) {
                  key = scanner.nextLine();
                  if ("h".equals(key))
                        steps.get(steps.size() - 1).nextStates(level);
                  else {
                        steps.add(steps.get(steps.size() - 1).go(key));
                        steps.get(steps.size() - 1).printBoard();
                  }
            }
            scanner.close();
      }

      void bfsSolving(int level) {
            State initState = new State();
            initState.level(level);
            initState.dimension(level);
            Graph graph = new Graph();
            graph.bfs(level, initState);
      }

      void dfsSolving(int level) {
            State initState = new State();
            initState.level(level);
            initState.dimension(level);
            Graph graph = new Graph();
            graph.dfs(level, initState);
      }

      void dfsRecersion(int level) {
            Set<State> visited = new HashSet<>();
            Map<State, State> parents = new HashMap<>();
            State initState = new State();
            initState.level(level);
            initState.dimension(level);
            Graph graph = new Graph();
            graph.dfsRecursion(level, initState, visited, parents);
      }

      void ucsSolving(int level) {
            State initState = new State();
            initState.level(level);
            initState.dimension(level);
            Graph graph = new Graph();
            graph.ucs(level, initState);
      }

      void shcSolving(int level) {
            State initState = new State();
            initState.level(level);
            initState.dimension(level);
            Graph graph = new Graph();
            graph.shc(level, initState);
      }

      void sahcSolving(int level) {
            State initState = new State();
            initState.level(level);
            initState.dimension(level);
            Graph graph = new Graph();
            graph.sahc(level, initState);
      }

      void aStarSolving(int level) {
            State initState = new State();
            initState.level(level);
            initState.dimension(level);
            Graph graph = new Graph();
            graph.aStar(level, initState);
      }

      public static void main(String[] args) {
            long startTime = System.currentTimeMillis();
            long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            Playing play = new Playing();
            Scanner input1 = new Scanner(System.in);
            System.out.println("Choose a level from 1 to 6");
            State state = new State();
            for (int i = 1; i <= 6 ; i++) {
                  state.level(i);
                  state.dimension(i);
                  state.printBoard();
            }
            int level = input1.nextInt();
            Scanner input2 = new Scanner(System.in);
            System.out.println(
                        "Do you want to : \n1-Play \n2-BFS solution \n3-DFS solution \n4-DFS Recersion solution \n5-UCS solution \n6-Simple HC solution \n7-Steepest Acsent HC solution \n8-A* solution");
            int game = input2.nextInt();
            if (game == 1)
                  play.startPlaying(level);
            if (game == 2)
                  play.bfsSolving(level);
            if (game == 3)
                  play.dfsSolving(level);
            if (game == 4)
                  play.dfsRecersion(level);
            if (game == 5)
                  play.ucsSolving(level);
            if (game == 6)
                  play.shcSolving(level);
            if (game == 7)
                  play.sahcSolving(level);
            if (game == 8)
                  play.aStarSolving(level);
            input1.close();
            input2.close();
            long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.println("\033[1;37mUsed memory : " + Math.abs(startMemory - endMemory) / 1048576 + " MB\033[0m");
            long endTime = System.currentTimeMillis();
            System.out.println("\033[1;37mRun time : " + (endTime - startTime) / 1000 + " s\033[0m");
      }
}