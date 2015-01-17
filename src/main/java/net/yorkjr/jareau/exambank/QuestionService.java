package net.yorkjr.jareau.exambank;

import net.yorkjr.jareau.exambank.question.Question;

public interface QuestionService {
    public Question getQuestionFromId(long questionId);
    public long createQuestion(Question question);
}
