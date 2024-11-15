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

      public static void main(String[] args) {
            Playing play = new Playing();
            System.out.println("Choose a level from 1 to 3");
            Scanner scanner = new Scanner(System.in);
            int level = scanner.nextInt();
            play.startPlaying(level);
            scanner.close();
      }
}
