package se.project.coalingot.item.entity;

import lombok.*;
import se.project.coalingot.auction.entity.Auction;
import se.project.coalingot.auctionuser.entity.AuctionUser;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long itemId;

    String itemName;
    String itemImage;
    String itemDescription;
    Double price;

    @ManyToOne(cascade= CascadeType.ALL)
    AuctionUser ownBy;

    @OneToOne(mappedBy = "auctionItem")
    Auction auctionAt;
}
