package net.yorkjr.jareau.exambank.dao;

public interface QuestionDataAccessor {
    public QuestionEntity getQuestionJson(long questionId);
    public long createQuestion(QuestionEntity questionEntity);
}
