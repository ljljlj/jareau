package net.yorkjr.jareau.controller;

import net.yorkjr.jareau.exambank.*;
import net.yorkjr.jareau.exambank.question.Question;
import net.yorkjr.jareau.exambank.question.QuestionFactory;
import net.yorkjr.jareau.exambank.question.raw.RawQuestion;
import net.yorkjr.jareau.exambank.question.raw.RawQuestionConverter;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.InputStream;
@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(method = RequestMethod.GET)
    public String getDefaultQuestion(ModelMap model) throws IOException {
        InputStream inputStream = QuestionController.class.getResourceAsStream("/exambank/QuestionSample1.json");
        String questionJson = IOUtils.toString(inputStream);
        RawQuestion rawQuestion = new RawQuestionConverter().reverse().convert(questionJson);
        Question question = new QuestionFactory().from(rawQuestion);
        model.addAttribute("statement", question.getStatement());
        model.addAttribute("question", question);
        return "question/question";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String printNumber(@PathVariable int id, ModelMap model) {
        Question question = questionService.getQuestionFromId(id);
        model.addAttribute("question", question);
        return "question/question";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewQuestion(ModelMap model) {
        return "question/new";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addQuestion(@ModelAttribute("question") Question question, BindingResult result) {
        if (result.hasErrors()) {
            return "question/new";
        }
        long questionId = questionService.createQuestion(question);
        return "redirect:/question/" + questionId;
    }
}
