package se.project.coalingot.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    Long itemId;
    String itemName;
    String itemImage;
    String itemDescription;
    Double price;

}
