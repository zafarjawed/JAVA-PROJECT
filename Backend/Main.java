import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class GlowUpQuiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("✨ Welcome to the GlowUp Quiz ✨");
        System.out.println("Please answer the following...");

        // Ask for user name
        System.out.print("What’s your name? ");
        String userName = scanner.nextLine();

        System.out.println("\nWhat’s your skin type?");
        System.out.println("1. Oily");
        System.out.println("2. Dry");
        System.out.println("3. Combination");
        System.out.println("4. Sensitive");
        System.out.print("Enter choice (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String skinType = "";
        switch (choice) {
            case 1: skinType = "Oily"; break;
            case 2: skinType = "Dry"; break;
            case 3: skinType = "Combination"; break;
            case 4: skinType = "Sensitive"; break;
            default: skinType = "Unknown";
        }

        System.out.print("\n✨ What’s your skincare goal? ");
        String goal = scanner.nextLine();

        // Save the data to a text file
        try {
            FileWriter writer = new FileWriter("quiz_responses.txt", true); // append mode
            writer.write("Name: " + userName + ", Skin Type: " + skinType + ", Goal: " + goal + "\n");
            writer.close();
            System.out.println("\n✅ Your quiz data is saved successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }

        // Provide a simple recommendation based on the skin type and goal
        String recommendation = generateRecommendation(skinType, goal);
        System.out.println("\n✨ Here’s your personalized recommendation:");
        System.out.println(recommendation);

        scanner.close();
        System.out.println("💖 Thank you for using GlowUp Quiz!");
    }

    // Method to generate a recommendation based on skin type and goal
    public static String generateRecommendation(String skinType, String goal) {
        String recommendation = "";

        // Recommendations based on skin type
        switch (skinType) {
            case "Oily":
                recommendation += "For oily skin, we recommend using a gentle foaming cleanser and oil-free moisturizers. ";
                break;
            case "Dry":
                recommendation += "For dry skin, opt for a hydrating cleanser and rich moisturizers. ";
                break;
            case "Combination":
                recommendation += "For combination skin, choose products that balance oil control and hydration. ";
                break;
            case "Sensitive":
                recommendation += "For sensitive skin, use fragrance-free and gentle products. ";
                break;
            default:
                recommendation += "We couldn’t identify your skin type, but we recommend hydrating products. ";
                break;
        }

        // Add skincare goal-based recommendation
        if (goal.toLowerCase().contains("anti-aging")) {
            recommendation += "Consider adding an anti-aging serum or products with Vitamin C.";
        } else if (goal.toLowerCase().contains("clear skin")) {
            recommendation += "Try a gentle exfoliating product and a blemish-control serum.";
        } else if (goal.toLowerCase().contains("hydrating")) {
            recommendation += "Make sure to use a moisturizer with hyaluronic acid for added hydration.";
        } else {
            recommendation += "Feel free to explore products based on your specific skin concerns!";
        }

        return recommendation;
    }
}
