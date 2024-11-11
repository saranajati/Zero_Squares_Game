import java.util.ArrayList;
import java.util.Scanner;

public class Playing {
      Playing() {
      }

      ArrayList<State> steps = new ArrayList<>();
      State initState = new State();

      @SuppressWarnings("ConvertToTryWithResources")
      void startPlaying(int level) {
            initState.level(level);
            initState.printBoard(initState.levelBoard);
            Scanner scanner = new Scanner(System.in);
            String key;
            State firstStep;
            key = scanner.nextLine();
            initState.dimension(level);
            firstStep = new State(initState.go(key, initState));
            steps.add(firstStep);
            while (steps.get(steps.size() - 1).winState(steps.get(steps.size() - 1).levelBoard) != true) {
                  State nextStep;
                  key = scanner.nextLine();
                  steps.get(steps.size() - 1).dimension(level);
                  nextStep = new State(steps.get(steps.size() - 1).go(key, steps.get(steps.size() - 1)));
                  steps.add(nextStep);
            }
            scanner.close();
      }

      public static void main(String[] args) {
            Playing play = new Playing();
            play.startPlaying(1);
      }
}
