package net.yorkjr.jareau.exambank.dao;

public class ExamBankEntity {
    private long examBankId;
    private String name;
    private String description;

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
}
