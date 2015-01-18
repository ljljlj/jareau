package net.yorkjr.jareau.exambank.question;

import net.yorkjr.jareau.controller.QuestionForm;
import net.yorkjr.jareau.exambank.question.raw.RawQuestion;

import java.util.List;

public interface Question {
    public long getQuestionId();
    public void setQuestionId(long questionId);
    public String getStatement();
    public List<Option> getOptions();
    public boolean isAnswerCorrect(Answer answer);
    public void initializeFrom(RawQuestion rawQuestion);
    void initializeFrom(QuestionForm questionForm);
    public RawQuestion toRawQuestion();
}
