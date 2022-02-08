package se.project.coalingot.item.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    String itemName;
    String itemImage;
    String itemDescription;
    Double startPrice;
    Date endDate;
}
