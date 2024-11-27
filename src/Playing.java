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

      public static void main(String[] args) {
            Playing play = new Playing();
            Scanner input2 = new Scanner(System.in);
            System.out.println("Do you want to play (p), or get the solution by BFS(b) or DFS(d) or UCS(u) or DFS Recersion(dr)");
            String game = input2.nextLine();
            Scanner input1 = new Scanner(System.in);
            System.out.println("Choose a level from 1 to 3");
            int level = input1.nextInt();
            if ("p".equals(game))
                  play.startPlaying(level);
            if ("b".equals(game))
                  play.bfsSolving(level);
            if ("d".equals(game))
                  play.dfsSolving(level);
            if ("dr".equals(game))
                  play.dfsRecersion(level);
            if ("u".equals(game))
                  play.ucsSolving(level);
            input1.close();
            input2.close();
      }
}
