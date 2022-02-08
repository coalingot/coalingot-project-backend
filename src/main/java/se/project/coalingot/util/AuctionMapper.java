package se.project.coalingot.util;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se.project.coalingot.auction.dto.AuctionDto;
import se.project.coalingot.auction.dto.AuctionHistoryDto;
import se.project.coalingot.auction.entity.Auction;
import se.project.coalingot.auction.entity.AuctionHistory;
import se.project.coalingot.auctionuser.dto.AuctionUserDto;
import se.project.coalingot.auctionuser.dto.AuctionUserPaticipantDto;
import se.project.coalingot.auctionuser.entity.AuctionUser;
import se.project.coalingot.item.dto.ItemAuctionDto;
import se.project.coalingot.item.dto.ItemDto;
import se.project.coalingot.item.dto.ItemHistoryDto;
import se.project.coalingot.item.entity.Item;
import se.project.coalingot.security.dto.UserAuthDto;
import se.project.coalingot.security.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface AuctionMapper {
    AuctionMapper INSTANCE = Mappers.getMapper(AuctionMapper.class);

    @Mapping(target = "authorities", expression = "java(user.getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    UserAuthDto getUserAuthDto(User user);

    ItemDto getItemDto(Item item);
    List<ItemDto> getItemDto(List<Item> items);

    ItemAuctionDto getItemAuctionDto(Item item);
    List<ItemAuctionDto> getItemAuctionDto(List<Item> items);

    ItemHistoryDto getItemHistoryDto(Item item);
    List<ItemHistoryDto> getItemHistoryDto(List<Item> items);

    AuctionDto seeAuction(Auction auction);
    List<AuctionDto> seeAuction(List<Auction> auctions);

    AuctionUserDto getAuctionUserDto(AuctionUser auctionUser);
    List<AuctionUserDto> getAuctionUserDto(List<AuctionUser> auctionUser);

    AuctionUserPaticipantDto seePaticipant(AuctionUser auctionUser);
    List<AuctionUserPaticipantDto> seePaticipant(List<AuctionUser> actionUsers);

    AuctionHistory seeAuctionHistory(AuctionHistory auctionHistory);
    List<AuctionHistoryDto> seeAuctionHistory(List<AuctionHistory> auctionHistories);

}
