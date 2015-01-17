package net.yorkjr.jareau.exambank.dao;

public class QuestionEntity {
    private long questionId;
    private String questionJson;

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionJson() {
        return questionJson;
    }

    public void setQuestionJson(String questionJson) {
        this.questionJson = questionJson;
    }
}
