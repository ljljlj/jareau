package net.yorkjr.jareau.exambank.question;

import net.yorkjr.jareau.controller.QuestionForm;
import net.yorkjr.jareau.exambank.question.raw.RawAnswers;
import net.yorkjr.jareau.exambank.question.raw.RawOption;
import net.yorkjr.jareau.exambank.question.raw.RawQuestion;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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
        Assert.assertThat(question.getOptions(), new IsEqualToArray(options));
        Assert.assertFalse(question.isAnswerCorrect(new SingleChoiceAnswer("Oscar")));
    }

    @Test
    public void shouldCreateFromQuestionForm() {
        String statement = "What is your name?";
        String[] options = new String[] {
                "Rick",
                "Oscar",
                "Junbo",
        };
        String answer = "Rick";
        QuestionForm questionForm = new QuestionForm();
        questionForm.setStatement(statement);
        questionForm.setType("single");
        Map<Integer,QuestionForm.OptionForm> optionMap = new HashMap<Integer, QuestionForm.OptionForm>();
        for (int index = 0 ; index < options.length ; ++index) {
            QuestionForm.OptionForm optionForm = new QuestionForm.OptionForm();
            optionForm.setDescription(options[index]);
            optionForm.setIsAnswer(false);
            if (answer.equals(options[index])) {
                optionForm.setIsAnswer(true);
            }
            optionMap.put(index, optionForm);
        }
        questionForm.setOptionMap(optionMap);

        SingleChoiceQuestion question = new SingleChoiceQuestion();
        question.initializeFrom(questionForm);
        log.info("Single choice question from QuestionForm: " + question);
        Assert.assertEquals(statement, question.getStatement());
        Assert.assertThat(question.getOptions(), new IsEqualToArray(options));
        Assert.assertTrue(question.isAnswerCorrect(new SingleChoiceAnswer("Rick")));
        Assert.assertFalse(question.isAnswerCorrect(new SingleChoiceAnswer("Oscar")));
    }

    class IsEqualToArray extends BaseMatcher {
        private String[] options;
        public IsEqualToArray(String[] options) {
            this.options = options;
        }

        @Override
        public boolean matches(Object o) {
            Collection<Option> optionsToCheck = (Collection<Option>) o;
            if (options.length != optionsToCheck.size()) {
                return false;
            }
            LinkedList<String> optionListToCheck = new LinkedList<String>();
            for (Option option : optionsToCheck) {
                optionListToCheck.add(option.getDescription());
            }
            HashSet<String> expectedOptions = new HashSet<String>(Arrays.asList(options));
            return expectedOptions.containsAll(optionListToCheck);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText(ToStringBuilder.reflectionToString(options));
        }
    }
}
