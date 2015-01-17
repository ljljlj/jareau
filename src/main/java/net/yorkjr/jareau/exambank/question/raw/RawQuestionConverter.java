package net.yorkjr.jareau.exambank.question.raw;

import com.google.common.base.Converter;
import com.google.gson.Gson;

public class RawQuestionConverter extends Converter<RawQuestion, String> {
    @Override
    protected String doForward(RawQuestion rawQuestion) {
        String questionJson = new Gson().toJson(rawQuestion);
        return questionJson;
    }

    @Override
    protected RawQuestion doBackward(String jsonString) {
        return new Gson().fromJson(jsonString, RawQuestion.class);
    }
}
