package net.yorkjr.jareau.exambank.question;

public enum QuestionType {
    SINGLE_CHOICE("single", "Single Choice");

    private String rawType;
    private String description;
    QuestionType(String rawType, String description) {
        this.rawType = rawType;
        this.description = description;
    }

    public String getRawType() {
        return rawType;
    }

    public String getDescription() {
        return description;
    }
}
