import java.util.ArrayList;
import java.util.Scanner;

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
      void dfs(int level) {
            State initState = new State();
            initState.level(level);
            initState.dimension(level);
            Graph graph = new Graph();
            graph.dfsRecersion(level, initState);
      }

      public static void main(String[] args) {
            Playing play = new Playing();
            play.dfs(3);
            // Scanner input2 = new Scanner(System.in);
            // System.out.println("Do you want to play (p), or get the solution by BFS(b) or DFS(d)");
            // String game = input2.nextLine();
            // Scanner input1 = new Scanner(System.in);
            // System.out.println("Choose a level from 1 to 3");
            // int level = input1.nextInt();
            // if ("p".equals(game))
            //       play.startPlaying(level);
            // if ("b".equals(game))
            //       play.bfsSolving(level);
            // if ("d".equals(game))
            //       play.dfsSolving(level);
            // input1.close();
            // input2.close();
      }
}
