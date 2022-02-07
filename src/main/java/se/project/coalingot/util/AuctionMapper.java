package se.project.coalingot.util;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se.project.coalingot.item.dto.ItemDto;
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
}
