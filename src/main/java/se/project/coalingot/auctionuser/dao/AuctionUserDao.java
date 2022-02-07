package se.project.coalingot.auctionuser.dao;

public interface AuctionUserDao {
    void submitPrice(Long auctionId,Long userId,Double price);
    void seeAuctionItemDetails(Long itemId);
}
