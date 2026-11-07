
import java.util.List;

public class AutoCompleteEngine {

    private final SuggestionEngine suggestionEngine;
    private final SearchHistory searchHistory;

    public AutoCompleteEngine() {
        suggestionEngine = new SuggestionEngine();
        searchHistory = new SearchHistory();
        loadDefaultSuggestions();
    }

    private void loadDefaultSuggestions() {
        suggestionEngine.addSuggestion("java programming", 95);
        suggestionEngine.addSuggestion("java tutorial", 90);
        suggestionEngine.addSuggestion("java collections", 85);
        suggestionEngine.addSuggestion("java multithreading", 80);
        suggestionEngine.addSuggestion("javascript", 75);

        suggestionEngine.addSuggestion("python programming", 92);
        suggestionEngine.addSuggestion("python tutorial", 88);
        suggestionEngine.addSuggestion("python machine learning", 84);

        suggestionEngine.addSuggestion("data structures", 89);
        suggestionEngine.addSuggestion("database management system", 78);
        suggestionEngine.addSuggestion("design patterns", 70);

        suggestionEngine.addSuggestion("machine learning", 87);
        suggestionEngine.addSuggestion("machine learning algorithms", 82);

        suggestionEngine.addSuggestion("git commands", 76);
        suggestionEngine.addSuggestion("github tutorial", 74);
    }

    public void search(String prefix) {

        if (prefix == null || prefix.trim().isEmpty()) {
            System.out.println("\nSearch query cannot be empty.");
            return;
        }

        String cleanedPrefix = prefix.trim();

        searchHistory.addSearch(cleanedPrefix);

        List<SearchSuggestion> results =
                suggestionEngine.getSuggestions(cleanedPrefix);

        System.out.println("\nSuggestions for \"" + cleanedPrefix + "\":");

        if (results.isEmpty()) {
            System.out.println("No matching suggestions found.");
            return;
        }

        int limit = Math.min(results.size(), 5);

        for (int i = 0; i < limit; i++) {
            System.out.println(
                    (i + 1) + ". " + results.get(i)
            );
        }
    }

    public void selectSuggestion(String keyword) {

        SearchSuggestion suggestion =
                suggestionEngine.findSuggestion(keyword);

        if (suggestion == null) {
            System.out.println("\nSuggestion not found.");
            return;
        }

        suggestionEngine.recordSelection(keyword);
        searchHistory.addSearch(keyword);

        System.out.println(
                "\nSelected: " + suggestion.getKeyword()
        );

        System.out.println(
                "Updated ranking score: " +
                suggestion.calculateScore()
        );
    }

    public void displayAllSuggestions() {

        List<SearchSuggestion> suggestions =
                suggestionEngine.getAllSuggestions();

        System.out.println(
                "\n========== AVAILABLE SEARCH TERMS =========="
        );

        for (int i = 0; i < suggestions.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + suggestions.get(i)
            );
        }

        System.out.println(
                "============================================"
        );
    }

    public void displaySearchHistory() {
        searchHistory.displayHistory();
    }

    public void clearSearchHistory() {
        searchHistory.clearHistory();
    }

    public int getTotalSearches() {
        return searchHistory.getSearchCount();
    }

    public SuggestionEngine getSuggestionEngine() {
        return suggestionEngine;
    }
}
