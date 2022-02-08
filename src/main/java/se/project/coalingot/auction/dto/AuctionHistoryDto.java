package se.project.coalingot.auction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.project.coalingot.auctionuser.dto.AuctionUserPaticipantDto;
import se.project.coalingot.item.dto.ItemAuctionDto;
import se.project.coalingot.item.dto.ItemDto;
import se.project.coalingot.item.dto.ItemHistoryDto;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionHistoryDto {
    AuctionUserPaticipantDto auctionUser;
    Double submitPrice;
    Date submitAt;
    ItemHistoryDto auctionItem;
}
