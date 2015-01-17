package net.yorkjr.jareau.exambank;

import net.yorkjr.jareau.exambank.question.Question;
import net.yorkjr.jareau.exambank.question.QuestionFactory;
import net.yorkjr.jareau.exambank.question.SingleChoiceQuestion;
import net.yorkjr.jareau.exambank.question.raw.RawAnswers;
import net.yorkjr.jareau.exambank.question.raw.RawOption;
import net.yorkjr.jareau.exambank.question.raw.RawQuestion;
import net.yorkjr.jareau.exambank.question.raw.RawQuestionConverter;
import net.yorkjr.jareau.test.AbstractTestCase;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class QuestionServiceImplIntegrationTest extends AbstractTestCase {
    private static final Logger log = Logger.getLogger(QuestionServiceImplIntegrationTest.class);

    @Autowired
    private QuestionServiceImpl questionService;

    @Test
    public void shouldGetSingleChoiceQuestionFromDatabase() {
        long questionId = 1;
        Question question = questionService.getQuestionFromId(questionId);
        Assert.assertTrue(question instanceof SingleChoiceQuestion);
        log.info("Loaded question: " + ToStringBuilder.reflectionToString(question));
    }

    @Test
    @Ignore("Create once only for test")
    public void createQuestionFromSampleJson() throws IOException {
        InputStream inputStream = QuestionServiceImplIntegrationTest.class.getResourceAsStream("/exambank/SingleQuestionSample1.json");
        String questionJson = IOUtils.toString(inputStream);
        RawQuestion rawQuestion = new RawQuestionConverter().reverse().convert(questionJson);
        Question question = new QuestionFactory().from(rawQuestion);
        long rowId = questionService.createQuestion(question);
        log.info("Row ID: " + rowId);
    }

    @Test
    @Ignore("Create once only for test")
    public void createQuestion() throws IOException {
        RawQuestion rawQuestion = new RawQuestion();
        rawQuestion.setStatement("When is Christmas?");
        List<RawOption> options = new LinkedList<RawOption>();
        options.add(new RawOption(0, "10/14"));
        options.add(new RawOption(1, "2/14"));
        options.add(new RawOption(2, "12/25"));
        options.add(new RawOption(3, "10/10"));
        rawQuestion.setOptions(options);
        rawQuestion.setAnswers(Collections.singletonList(new RawAnswers("2")));
        rawQuestion.setType("single");
        Question question = new QuestionFactory().from(rawQuestion);
        long rowId = questionService.createQuestion(question);
        log.info("Row ID: " + rowId);
    }
}
