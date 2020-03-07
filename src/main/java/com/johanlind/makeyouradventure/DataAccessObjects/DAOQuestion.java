package com.johanlind.makeyouradventure.DataAccessObjects;

import com.johanlind.makeyouradventure.Entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOQuestion {
    List<Question> questionList;
}
