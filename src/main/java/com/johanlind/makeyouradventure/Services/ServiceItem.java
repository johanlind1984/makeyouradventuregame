package com.johanlind.makeyouradventure.Services;

import com.johanlind.makeyouradventure.Entity.ItemContainer;
import com.johanlind.makeyouradventure.Repositories.ItemContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceItem {

    @Autowired
    private ItemContainerRepository itemContainerRepository;

    public List<ItemContainer> getAllitems() {
        return itemContainerRepository.findAll();
    }
}
