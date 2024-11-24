import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

      // find the solution using BFS algorithem
      ArrayList<State> bfs(int level, State initial) {
            Queue<State> queue = new LinkedList<>();
            Set<State> visited = new HashSet<>();
            ArrayList<State> solution = new ArrayList<>();
            Map<State, State> parents = new HashMap<>();
            queue.add(initial);
            visited.add(initial);
            parents.put(initial, null);
            while (!queue.isEmpty()) {
                  State current = queue.poll();
                  if (current.winState()) {
                        while (current != null) {
                              solution.add(current);
                              current = parents.get(current);
                        }
                        Collections.reverse(solution);
                        break;
                  }
                  for (State next : current.nextStates(level)) {
                        if (!visited.contains(next)) {
                              queue.add(next);
                              visited.add(next);
                              parents.put(next, current);
                        }
                  }
            }
            System.out.println();
            System.out.println("\033[1;35mSolution:\033[0m");
            for (State state : solution) {
                  state.printBoard();
            }
            int moves = solution.size() - 1;
            System.out.println("\033[1;37mVisited states : " + visited.size() + "\033[0m");
            System.out.println("\033[1;37mSolving moves : " + moves + "\033[0m");
            return solution;
      }

      // find the solution using DFS algorithem
      ArrayList<State> dfs(int level, State initial) {
            Stack<State> stack = new Stack<>();
            Set<State> visited = new HashSet<>();
            ArrayList<State> solution = new ArrayList<>();
            Map<State, State> parents = new HashMap<>();
            stack.push(initial);
            visited.add(initial);
            parents.put(initial, null);
            while (!stack.isEmpty()) {
                  State current = stack.pop();
                  if (current.winState()) {
                        while (current != null) {
                              solution.add(current);
                              current = parents.get(current);
                        }
                        Collections.reverse(solution);
                        break;
                  }
                  // for (State next : current.nextStates(level)) {
                  //       if (notExist(visited, next)) {
                  //             stack.push(next);
                  //             visited.add(next);
                  //             parents.put(next, current);
                  //       }
                  // }
            }
            System.out.println();
            System.out.println("\033[1;35mSolution:\033[0m");
            for (State state : solution) {
                  state.printBoard();
            }
            int moves = solution.size() - 1;
            System.out.println("\033[1;37mVisited states : " + visited.size() + "\033[0m");
            System.out.println("\033[1;37mSolving moves : " + moves + "\033[0m");
            return solution;
      }

      // make sure that the state does not visited before
      boolean notExist(ArrayList<State> visited, State next) {
            int counter = 0;
            State state = new State();
            for (State v : visited) {
                  if (state.sameState(v, next))
                        counter++;
            }
            return counter == 0;
      }

      ArrayList<State> dfsRecersion(int level, State state) {
            // Set<State> visited = new HashSet<>();
            ArrayList<State> solution = new ArrayList<>();
            while (!state.winState()) {
                  if (notExist(solution, state)) {  
                        solution.add(state);
                  }
              State  next =  state.nextStates(level).get(0);
              dfsRecersion(level, next);
                  
            }
            System.out.println();
            System.out.println("\033[1;35mSolution:\033[0m");
            for (State s : solution) {
                  s.printBoard();
            }
            int moves = solution.size() - 1;
            System.out.println("\033[1;37mVisited states : " + solution.size() + "\033[0m");
            System.out.println("\033[1;37mSolving moves : " + moves + "\033[0m");
            return solution;
      }
}
