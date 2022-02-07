package se.project.coalingot.auctionuser.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.project.coalingot.auction.entity.Auction;
import se.project.coalingot.auction.entity.AuctionHistory;
import se.project.coalingot.auction.repository.AuctionHistoryRepository;
import se.project.coalingot.auction.repository.AuctionRepository;
import se.project.coalingot.auctionuser.entity.AuctionUser;
import se.project.coalingot.auctionuser.repository.AuctionUserRepository;
import se.project.coalingot.item.entity.Item;
import se.project.coalingot.item.service.ItemService;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository
public class AuctionUserDaoImpl implements AuctionUserDao{
    @Autowired
    ItemService itemService;

    @Autowired
    AuctionRepository auctionRepository;

    @Autowired
    AuctionUserRepository auctionUserRepository;

    @Autowired
    AuctionHistoryRepository auctionHistoryRepository;

    @Override
    public void submitPrice(Long auctionId,Long userId, Double price) {
        AuctionUser auctionUser = auctionUserRepository.findById(userId).orElse(null);
        Auction auction = auctionRepository.findById(auctionId).orElse(null);

        auctionHistoryRepository.save(
                AuctionHistory.builder()
                        .auctionEvent(auction)
                        .auctionUser(auctionUser)
                        .submitPrice(price)
                        .submitAt(Timestamp.valueOf(LocalDateTime.now()))
                        .build()
        );

    }

    @Override
    public void seeAuctionItemDetails(Long itemId) {

    }
}
