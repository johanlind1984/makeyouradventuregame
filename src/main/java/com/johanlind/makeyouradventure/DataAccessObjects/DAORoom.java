package com.johanlind.makeyouradventure.DataAccessObjects;

import com.johanlind.makeyouradventure.Entity.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAORoom {
    List<Room> roomList;
}
