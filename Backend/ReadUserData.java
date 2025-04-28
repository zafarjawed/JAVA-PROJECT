import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadUserData {
    public static void main(String[] args) {
        String fileName = "quiz_responses.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("📄 Saved Quiz Responses:\n");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("⚠️ Could not read the file. Make sure it exists and try again.");
        }
    }
}
