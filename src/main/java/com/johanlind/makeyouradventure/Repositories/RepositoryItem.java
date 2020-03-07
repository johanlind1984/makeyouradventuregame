package com.johanlind.makeyouradventure.Repositories;

import com.johanlind.makeyouradventure.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface RepositoryItem extends JpaRepository<Item, Integer> {
}
