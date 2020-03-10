package com.johanlind.makeyouradventure.Repositories;

import com.johanlind.makeyouradventure.Entity.Alternatives;
import com.johanlind.makeyouradventure.Entity.ItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryItemKey extends JpaRepository<ItemKey, Integer> {
}
