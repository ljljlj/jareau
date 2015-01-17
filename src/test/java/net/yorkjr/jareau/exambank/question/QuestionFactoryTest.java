package net.yorkjr.jareau.exambank.question;

import net.yorkjr.jareau.exambank.question.raw.RawAnswers;
import net.yorkjr.jareau.exambank.question.raw.RawOption;
import net.yorkjr.jareau.exambank.question.raw.RawQuestion;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class QuestionFactoryTest {
    private static final Logger log = Logger.getLogger(QuestionFactoryTest.class);
    @Test
    public void getSingleChoiceQuestionFromRawQuestion() {
        RawQuestion rawQuestion = new RawQuestion();
        rawQuestion.setType("single");
        rawQuestion.setStatement("What is your name?");
        rawQuestion.setAnswers(Collections.singletonList(new RawAnswers("0")));
        List<RawOption> options = new LinkedList<RawOption>();
        options.add(new RawOption(0, "Correct!"));
        options.add(new RawOption(1, "Wrong!"));
        rawQuestion.setOptions(options);
        Question singleChoiceQuestion = new QuestionFactory().from(rawQuestion);
        log.info("Single choice question: " + singleChoiceQuestion);
        Assert.assertTrue(singleChoiceQuestion instanceof SingleChoiceQuestion);
    }
}
