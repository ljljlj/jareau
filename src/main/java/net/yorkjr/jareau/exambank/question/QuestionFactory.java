package net.yorkjr.jareau.exambank.question;

import net.yorkjr.jareau.exambank.question.raw.RawQuestion;

import java.util.HashMap;
import java.util.Map;

public class QuestionFactory {
    private static final Map<String, Class<? extends Question>> typeToQuestionClassMap = new HashMap<String, Class<? extends Question>>();
    static {
        typeToQuestionClassMap.put("single", SingleChoiceQuestion.class);
    }

    public Question from(RawQuestion rawQuestion) {
        try {
            Class<? extends Question> questionClass = typeToQuestionClassMap.get(rawQuestion.getType());
            Question question = questionClass.newInstance();
            question.initializeFrom(rawQuestion);
            return question;
        } catch (Exception e) {
            throw new QuestionFactoryException("Failed to create Question from raw question: " + rawQuestion, e);
        }
    }
}
