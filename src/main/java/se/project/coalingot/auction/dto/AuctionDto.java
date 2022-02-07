package se.project.coalingot.auction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.project.coalingot.auctionuser.dto.AuctionUserPaticipantDto;
import se.project.coalingot.item.dto.ItemDto;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDto {
    AuctionUserPaticipantDto paticipant;
    ItemDto auctionItem;
    Double submitPrice;
    Date atTime;
}
