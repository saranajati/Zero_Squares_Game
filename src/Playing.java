import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("ConvertToTryWithResources")

public class Playing {
      Playing() {
      }

      ArrayList<State> steps = new ArrayList<>();
      State initState = new State();

      void startPlaying(int level) {
            initState.level(level);
            initState.dimension(level);
            initState.printBoard(initState.levelBoard);
            // initState.nextStates(level);
            Scanner scanner = new Scanner(System.in);
            String key = scanner.nextLine();
            steps.add(initState.go(key));
            while (steps.get(steps.size() - 1).winState(steps.get(steps.size() - 1).levelBoard) != true) {
                  key = scanner.nextLine();
                  steps.get(steps.size() - 1).dimension(level);
                  steps.add(steps.get(steps.size() - 1).go(key));
            }
            scanner.close();
      }
      // for (State step : steps) {
      // System.out.println("step :");
      // step.printBoard(step.levelBoard);
      // }

      public static void main(String[] args) {
            Playing play = new Playing();
            // System.out.println("Choose a level from 1 to 3");
            // Scanner scanner = new Scanner(System.in);
            // int level = scanner.nextInt();
            play.startPlaying(1);
            // scanner.close();
      }
}
