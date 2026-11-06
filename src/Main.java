import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AutoCompleteEngine autoCompleteEngine = new AutoCompleteEngine();
        SearchAnalytics searchAnalytics = new SearchAnalytics();

        int choice;

        do {

            System.out.println("\n==============================================");
            System.out.println("          AutoCompleteX Search Engine");
            System.out.println("==============================================");
            System.out.println("1. Search Suggestions");
            System.out.println("2. Select Suggestion");
            System.out.println("3. View All Suggestions");
            System.out.println("4. View Search History");
            System.out.println("5. View Top Suggestions");
            System.out.println("6. View Search Analytics");
            System.out.println("7. Clear Search History");
            System.out.println("8. Exit");
            System.out.println("==============================================");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("\nEnter search prefix: ");
                    String prefix = scanner.nextLine();

                    autoCompleteEngine.search(prefix);
                    break;

                case 2:
                    System.out.print("\nEnter suggestion to select: ");
                    String keyword = scanner.nextLine();

                    autoCompleteEngine.selectSuggestion(keyword);
                    break;

                case 3:
                    autoCompleteEngine.displayAllSuggestions();
                    break;

                case 4:
                    autoCompleteEngine.displaySearchHistory();
                    break;

                case 5:
                    searchAnalytics.displayTopSuggestions(
                            autoCompleteEngine.getSuggestionEngine()
                    );
                    break;

                case 6:
                    searchAnalytics.displayStatistics(
                            autoCompleteEngine.getSuggestionEngine(),
                            autoCompleteEngine.getTotalSearches()
                    );
                    break;

                case 7:
                    autoCompleteEngine.clearSearchHistory();
                    break;

                case 8:
                    System.out.println(
                            "\nThank you for using AutoCompleteX!"
                    );
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice. Please select between 1 and 8."
                    );
            }

        } while (choice != 8);

        scanner.close();
    }
}
