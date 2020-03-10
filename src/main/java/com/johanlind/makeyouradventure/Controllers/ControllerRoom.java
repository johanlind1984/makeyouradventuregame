package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.Room;
import com.johanlind.makeyouradventure.Repositories.RepositoryRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/room")
public class ControllerRoom {

    @Autowired
    private RepositoryRoom repositoryRoom;
    private List<Room> roomList;
    private Room room;

    @RequestMapping(value="/instantiaterooms")
    public String instantiate() {
        roomList = repositoryRoom.findAll();
        return "index";
    }
}
