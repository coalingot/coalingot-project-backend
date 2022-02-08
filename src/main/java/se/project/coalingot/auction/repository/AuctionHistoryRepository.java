package se.project.coalingot.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.project.coalingot.auction.entity.AuctionHistory;

public interface AuctionHistoryRepository extends JpaRepository<AuctionHistory, Long> {
}
