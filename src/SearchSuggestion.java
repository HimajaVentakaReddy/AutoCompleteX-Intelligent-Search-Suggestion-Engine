public class SearchSuggestion {

    private String keyword;
    private int frequency;
    private int selectionCount;

    public SearchSuggestion(String keyword, int frequency) {
        this.keyword = keyword;
        this.frequency = frequency;
        this.selectionCount = 0;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getSelectionCount() {
        return selectionCount;
    }

    public void incrementFrequency() {
        frequency++;
    }

    public void incrementSelectionCount() {
        selectionCount++;
    }

    public int calculateScore() {
        return frequency + (selectionCount * 2);
    }

    @Override
    public String toString() {
        return keyword + " [Score: " + calculateScore() + "]";
    }
}
