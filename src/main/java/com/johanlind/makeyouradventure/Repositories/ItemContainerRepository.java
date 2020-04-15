package com.johanlind.makeyouradventure.Repositories;

import com.johanlind.makeyouradventure.Entity.ItemContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemContainerRepository extends JpaRepository<ItemContainer, Integer> {
}
