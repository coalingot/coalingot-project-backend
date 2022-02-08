package se.project.coalingot.item.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.project.coalingot.auction.entity.Auction;
import se.project.coalingot.auction.entity.AuctionHistory;
import se.project.coalingot.auction.repository.AuctionRepository;
import se.project.coalingot.auctionuser.entity.AuctionUser;
import se.project.coalingot.item.entity.Item;
import se.project.coalingot.item.entity.ItemRequest;
import se.project.coalingot.item.repository.ItemRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    AuctionRepository auctionRepository;

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public Item postItem(ItemRequest itemRequest) {
        Item item = Item.builder()
                .itemImage(itemRequest.getItemImage())
                .itemName(itemRequest.getItemName())
                .itemDescription(itemRequest.getItemDescription())
                .build();
        itemRepository.save(item);

        Auction auction = Auction.builder()
                .auctionItem(item)
                .startDate(Timestamp.valueOf(LocalDateTime.now()))
                .endDate(itemRequest.getEndDate())
                .highestPrice(itemRequest.getStartPrice())
                .status(true)
                .build();
        auctionRepository.save(auction);

        return item;
    }

    @Override
    public Item itemDetail(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item endAuction(Long id) {
        Auction auction = auctionRepository.findById(id).orElse(null);
        List<AuctionHistory> histories = auction.getHistories();
        Item item = auction.getAuctionItem();
        AuctionUser auctionUser = histories.get(0).getAuctionUser();

        double maxPrice = histories.get(0).getSubmitPrice();
        for(int i=1;i<histories.size();i++) {
            if(histories.get(i).getSubmitPrice() > maxPrice){
                maxPrice = histories.get(i).getSubmitPrice();
                auctionUser = histories.get(i).getAuctionUser();
            }
        }
        item.setOwnBy(auctionUser);
        item.setPrice(maxPrice);

        auction.setStatus(false);
        auctionRepository.save(auction);

        return itemRepository.save(item);
    }
}
