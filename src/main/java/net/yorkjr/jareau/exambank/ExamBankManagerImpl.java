package net.yorkjr.jareau.exambank;

import net.yorkjr.jareau.exambank.dao.ExamBankDataAccessor;
import net.yorkjr.jareau.exambank.dao.ExamBankEntity;
import net.yorkjr.jareau.exambank.dao.QuestionEntity;
import net.yorkjr.jareau.exambank.question.Question;
import net.yorkjr.jareau.exambank.question.QuestionFactory;
import net.yorkjr.jareau.exambank.question.raw.RawQuestionConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExamBankManagerImpl implements ExamBankManager {
    private ExamBankDataAccessor dataAccessor;

    @Autowired
    public ExamBankManagerImpl(ExamBankDataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    @Override
    public ExamBank getExamBank(long examBankId) {
        ExamBankEntity examBankEntity = dataAccessor.getExamBank(examBankId);
        ExamBank examBank = new ExamBank();
        examBank.setExamBankId(examBankEntity.getExamBankId());
        examBank.setName(examBankEntity.getName());
        examBank.setDescription(examBankEntity.getDescription());
        examBank.setQuestionList(getQuestionListForExamBankId(examBankId));
        return examBank;
    }

    private List<Question> getQuestionListForExamBankId(long examBankId) {
        List<QuestionEntity> questions = dataAccessor.getQuestionsOfExamBankId(examBankId);
        List<Question> questionList = new ArrayList<Question>(questions.size());
        for (QuestionEntity questionEntity : questions) {
            Question question = new QuestionFactory().from(new RawQuestionConverter().reverse().convert(questionEntity.getQuestionJson()));
            question.setQuestionId(questionEntity.getQuestionId());
            questionList.add(question);
        }
        return questionList;
    }

    @Override
    public void addQuestionToExamBank(Question question, ExamBank examBank) {
        dataAccessor.addQuestionIdToExamBankId(question.getQuestionId(), examBank.getExamBankId());
    }

    @Override
    public long createExamBank(String name, String description) {
        ExamBankEntity examBank = new ExamBankEntity();
        examBank.setName(name);
        examBank.setDescription(description);
        dataAccessor.createExamBank(examBank);
        return examBank.getExamBankId();
    }
}
