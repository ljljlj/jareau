package net.yorkjr.jareau.exambank.question.raw;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class RawQuestionConverterTest {
    private static final Logger log = Logger.getLogger(RawQuestionConverterTest.class);
    @Test
    public void transformJsonToRawQuestion() throws IOException {
        InputStream inputStream = RawQuestionConverterTest.class.getResourceAsStream("/exambank/SingleQuestionSample1.json");
        String jsonString = IOUtils.toString(inputStream);
        RawQuestion rawQuestion = new RawQuestionConverter().reverse().convert(jsonString);
        log.info("raw question: " + ToStringBuilder.reflectionToString(rawQuestion));
        for (RawOption option : rawQuestion.getOptions()) {
            log.info("option: " + ToStringBuilder.reflectionToString(option));
        }
        for (RawAnswers answer : rawQuestion.getAnswers()) {
            log.info("answer: " + ToStringBuilder.reflectionToString(answer));
        }
        Assert.assertEquals("What is your name?", rawQuestion.getStatement());
        Assert.assertEquals("single", rawQuestion.getType());
        Assert.assertEquals(0, rawQuestion.getOptions().get(0).getId());
        Assert.assertEquals("Rick", rawQuestion.getOptions().get(0).getValue());
        Assert.assertEquals(1, rawQuestion.getOptions().get(1).getId());
        Assert.assertEquals("Oscar", rawQuestion.getOptions().get(1).getValue());
        Assert.assertEquals(2, rawQuestion.getOptions().get(2).getId());
        Assert.assertEquals("Junbo", rawQuestion.getOptions().get(2).getValue());
        Assert.assertEquals("0", rawQuestion.getAnswers().get(0).getValue());
    }
}
