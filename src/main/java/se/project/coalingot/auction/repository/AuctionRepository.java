package se.project.coalingot.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.project.coalingot.auction.entity.Auction;

public interface AuctionRepository extends JpaRepository<Auction,Long> {
}
