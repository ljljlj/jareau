package net.yorkjr.jareau.exambank.question;

import net.yorkjr.jareau.exambank.question.raw.RawQuestion;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class QuestionFactoryTest {
    private static final Logger log = Logger.getLogger(QuestionFactoryTest.class);
    @Test
    public void getSingleChoiceQuestionFromRawQuestion() {
        RawQuestion rawQuestion = new RawQuestion();
        rawQuestion.setType("single");
        rawQuestion.setStatement("What is your name?");
        Question singleChoiceQuestion = new QuestionFactory().from(rawQuestion);
        log.info("Single choice question: " + singleChoiceQuestion);
        Assert.assertTrue(singleChoiceQuestion instanceof SingleChoiceQuestion);
    }
}
