package se.project.coalingot.auctionuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.project.coalingot.auctionuser.entity.AuctionUser;

public interface AuctionUserRepository extends JpaRepository<AuctionUser,Long> {
}
