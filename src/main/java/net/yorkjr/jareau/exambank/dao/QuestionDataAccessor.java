package net.yorkjr.jareau.exambank.dao;

public interface QuestionDataAccessor {
    public String getQuestionJson(long questionId);
    public long createQuestion(QuestionEntity questionEntity);
}
