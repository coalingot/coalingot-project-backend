package se.project.coalingot.item.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.project.coalingot.item.entity.Item;
import se.project.coalingot.item.entity.ItemRequest;
import se.project.coalingot.item.repository.ItemRepository;

import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public Item postItem(ItemRequest itemRequest) {
        return itemRepository.save(
                Item.builder()
                        .itemImage(itemRequest.getItemImage())
                        .itemName(itemRequest.getItemName())
                        .itemDescription(itemRequest.getItemDescription())
                        .startPrice(itemRequest.getStartPrice())
                        .endDate(itemRequest.getEndDate())
                        .build()
        );
    }

    @Override
    public Item itemDetail(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}
