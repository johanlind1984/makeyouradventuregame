package com.johanlind.makeyouradventure.DataAccessObjects;

import com.johanlind.makeyouradventure.Entity.Level;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOLevel {
    List<Level> levelList;
}
