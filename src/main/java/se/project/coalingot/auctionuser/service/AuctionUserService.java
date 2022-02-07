package se.project.coalingot.auctionuser.service;

public interface AuctionUserService {
    void submitPrice(Long userId,Long itemId,Double price);
}
