import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
      class Position {
            int x, y;

            Position(int x, int y) {
                  this.x = x;
                  this.y = y;
            }
      }

      // find the solution using Bredth First Search algorithem
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
                        if (!exist(visited, next)) {
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

      // find the solution using Deep First Search algorithem
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
                        if (!exist(visited, next)) {
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

      // find the solution using Deep First Search algorithem in recersion
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
                  System.out.println("\033[1;37mVisited states : " + visited.size() + "\033[0m");
                  System.out.println("\033[1;37mSolving moves : " + moves + "\033[0m");
                  return solution;
            }
            for (State next : current.nextStates(level)) {
                  if (!exist(visited, next)) {
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

      // find the solution using Uniform Cost Search algorithem
      ArrayList<State> ucs(int level, State initial) {
            Comparator<State> comparator = Comparator.comparingInt(s -> s.cost);
            PriorityQueue<State> priorityQueue = new PriorityQueue<>(comparator);
            Set<State> visited = new HashSet<>();
            Map<State, State> parents = new HashMap<>();
            int totalCost;
            priorityQueue.add(initial);
            visited.add(initial);
            parents.put(initial, null);
            while (!priorityQueue.isEmpty()) {
                  State currentState = priorityQueue.poll();
                  if (currentState.winState()) {
                        ArrayList<State> solution = new ArrayList<>();
                        while (currentState != null) {
                              solution.add(currentState);
                              currentState = parents.get(currentState);
                        }
                        totalCost = solution.get(0).cost;
                        Collections.reverse(solution);
                        System.out.println();
                        System.out.println("\033[1;35mSolution:\033[0m");
                        for (State state : solution) {
                              state.printBoard();
                        }
                        int moves = solution.size() - 1;
                        System.out.println("\033[1;37mVisited states: " + visited.size() + "\033[0m");
                        System.out.println("\033[1;37mSolving moves : " + moves + "\033[0m");
                        System.out.println("\033[1;37mTotal Cost : " + totalCost + "\033[0m");
                        return solution;
                  }
                  for (State next : currentState.nextStates(level)) {
                        int newCost = currentState.cost + next.cost;
                        if (!exist(visited, next)) {
                              next.cost = newCost;
                              visited.add(next);
                              parents.put(next, currentState);
                              priorityQueue.add(next);
                        } else {
                              State visitedBefore = visitedState(visited, next);
                              if (newCost < visitedBefore.cost) {
                                    next.cost = newCost;
                                    visited.remove(visitedBefore);
                                    visited.add(next);
                                    parents.put(next, currentState);
                                    priorityQueue.add(next);
                              }
                        }
                  }
            }
            return null;
      }

      // find the solution using Simple Hill Climbing algorithem
      ArrayList<State> shc(int level, State initial) {
            ArrayList<State> solution = new ArrayList<>();
            State currentState = new State(initial);
            currentState.heuristic = manhattanHeuristic(currentState);
            solution.add(currentState);
            int totalHeuristic = currentState.heuristic;
            while (!currentState.winState()) {
                  State neighbor = neighbor(currentState, level);
                  if (currentState.sameState(neighbor)) {
                        System.out.println("Stuck in local maximum :");
                        currentState.printBoard();
                        return solution;
                  } else {
                        currentState = neighbor;
                        solution.add(neighbor);
                        totalHeuristic += neighbor.heuristic;
                  }
            }
            System.out.println();
            System.out.println("\033[1;35mSolution:\033[0m");
            for (State state : solution) {
                  state.printBoard();
            }
            int moves = solution.size() - 1;
            System.out.println("\033[1;37mSolving moves : " + moves + "\033[0m");
            System.out.println("\033[1;37mTotal heuristic : " + totalHeuristic + "\033[0m");
            return solution;
      }

      // find the solution using Steepest Acsent Hill Climbing algorithem
      ArrayList<State> sahc(int level, State initial) {
            ArrayList<State> solution = new ArrayList<>();
            State currentState = new State(initial);
            currentState.heuristic = manhattanHeuristic(currentState);
            solution.add(currentState);
            int totalHeuristic = currentState.heuristic;
            while (!currentState.winState()) {
                  State neighbor = minNeighbor(currentState, level);
                  if (currentState.sameState(neighbor)) {
                        System.out.println("Stuck in local maximum :");
                        currentState.printBoard();
                        return solution;
                  } else {
                        solution.add(neighbor);
                        totalHeuristic += neighbor.heuristic;
                        currentState = neighbor;
                  }
            }
            System.out.println();
            System.out.println("\033[1;35mSolution:\033[0m");
            for (State state : solution) {
                  state.printBoard();
            }
            int moves = solution.size() - 1;
            System.out.println("\033[1;37mSolving moves : " + moves + "\033[0m");
            System.out.println("\033[1;37mTotal heuristic : " + totalHeuristic + "\033[0m");
            return solution;
      }

      // find the solution using A* algorithem
      ArrayList<State> aStar(int level, State initial) {
            Comparator<State> comparator = Comparator.comparingInt(s -> s.f);
            PriorityQueue<State> priorityQueue = new PriorityQueue<>(comparator);
            Set<State> visited = new HashSet<>();
            Map<State, State> parents = new HashMap<>();
            ArrayList<State> solution = new ArrayList<>();
            int totalCost;
            priorityQueue.add(initial);
            visited.add(initial);
            parents.put(initial, null);
            while (!priorityQueue.isEmpty()) {
                  State currentState = priorityQueue.poll();
                  if (currentState.winState()) {
                        while (currentState != null) {
                              solution.add(currentState);
                              currentState = parents.get(currentState);
                        }
                        totalCost = solution.get(0).f;
                        Collections.reverse(solution);
                        System.out.println();
                        System.out.println("\033[1;35mSolution:\033[0m");
                        for (State state : solution) {
                              state.printBoard();
                        }
                        int moves = solution.size() - 1;
                        System.out.println("\033[1;37mVisited states: " + visited.size() + "\033[0m");
                        System.out.println("\033[1;37mSolving moves : " + moves + "\033[0m");
                        System.out.println("\033[1;37mTotal cost : " + totalCost +"\033[0m");
                        return solution;
                  }
                  for (State next : currentState.nextStates(level)) {
                        int cost = currentState.cost + next.cost;
                        int heuristic = manhattanHeuristic(next);
                        int f = cost + heuristic;
                        if (!exist(visited, next)) {
                              next.cost = cost;
                              next.f = f;
                              visited.add(next);
                              parents.put(next, currentState);
                              priorityQueue.add(next);
                        } else {
                              State visitedBefore = visitedState(visited, next);
                              if (f < visitedBefore.f) {
                                    next.cost = cost;
                                    next.f = f;
                                    visited.remove(visitedBefore);
                                    visited.add(next);
                                    parents.put(next, currentState);
                                    priorityQueue.add(next);
                              }
                        }
                  }
            }
            return solution;
      }

      // make sure that the state haven't been visited before
      boolean exist(Set<State> visited, State next) {
            for (State v : visited) {
                  if (v.sameState(next))
                        return true;
            }
            return false;
      }

      // return the visited state from visited set
      State visitedState(Set<State> visited, State next) {
            for (State v : visited) {
                  if (v.sameState(next))
                        return v;
            }
            return null;
      }

      // get the first less heuristic next state
      State neighbor(State currentState, int level) {
            for (State next : currentState.nextStates(level)) {
                  next.heuristic = manhattanHeuristic(next);
                  if (next.heuristic < currentState.heuristic)
                        return next;
            }
            return currentState;
      }

      // get the smallest heuristic next state
      State minNeighbor(State currentState, int level) {
            Map<State, Integer> neighbors = new HashMap<>();
            for (State next : currentState.nextStates(level))
                  neighbors.put(next, manhattanHeuristic(next));
            int minHeuristic = Collections.min(neighbors.values());
            for (Map.Entry<State, Integer> neighbor : neighbors.entrySet()) {
                  if (neighbor.getValue().equals(minHeuristic)) {
                        State minState = neighbor.getKey();
                        minState.heuristic = minHeuristic;
                        return minState;
                  }
            }
            return null;
      }

      // calculating manhattan heuristic
      int manhattanHeuristic(State current) {
            Map<String, Position> goals = new HashMap<>();
            Map<String, Position> cubes = new HashMap<>();
            int heuristic = 0;
            int distance;
            for (int i = 0; i < State.rows; i++) {
                  for (int j = 0; j < State.columns; j++) {
                        if (current.levelBoard.get(i).get(j).cube == true) {
                              Position position = new Position(i, j);
                              cubes.put(current.levelBoard.get(i).get(j).cubeColor, position);
                        }
                        if (current.levelBoard.get(i).get(j).goal == true) {
                              Position position = new Position(i, j);
                              goals.put(current.levelBoard.get(i).get(j).goalColor, position);
                        }
                  }
            }
            for (Map.Entry<String, Position> goal : goals.entrySet()) {
                  for (Map.Entry<String, Position> cube : cubes.entrySet()) {
                        if (cube.getKey().equals(goal.getKey())) {
                              distance = Math.abs(cube.getValue().x - goal.getValue().x)
                                          + Math.abs(cube.getValue().y - goal.getValue().y);
                              heuristic += distance;
                        }
                  }
            }
            current.heuristic = heuristic;
            return heuristic;
      }

}
