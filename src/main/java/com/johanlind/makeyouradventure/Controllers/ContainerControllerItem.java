package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.ItemContainer;
import com.johanlind.makeyouradventure.Repositories.ItemContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/itemcontainer")
public class ContainerControllerItem {

    @Autowired
    private ItemContainerRepository itemContainerRepository;
    private List<ItemContainer> itemContainerList;
    private ItemContainer itemContainer;

    @RequestMapping(value="/instantiateitemcontainers")
    public String instantiate() {
        itemContainerList = itemContainerRepository.findAll();
        return "index";


    }

    public List<ItemContainer> getAllItems() {
        return itemContainerList;
    }

}
