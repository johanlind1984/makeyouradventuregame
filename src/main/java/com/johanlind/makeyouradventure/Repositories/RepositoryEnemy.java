package com.johanlind.makeyouradventure.Repositories;

import com.johanlind.makeyouradventure.Entity.Enemy;
import com.johanlind.makeyouradventure.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEnemy extends JpaRepository<Enemy, Integer> {
}
