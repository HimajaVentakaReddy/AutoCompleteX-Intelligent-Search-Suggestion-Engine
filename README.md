# AutoCompleteX — Intelligent Search Suggestion Engine

AutoCompleteX is a Java-based intelligent search suggestion engine that demonstrates how modern autocomplete systems can rank, learn, and improve suggestions based on user interaction.

The project focuses on clean object-oriented design, prefix matching, dynamic ranking, search history tracking, and basic analytics.

## ✨ Features

* Prefix-based search suggestions
* Case-insensitive matching
* Ranking based on frequency and user selections
* Dynamic score updates after a suggestion is selected
* Search history with timestamps
* Search analytics
* Top suggestion ranking
* Search history clearing
* Input validation
* Modular Java class structure

## 🧠 How Ranking Works

Each suggestion maintains:

* Base frequency
* Number of times selected
* Calculated ranking score

The score is calculated as:

```text
Score = Frequency + (Selection Count × 2)
```

Whenever a user selects a suggestion:

* Its selection count increases
* Its frequency increases
* Its ranking score is recalculated

This allows frequently selected suggestions to gradually become more relevant.

## 📂 Project Structure

```text
AutoCompleteX-Intelligent-Search-Suggestion-Engine
│
├── README.md
├── .gitignore
│
└── src
    ├── AutoCompleteEngine.java
    ├── Main.java
    ├── SearchAnalytics.java
    ├── SearchHistory.java
    ├── SearchSuggestion.java
    └── SuggestionEngine.java
```

## 🛠 Technologies Used

* Java 17
* Object-Oriented Programming
* Java Collections Framework
* ArrayList
* Comparator
* LocalDateTime
* Scanner
* Git
* GitHub
* Visual Studio Code

## 🚀 How to Run

Compile the project:

```bash
javac -d out src/*.java
```

Run the application:

```bash
java -cp out Main
```

## 📌 Menu Options

```text
1. Search Suggestions
2. Select Suggestion
3. View All Suggestions
4. View Search History
5. View Top Suggestions
6. View Search Analytics
7. Clear Search History
8. Exit
```

## 💡 Example

Searching with:

```text
java
```

can return:

```text
java programming
java tutorial
java collections
java multithreading
javascript
```

If `java programming` is selected, its ranking score increases and it becomes more relevant in future suggestions.

## 🎯 Concepts Demonstrated

* Classes and Objects
* Encapsulation
* Constructors
* Collections
* Searching
* Sorting
* Comparator
* String manipulation
* Input validation
* Date and time handling
* Modular design
* Separation of responsibilities
* Basic recommendation/ranking logic

## 🔮 Future Enhancements

Possible improvements include:

* Trie-based autocomplete
* Fuzzy matching
* Typo correction
* Persistent search history
* File or database storage
* User-specific ranking
* Recent search weighting
* REST API support
* GUI or web interface
* Machine-learning-based ranking

## 👩‍💻 Author

**Himaja V**

Built as part of a Java learning and GitHub portfolio journey.

## ⭐ Project Goal

The goal of AutoCompleteX is to simulate the core behavior of a real-world autocomplete and search recommendation system while keeping the implementation understandable, modular, and extendable.

