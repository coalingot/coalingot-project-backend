package se.project.coalingot.auction.entity;

import lombok.*;
import se.project.coalingot.item.entity.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToOne
    Item auctionItem;

    @OneToMany(mappedBy = "auctionEvent")
    List<AuctionHistory> histories = new ArrayList<>();

    Date startDate;

    Date endDate;
}
