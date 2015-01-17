package net.yorkjr.jareau.controller;

import net.yorkjr.jareau.exambank.ExamBank;
import net.yorkjr.jareau.exambank.ExamBankManager;
import net.yorkjr.jareau.exambank.QuestionService;
import net.yorkjr.jareau.exambank.question.Question;
import net.yorkjr.jareau.exambank.question.QuestionFactory;
import net.yorkjr.jareau.exambank.question.raw.RawQuestion;
import net.yorkjr.jareau.exambank.question.raw.RawQuestionConverter;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/exambank")
public class ExamBankController {
    @Autowired
    private ExamBankManager examBankManager;

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
}
