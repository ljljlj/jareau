package net.yorkjr.jareau.controller;

import net.yorkjr.jareau.exambank.ExamBank;
import net.yorkjr.jareau.exambank.ExamBankManager;
import net.yorkjr.jareau.exambank.QuestionService;
import net.yorkjr.jareau.exambank.question.Question;
import net.yorkjr.jareau.exambank.question.QuestionFactory;
import net.yorkjr.jareau.exambank.question.QuestionType;
import net.yorkjr.jareau.exambank.question.raw.RawQuestion;
import net.yorkjr.jareau.exambank.question.raw.RawQuestionConverter;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;
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
@RequestMapping("/exambank")
public class ExamBankController {
    private static final Logger log = Logger.getLogger(ExamBankController.class);
    @Autowired
    private ExamBankManager examBankManager;
    @Autowired
    private QuestionService questionService;

    @RequestMapping(method = RequestMethod.GET)
    public String getExamBankList(ModelMap model) throws IOException {
        return "exambank/exambank";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String printNumber(@PathVariable int id, ModelMap model) {
        ExamBank examBank = examBankManager.getExamBank(id);
        model.addAttribute("examBank", examBank);
        return "exambank/exambank";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewExamBank(ModelMap model) {
        return "exambank/new";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addExamBank(@ModelAttribute("exambank") ExamBank examBank, BindingResult result) {
        if (result.hasErrors()) {
            return "exambank/new";
        }
        long examBankId = examBankManager.createExamBank(examBank.getName(), examBank.getDescription());
        return "redirect:/exambank/" + examBankId;
    }

    @RequestMapping(value="/{examBankId}/question/new", method = RequestMethod.GET)
    public String getNewQuestionForExamBank(@PathVariable long examBankId, ModelMap model) {
        ExamBank examBank = examBankManager.getExamBank(examBankId);
        model.addAttribute("examBank", examBank);
        model.addAttribute("questionTypes", QuestionType.values());
        return "exambank/question/new";
    }

    @RequestMapping(value="/{examBankId}/question/add", method = RequestMethod.POST)
    public String createQuestionForExamBank(@PathVariable long examBankId, @ModelAttribute("question") QuestionForm questionForm, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/exambank/" + examBankId + "/question/new";
        }

        Question question = new QuestionFactory().from(questionForm);
        long questionId = questionService.createQuestion(question);
        question = questionService.getQuestionFromId(questionId);
        ExamBank examBank = examBankManager.getExamBank(examBankId);
        examBankManager.addQuestionToExamBank(question, examBank);
        log.info(String.format("Question %s for exam bank %s saved", question, examBank));
        return "redirect:/exambank/" + examBankId;
    }

    @RequestMapping(value="/{examBankId}/question/{questionId}/remove")
    public String removeQuestionFromExamBank(@PathVariable("examBankId") long examBankId,
                                             @PathVariable("questionId") long questionId, ModelMap model) {
        ExamBank examBank = examBankManager.getExamBank(examBankId);
        Question question = questionService.getQuestionFromId(questionId);
        examBankManager.removeQuestionFromExamBank(question, examBank);
        return "redirect:/exambank/" + examBankId;
    }
}
