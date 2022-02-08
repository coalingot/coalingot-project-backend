package se.project.coalingot.auctionuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.project.coalingot.auctionuser.dao.AuctionUserDao;
import se.project.coalingot.auctionuser.entity.AuctionUser;

@Service
public class AuctionUserServiceImpl implements AuctionUserService{
    @Autowired
    AuctionUserDao auctionUserDao;

    @Override
    public void submitPrice(Long auctionId,Long userId, Double price) {
        auctionUserDao.submitPrice(auctionId,userId,price);
    }

    @Override
    public AuctionUser getAuctionUser(Long auctionUserID) {
        return auctionUserDao.getAuctionUser(auctionUserID);
    }
}
