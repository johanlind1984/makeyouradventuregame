package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.Alternatives;
import com.johanlind.makeyouradventure.Entity.Question;
import com.johanlind.makeyouradventure.Repositories.AlternativesRepository;
import com.johanlind.makeyouradventure.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AlternativesRepository alternativesRepository;

    private List<Question> questionList;
    private List<Alternatives> alternativesList;
    private Question question;
    private Alternatives alternatives;

    @RequestMapping(value="/instantiatequestions")
    public String instantiate() {
        questionList = questionRepository.findAll();
        return "index";
    }
}
