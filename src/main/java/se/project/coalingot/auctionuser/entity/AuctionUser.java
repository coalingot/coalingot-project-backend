package se.project.coalingot.auctionuser.entity;

import lombok.*;
import se.project.coalingot.auction.entity.Auction;
import se.project.coalingot.item.entity.Item;
import se.project.coalingot.security.entity.User;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AuctionUser extends User {
   @OneToMany(mappedBy = "ownBy")
   List<Item> own = new ArrayList<>();

   @OneToMany(mappedBy = "paticipant")
   List<Auction> paticipanted;
}
