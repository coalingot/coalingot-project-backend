package se.project.coalingot.auctionuser.entity;

import lombok.*;
import se.project.coalingot.security.entity.User;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuctionUser extends User {

}
