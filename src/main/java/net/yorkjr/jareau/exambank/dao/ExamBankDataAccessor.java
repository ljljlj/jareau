package net.yorkjr.jareau.exambank.dao;

import java.util.List;

public interface ExamBankDataAccessor {
    public ExamBankEntity getExamBank(long examBankId);
    public List<QuestionEntity> getQuestionsOfExamBankId(long examBankId);
    public void addQuestionIdToExamBankId(long questionId, long examBankId);
    public void removeQuestionFromExamBank(long questionId, long examBankId);
    public long createExamBank(ExamBankEntity examBank);
}
