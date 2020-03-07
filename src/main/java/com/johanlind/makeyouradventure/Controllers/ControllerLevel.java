package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.DataAccessObjects.DAOItem;
import com.johanlind.makeyouradventure.Entity.Item;
import com.johanlind.makeyouradventure.Entity.Level;
import com.johanlind.makeyouradventure.Repositories.RepositoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerLevel {
    @Autowired
    private RepositoryItem repositoryItem;

    @Autowired
    private DAOItem daoItem;

    private List<Item> itemList;

    @RequestMapping(name="/")
    public String startCreateAdventure () {

        itemList = repositoryItem.findAll();

        for (Item item : itemList) {
            System.out.println(item.getDescription());
        }
        return "start-create-adventure";
    }
}