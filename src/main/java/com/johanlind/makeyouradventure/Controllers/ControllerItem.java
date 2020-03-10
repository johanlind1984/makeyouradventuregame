package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.ItemContainer;
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

    List<ItemContainer> itemContainerList = new ArrayList<>();

    public List<ItemContainer> getAllItems() {
        return itemContainerList;
    }

    public void listAllitems() {
        for (ItemContainer itemContainer : itemContainerList) {
            System.out.println(itemContainer.getItemID());
            System.out.println(itemContainer.getDescription());
            System.out.println("================================");
            System.out.println("");
        }
    }


}
