package se.project.coalingot.auction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.project.coalingot.item.dto.ItemAuctionDto;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDto {
    Long auctionId;
    ItemAuctionDto auctionItem;
    Double highestPrice;
    Boolean status;
    Date startDate;
    Date endDate;
    List<AuctionHistoryDto> histories;
}
