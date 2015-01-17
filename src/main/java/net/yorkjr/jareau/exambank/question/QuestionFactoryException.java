package net.yorkjr.jareau.exambank.question;

public class QuestionFactoryException extends RuntimeException {
    public QuestionFactoryException(String log, Throwable t) {
        super(log, t);
    }

    public QuestionFactoryException(String log) {
        super(log);
    }

    public QuestionFactoryException(Throwable t) {
        super(t);
    }
}
