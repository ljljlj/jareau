package net.yorkjr.jareau.exambank;

import net.yorkjr.jareau.exambank.dao.QuestionDataAccessor;
import net.yorkjr.jareau.exambank.dao.QuestionEntity;
import net.yorkjr.jareau.exambank.question.Question;
import net.yorkjr.jareau.exambank.question.QuestionFactory;
import net.yorkjr.jareau.exambank.question.raw.RawQuestion;
import net.yorkjr.jareau.exambank.question.raw.RawQuestionConverter;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionServiceImpl implements QuestionService {
    private QuestionDataAccessor dataAccessor;

    @Autowired
    public QuestionServiceImpl(QuestionDataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    @Override
    public Question getQuestionFromId(long questionId) {
        String questionJson = dataAccessor.getQuestionJson(questionId);
        RawQuestion rawQuestion = new RawQuestionConverter().reverse().convert(questionJson);
        return new QuestionFactory().from(rawQuestion);
    }

    @Override
    public long createQuestion(Question question) {
        RawQuestion rawQuestion = question.toRawQuestion();
        String questionJson = new RawQuestionConverter().convert(rawQuestion);
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuestionJson(questionJson);
        dataAccessor.createQuestion(questionEntity);
        return questionEntity.getQuestionId();
    }
}
