package com.johanlind.makeyouradventure.Repositories;

import com.johanlind.makeyouradventure.Entity.Item;
import com.johanlind.makeyouradventure.Entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryStory extends JpaRepository<Story, Integer> {
}
