package se.project.coalingot.item.dao;

import se.project.coalingot.item.entity.Item;
import se.project.coalingot.item.entity.ItemRequest;

import java.util.List;

public interface ItemDao {
    List<Item> getAllItem();
    Item postItem(ItemRequest itemRequest);
    Item itemDetail(Long id);
    Item endAuction(Long id);
}
