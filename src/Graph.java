import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
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
                        if (notExist(visited, next)) {
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
                  for (State next : current.nextStates(level)) {
                        if (notExist(visited, next)) {
                              stack.push(next);
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

      // find the solution using DFS algorithem in recersion
      ArrayList<State> dfsRecursion(int level, State current, Set<State> visited, Map<State, State> parents) {
            if (current.winState()) {
                  ArrayList<State> solution = new ArrayList<>();
                  while (current != null) {
                        solution.add(current);
                        current = parents.get(current);
                  }
                  Collections.reverse(solution);
                  System.out.println();
                  System.out.println("\033[1;35mSolution:\033[0m");
                  for (State state : solution) {
                        state.printBoard();
                  }
                  int moves = solution.size() - 1;
                  System.out.println("\033[1;37mSolving moves : " + moves + "\033[0m");
                  return solution;
            }
            for (State next : current.nextStates(level)) {
                  if (notExist(visited, next)) {
                        visited.add(next);
                        parents.put(next, current);
                        ArrayList<State> result = dfsRecursion(level, next, visited, parents);
                        if (result != null) {
                              return result;
                        }
                  }
            }
            return null;
      }

      // find the solution using UCS algorithem
      ArrayList<State> ucs(int level, State initial) {
            PriorityQueue<State> priorityQueue = new PriorityQueue<>();
            Set<State> visited = new HashSet<>();
            ArrayList<State> solution = new ArrayList<>();
            Map<State, State> parents = new HashMap<>();
            Map<State, Integer> costs = new HashMap<>();
            int totalCost = 0;
            initial.cost = 0;
            priorityQueue.add(initial);
            costs.put(initial, 0);
            parents.put(initial, null);
            while (!priorityQueue.isEmpty()) {
                  State currentState = priorityQueue.poll();
                  int currentCost = costs.get(currentState);
                  if (currentState.winState()) {
                        while (currentState != null) {
                              solution.add(currentState);
                              totalCost += costs.get(currentState);
                              currentState = parents.get(currentState);
                        }
                        Collections.reverse(solution);
                        break;
                  }
                  for (State next : currentState.nextStates(level)) {
                        int newCost = currentCost + next.cost;
                        int nextCost;
                        if (costs.get(next) != null)
                              nextCost = costs.get(next);
                        else
                              nextCost = Integer.MAX_VALUE;
                        if (notExist(visited, next) || newCost < nextCost) {
                              visited.add(next);
                              next.cost = newCost;
                              parents.put(next, currentState);
                              costs.put(next, newCost);
                              priorityQueue.add(next);
                        }
                  }
            }
            System.out.println();
            System.out.println("\033[1;35mSolution:\033[0m");
            for (State state : solution) {
                  state.printBoard();
            }
            int moves = solution.size() - 1;
            System.out.println("\033[1;37mSolving moves : " + moves + "\033[0m");
            System.out.println("\033[1;37mTotal Cost : " + totalCost + "\033[0m");
            return solution;
      }

      // make sure that the state does not visited before
      boolean notExist(Set<State> visited, State next) {
            int counter = 0;
            State state = new State();
            for (State v : visited) {
                  if (state.sameState(v, next))
                        counter++;
            }
            return counter == 0;
      }
}
