import java.util.Comparator;
import java.util.List;

public class SearchAnalytics {

    public void displayTopSuggestions(SuggestionEngine suggestionEngine) {

        List<SearchSuggestion> suggestions =
                suggestionEngine.getAllSuggestions();

        suggestions.sort(
                Comparator.comparingInt(SearchSuggestion::calculateScore)
                        .reversed()
        );

        System.out.println("\n========== TOP SEARCH SUGGESTIONS ==========");

        int limit = Math.min(5, suggestions.size());

        for (int i = 0; i < limit; i++) {
            SearchSuggestion suggestion = suggestions.get(i);

            System.out.println(
                    (i + 1) + ". " +
                    suggestion.getKeyword() +
                    " | Score: " +
                    suggestion.calculateScore()
            );
        }

        System.out.println("============================================");
    }

    public void displayStatistics(
            SuggestionEngine suggestionEngine,
            int totalSearches
    ) {

        List<SearchSuggestion> suggestions =
                suggestionEngine.getAllSuggestions();

        int totalSelections = 0;
        int totalFrequency = 0;

        for (SearchSuggestion suggestion : suggestions) {
            totalSelections += suggestion.getSelectionCount();
            totalFrequency += suggestion.getFrequency();
        }

        System.out.println("\n========== SEARCH ANALYTICS ==========");
        System.out.println("Total available suggestions : " + suggestions.size());
        System.out.println("Total searches performed    : " + totalSearches);
        System.out.println("Total suggestion selections : " + totalSelections);
        System.out.println("Combined keyword frequency  : " + totalFrequency);
        System.out.println("======================================");
    }
}