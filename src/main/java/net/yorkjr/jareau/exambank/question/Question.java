package net.yorkjr.jareau.exambank.question;

import net.yorkjr.jareau.exambank.question.raw.RawQuestion;

import java.util.List;

public interface Question {
    public String getStatement();
    public List<Option> getOptions();
    public boolean isAnswerCorrect(Answer answer);
    public void initializeFrom(RawQuestion rawQuestion);
    public RawQuestion toRawQuestion();
}