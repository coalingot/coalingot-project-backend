package se.project.coalingot.auctionuser.dao;

public interface AuctionUserDao {
    void submitPrice(Long userId,Long itemId,Double price);
}
