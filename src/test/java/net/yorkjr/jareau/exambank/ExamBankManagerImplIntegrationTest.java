package net.yorkjr.jareau.exambank;

import net.yorkjr.jareau.exambank.question.Question;
import net.yorkjr.jareau.exambank.question.SingleChoiceQuestion;
import net.yorkjr.jareau.test.AbstractTestCase;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;
import java.util.Set;

public class ExamBankManagerImplIntegrationTest extends AbstractTestCase {
    @Autowired
    private ExamBankManager examBankManager;
    @Autowired
    private QuestionServiceImpl questionService;

    @Test
    public void createExamBank() {
        long examBankId = examBankManager.createExamBank("Bank 1", "A Test Exam Bank");
        log.info("Created Exam Bank with ID: " + examBankId);
    }

    @Test
    public void linkQuestionsToExamBank() {
        ExamBank examBank = examBankManager.getExamBank(1);
        Question question1 = questionService.getQuestionFromId(1);
        Question question2 = questionService.getQuestionFromId(3);

        try {
            examBankManager.addQuestionToExamBank(question1, examBank);
            examBankManager.addQuestionToExamBank(question2, examBank);
        } catch (DuplicateKeyException exception)  {
            log.warn("The questions may have added already ...");
        }
        examBank = examBankManager.getExamBank(1);
        List<Question> questions = examBank.getQuestionList();
        log.info("Exam Bank: " + ToStringBuilder.reflectionToString(examBank));
        Assert.assertTrue(questions.size() >= 2);
        Assert.assertEquals(question1.getStatement(), questions.get(0).getStatement());
        Assert.assertEquals(question2.getStatement(), questions.get(1).getStatement());
    }

}
