package se.project.coalingot.auctionuser.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.project.coalingot.auction.entity.AuctionHistory;
import se.project.coalingot.item.dto.ItemDto;

import javax.persistence.Column;
import java.util.List;

// user details
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionUserDto {
    String username;
    String firstname;
    String lastname;
    List<ItemDto> own;
    List<AuctionHistory> history;
}
