package com.johanlind.makeyouradventure.DataAccessObjects;

import com.johanlind.makeyouradventure.Entity.Item;
import com.johanlind.makeyouradventure.Repositories.RepositoryItem;
import com.johanlind.makeyouradventure.Services.ServiceItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DAOItem {

    @Autowired
    private RepositoryItem repositoryItem;
    private List<Item> itemList;

    public DAOItem() {
        itemList = new ArrayList<>();
    }

    private void getAllItems() {
        itemList = repositoryItem.findAll();
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
