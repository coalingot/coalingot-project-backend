package se.project.coalingot.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemHistoryDto {
    Long itemId;
    String itemName;
    String itemImage;
}
