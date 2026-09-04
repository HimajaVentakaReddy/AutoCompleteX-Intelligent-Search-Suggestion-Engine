import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SuggestionEngine {

    private final List<SearchSuggestion> suggestions;

    public SuggestionEngine() {
        suggestions = new ArrayList<>();
    }

    public void addSuggestion(String keyword, int frequency) {
        suggestions.add(new SearchSuggestion(keyword, frequency));
    }

    public List<SearchSuggestion> getSuggestions(String prefix) {

        List<SearchSuggestion> matchedSuggestions = new ArrayList<>();

        for (SearchSuggestion suggestion : suggestions) {
            if (suggestion.getKeyword()
                    .toLowerCase()
                    .startsWith(prefix.toLowerCase())) {

                matchedSuggestions.add(suggestion);
            }
        }

        matchedSuggestions.sort(
                Comparator.comparingInt(SearchSuggestion::calculateScore)
                        .reversed()
                        .thenComparing(SearchSuggestion::getKeyword)
        );

        return matchedSuggestions;
    }

    public SearchSuggestion findSuggestion(String keyword) {

        for (SearchSuggestion suggestion : suggestions) {
            if (suggestion.getKeyword().equalsIgnoreCase(keyword)) {
                return suggestion;
            }
        }

        return null;
    }

    public void recordSelection(String keyword) {

        SearchSuggestion suggestion = findSuggestion(keyword);

        if (suggestion != null) {
            suggestion.incrementSelectionCount();
            suggestion.incrementFrequency();
        }
    }

    public List<SearchSuggestion> getAllSuggestions() {
        return new ArrayList<>(suggestions);
    }
}