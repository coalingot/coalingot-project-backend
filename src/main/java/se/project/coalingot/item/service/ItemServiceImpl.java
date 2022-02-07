package se.project.coalingot.item.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.project.coalingot.item.dao.ItemDao;
import se.project.coalingot.item.entity.Item;
import se.project.coalingot.item.entity.ItemRequest;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemDao itemDao;

    @Override
    public List<Item> getAllItem() {
        return itemDao.getAllItem();
    }

    @Override
    public Item postItem(ItemRequest itemRequest) {
        return itemDao.postItem(itemRequest);
    }

    @Override
    public Item itemDetail(Long id) {
        return itemDao.itemDetail(id);
    }
}
