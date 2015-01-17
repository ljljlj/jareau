package net.yorkjr.jareau.exambank.question;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SingleChoiceAnswer implements Answer {
    private final String value;

    public SingleChoiceAnswer(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof  SingleChoiceAnswer)) {
            return false;
        }
        return value.equals(((SingleChoiceAnswer) obj).value);
    }

    @Override
    public String toString() {
        return String.format("{answer: %s }", value);
    }
}
