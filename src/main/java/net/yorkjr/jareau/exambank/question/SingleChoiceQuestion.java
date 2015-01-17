package net.yorkjr.jareau.exambank.question;

import net.yorkjr.jareau.exambank.question.raw.RawAnswers;
import net.yorkjr.jareau.exambank.question.raw.RawOption;
import net.yorkjr.jareau.exambank.question.raw.RawQuestion;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleChoiceQuestion implements Question {
    private String statement;
    private List<Option> options;
    private Answer correctAnswer;
    private long questionId;

    @Override
    public long getQuestionId() {
        return questionId;
    }

    @Override
    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    @Override
    public void initializeFrom(RawQuestion rawQuestion) {
        rawQuestion = validateRawQuestion(rawQuestion);
        statement = rawQuestion.getStatement();
        List<RawOption> rawOptions = rawQuestion.getOptions();
        List<Option> options = new ArrayList<Option>(rawOptions.size());
        int answerId = Integer.valueOf(rawQuestion.getAnswers().get(0).getValue()).intValue();
        for (RawOption option : rawOptions) {
            boolean isAnswer = false;
            if (answerId == option.getId()) {
                isAnswer = true;
                correctAnswer = new SingleChoiceAnswer(option.getValue());
            }
            options.add(new SingleChoiceOption(isAnswer, option.getValue()));
        }
        this.options = options;
    }

    @Override
    public RawQuestion toRawQuestion() {
        RawQuestion rawQuestion = new RawQuestion();
        rawQuestion.setStatement(statement);
        rawQuestion.setType("single");
        List<RawOption> optionList = new ArrayList<RawOption>(options.size());
        for (int index = 0 ; index < options.size() ; ++index) {
            Option option = options.get(index);
            if (option.isAnswer()) {
                rawQuestion.setAnswers(Collections.singletonList(new RawAnswers(String.valueOf(index))));
            }
            optionList.add(new RawOption(index, option.getDescription()));
        }
        rawQuestion.setOptions(optionList);
        return rawQuestion;
    }

    private RawQuestion validateRawQuestion(RawQuestion rawQuestion) {
        Validate.notNull(rawQuestion);
        Validate.notEmpty(rawQuestion.getStatement());
        Validate.notEmpty(rawQuestion.getAnswers());
        Validate.isTrue(rawQuestion.getAnswers().size() == 1);
        Validate.isTrue(rawQuestion.getOptions().size() > 1);
        return rawQuestion;
    }

    @Override
    public String getStatement() {
        return statement;
    }

    @Override
    public List<Option> getOptions() {
        return options;
    }

    @Override
    public boolean isAnswerCorrect(Answer answer) {
        if (correctAnswer.equals(answer)) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
