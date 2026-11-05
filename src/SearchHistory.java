import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SearchHistory {

    private final List<String> history;
    private final DateTimeFormatter formatter;

    public SearchHistory() {
        history = new ArrayList<>();
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    }

    public void addSearch(String query) {
        String record = query + " | " + LocalDateTime.now().format(formatter);
        history.add(record);
    }

    public void displayHistory() {

        if (history.isEmpty()) {
            System.out.println("\nNo search history available.");
            return;
        }

        System.out.println("\n========== SEARCH HISTORY ==========");

        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }

        System.out.println("====================================");
    }

    public void clearHistory() {
        history.clear();
        System.out.println("\nSearch history cleared successfully.");
    }

    public int getSearchCount() {
        return history.size();
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }
}
