package se.project.coalingot.auctionuser.service;

import se.project.coalingot.auctionuser.entity.AuctionUser;

public interface AuctionUserService {
    void submitPrice(Long auctionId,Long userId,Double price);
    AuctionUser getAuctionUser(Long auctionUserID);
}
