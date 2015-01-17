package net.yorkjr.jareau.exambank.question;

import net.yorkjr.jareau.exambank.question.raw.RawAnswers;
import net.yorkjr.jareau.exambank.question.raw.RawOption;
import net.yorkjr.jareau.exambank.question.raw.RawQuestion;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SingleChoiceQuestionTest {
    private static final Logger log = Logger.getLogger(SingleChoiceQuestionTest.class);
    @Test
    public void shouldCreateFromRawQuestion() {
        String statement = "What is your name?";
        String[] options = new String[] {
                "Rick",
                "Oscar",
                "Junbo",
        };
        String answer = "Rick";

        RawQuestion rawQuestion = new RawQuestion();
        rawQuestion.setStatement(statement);
        List<RawOption> optionList = new ArrayList<RawOption>(options.length);
        for (int index = 0 ; index < options.length ; ++index) {
            optionList.add(new RawOption(index, options[index]));
        }
        rawQuestion.setOptions(optionList);
        rawQuestion.setAnswers(new ArrayList<RawAnswers>(){{add(new RawAnswers("0"));}});

        SingleChoiceQuestion question = new SingleChoiceQuestion();
        question.initializeFrom(rawQuestion);
        log.info("Single choice question: " + question);
        Assert.assertEquals(statement, question.getStatement());
        Assert.assertEquals(new HashSet<String>(Arrays.asList(options)), question.getOptions());
        Assert.assertTrue(question.isAnswerCorrect(new SingleChoiceAnswer("Rick")));
        Assert.assertFalse(question.isAnswerCorrect(new SingleChoiceAnswer("Oscar")));
    }
}
