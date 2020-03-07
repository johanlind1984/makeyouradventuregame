package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.Item;
import com.johanlind.makeyouradventure.Repositories.RepositoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
@RequestMapping("/item")
public class ControllerItem {

    @Autowired
    RepositoryItem repositoryItem;

    List<Item> itemList = new ArrayList<>();

    public List<Item> getAllItems() {
        return itemList;
    }

    public void listAllitems() {
        for (Item item : itemList) {
            System.out.println(item.getItemID());
            System.out.println(item.getDescription());
            System.out.println("================================");
            System.out.println("");
        }
    }
}
