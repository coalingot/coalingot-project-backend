package se.project.coalingot.auction.entity;

import lombok.*;
import se.project.coalingot.auctionuser.entity.AuctionUser;
import se.project.coalingot.item.entity.Item;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AuctionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long auctionHistoryId;

    @ManyToOne
    AuctionUser auctionUser;

    @ManyToOne
    Auction auctionEvent;

    Double submitPrice;

    Date submitAt;
}
