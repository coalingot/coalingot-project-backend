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
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long auctionId;

    @ManyToOne
    AuctionUser paticipant;

    @OneToOne
    Item auctionItem;

    Double submitPrice;
    Date atTime;

}
