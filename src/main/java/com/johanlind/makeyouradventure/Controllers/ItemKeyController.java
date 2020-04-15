package com.johanlind.makeyouradventure.Controllers;

import com.johanlind.makeyouradventure.Entity.ItemKey;
import com.johanlind.makeyouradventure.Repositories.ItemKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/itemkey")
public class ItemKeyController {

    @Autowired
    private ItemKeyRepository itemKeyRepository;
    private List<ItemKey> itemKeyList;
    private ItemKey itemKey;

    @RequestMapping(value="/instantiateitemkey")
    public String instantiate() {
        itemKeyList = itemKeyRepository.findAll();
        return "index";
    }

    @RequestMapping(value="/saveitemkey")
    public String save(ItemKey itemKey) {
        itemKeyRepository.save(itemKey);
        return "index";
    }

    public ItemKey getItemKeyById(int itemKeyId){
        ItemKey itemKey = itemKeyRepository.getOne(4);
        System.out.println(itemKey.getItemKeyName());
        return itemKey;
    }

    public List<ItemKey> getAllItems() {
        return itemKeyList;
    }

}
