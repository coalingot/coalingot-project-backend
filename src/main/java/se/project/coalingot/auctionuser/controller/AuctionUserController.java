package se.project.coalingot.auctionuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import se.project.coalingot.auction.entity.Auction;
import se.project.coalingot.auction.entity.AuctionRequest;
import se.project.coalingot.auction.repository.AuctionRepository;
import se.project.coalingot.auctionuser.entity.AuctionUser;
import se.project.coalingot.auctionuser.service.AuctionUserService;
import se.project.coalingot.util.AuctionMapper;

import java.util.List;

@Controller
public class AuctionUserController {
    @Autowired
    AuctionUserService auctionUserService;

    // will change later
    @Autowired
    AuctionRepository auctionRepository;

    @PostMapping("/submit-price")
    public ResponseEntity<?> submitPrice(
            @RequestBody AuctionRequest auctionRequest
    ) {
        auctionUserService.submitPrice(
                auctionRequest.getAuctionId(),
                auctionRequest.getUserId(),
                auctionRequest.getSubmitPrice()
        );
        return ResponseEntity.ok("You has been submitted the price.");
    }

    @GetMapping("/see-all-auction")
    public ResponseEntity<?> seeAuction(){
        List<Auction> output = auctionRepository.findAll();
        return ResponseEntity.ok(AuctionMapper.INSTANCE.seeAuction(output));
    }
    @GetMapping("/see-all-auction/{auctionUserID}")
    public ResponseEntity<?> seeAuctionDetail(  @PathVariable("auctionUserID") Long auctionID){
        Auction output = auctionRepository.findById(auctionID).orElse(null);
        return ResponseEntity.ok(AuctionMapper.INSTANCE.seeAuction(output));
    }

    @GetMapping("auctionList/{auctionUserID}")
    public ResponseEntity<?> getAuctionThatSubmit(
            @PathVariable("auctionUserID") Long auctionID
    ) {
        AuctionUser output = auctionUserService.getAuctionUser(auctionID);
        return ResponseEntity.ok(AuctionMapper.INSTANCE.getAuctionUserDto(output));
    }
}