import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

class LogGenerator {
    public void loggerHelper(String algorithm, int level, ArrayList<State> solution, Set<State> visited, double time,
            double memory) throws IOException {
        String fileName = algorithm + ".log";
        int moves = solution.size()-1;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./logs/" + fileName, true))) {
            writer.write("Level : " + level + "0");
            writer.newLine();
            writer.write("Algorithm : " + algorithm);
            writer.newLine();
            writer.write("Visited states : " + visited.size());
            writer.newLine();
            writer.write("Solving moves : " + moves);
            writer.newLine();
            writer.write("Memory : " + memory + " MB");
            writer.newLine();
            writer.write("Duration : " + time + " ms");
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the log file: " + e.getMessage());
        }
    }
}
