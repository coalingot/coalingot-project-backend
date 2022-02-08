package se.project.coalingot.auctionuser.dao;

import se.project.coalingot.auctionuser.entity.AuctionUser;

public interface AuctionUserDao {
    void submitPrice(Long auctionId,Long userId,Double price);
    AuctionUser getAuctionUser(Long auctionUserID);
}
