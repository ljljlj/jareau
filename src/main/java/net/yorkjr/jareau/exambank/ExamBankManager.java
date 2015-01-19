package net.yorkjr.jareau.exambank;

import net.yorkjr.jareau.exambank.question.Question;

import java.util.List;
import java.util.Set;

public interface ExamBankManager {
    public ExamBank getExamBank(long examBankId);
    public void addQuestionToExamBank(Question question, ExamBank examBank);
    public void removeQuestionFromExamBank(Question question, ExamBank examBank);
    public long createExamBank(String name, String description);
}
