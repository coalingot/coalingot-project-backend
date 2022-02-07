package se.project.coalingot.auctionuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.project.coalingot.auctionuser.dao.AuctionUserDao;

@Service
public class AuctionUserServiceImpl implements AuctionUserService{
    @Autowired
    AuctionUserDao auctionUserDao;

    @Override
    public void submitPrice(Long userId, Long itemId, Double price) {
        auctionUserDao.submitPrice(userId,itemId,price);
    }
}
