package com.johanlind.makeyouradventure.Repositories;

import com.johanlind.makeyouradventure.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
