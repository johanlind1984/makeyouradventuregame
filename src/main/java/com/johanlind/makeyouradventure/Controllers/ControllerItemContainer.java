package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.ItemContainer;
import com.johanlind.makeyouradventure.Repositories.RepositoryItemContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/itemcontainer")
public class ControllerItemContainer {

    @Autowired
    private RepositoryItemContainer repositoryItemContainer;
    private List<ItemContainer> itemContainerList;
    private ItemContainer itemContainer;

    @RequestMapping(value="/instantiateitemcontainers")
    public String instantiate() {
        itemContainerList = repositoryItemContainer.findAll();
        return "index";
    }

    public List<ItemContainer> getAllItems() {
        return itemContainerList;
    }

}
