package se.project.coalingot.auction.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionRequest {
    Long auctionId;
    Long userId;
    Double submitPrice;
}
