package se.project.coalingot.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemAuctionDto {
    Long itemId;
    String itemName;
    String itemImage;
    String itemDescription;
}
