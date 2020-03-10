package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.Alternatives;
import com.johanlind.makeyouradventure.Entity.Question;
import com.johanlind.makeyouradventure.Repositories.RepositoryAlternatives;
import com.johanlind.makeyouradventure.Repositories.RepositoryQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/question")
public class ControllerQuestion {

    @Autowired
    private RepositoryQuestion repositoryQuestion;
    @Autowired
    private RepositoryAlternatives repositoryAlternatives;

    private List<Question> questionList;
    private List<Alternatives> alternativesList;
    private Question question;
    private Alternatives alternatives;

    @RequestMapping(value="/instantiatequestions")
    public String instantiate() {
        questionList = repositoryQuestion.findAll();
        return "index";
    }
}
