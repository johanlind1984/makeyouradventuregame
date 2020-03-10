package com.johanlind.makeyouradventure.Repositories;

import com.johanlind.makeyouradventure.Entity.Alternatives;
import com.johanlind.makeyouradventure.Entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLevel extends JpaRepository<Level, Integer> {
}
