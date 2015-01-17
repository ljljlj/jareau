package net.yorkjr.jareau.exambank;

import net.yorkjr.jareau.exambank.question.Question;

import java.util.List;

public class ExamBank {
    private long examBankId;
    private String name;
    private String description;
    private List<Question> questionList;

    public long getExamBankId() {
        return examBankId;
    }

    public void setExamBankId(long examBankId) {
        this.examBankId = examBankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
