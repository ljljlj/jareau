package net.yorkjr.jareau.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionForm {
    private String statement;
    private String type;
    private Map<Integer, OptionForm> optionMap;

     public static class OptionForm {
        private Boolean isAnswer = false;
        private String description;

        public Boolean getIsAnswer() {
            return isAnswer;
        }

        public void setIsAnswer(Boolean isAnswer) {
            this.isAnswer = isAnswer;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<Integer, OptionForm> getOptionMap() {
        return optionMap;
    }

    public void setOptionMap(Map<Integer, OptionForm> optionMap) {
        this.optionMap = optionMap;
    }
}
