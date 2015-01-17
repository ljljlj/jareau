package net.yorkjr.jareau.exambank.question.raw;

import java.util.List;

public class RawQuestion {
    private String statement;
    private List<RawOption> options;
    private List<RawAnswers> answers;
    private String type;

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public List<RawOption> getOptions() {
        return options;
    }

    public void setOptions(List<RawOption> options) {
        this.options = options;
    }

    public List<RawAnswers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<RawAnswers> answers) {
        this.answers = answers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
