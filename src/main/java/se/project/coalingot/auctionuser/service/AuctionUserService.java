package se.project.coalingot.auctionuser.service;

public interface AuctionUserService {
    void submitPrice(Long auctionId,Long userId,Double price);
}
