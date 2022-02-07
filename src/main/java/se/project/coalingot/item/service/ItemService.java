package se.project.coalingot.item.service;

import se.project.coalingot.item.entity.Item;
import se.project.coalingot.item.entity.ItemRequest;

import java.util.List;

public interface ItemService {
    List<Item> getAllItem();
    Item postItem(ItemRequest itemRequest);
    Item itemDetail(Long id);
}
