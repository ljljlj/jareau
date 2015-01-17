package net.yorkjr.jareau.exambank.question;

public class SingleChoiceOption implements Option {
    private boolean isAnswer;
    private String description;

    public SingleChoiceOption(boolean isAnswer, String description) {
        this.isAnswer = isAnswer;
        this.description = description;
    }

    @Override
    public boolean isAnswer() {
        return isAnswer;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("{option: %s }", description);
    }
}
