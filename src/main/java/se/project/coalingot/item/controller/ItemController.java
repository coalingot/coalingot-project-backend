package se.project.coalingot.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import se.project.coalingot.item.entity.Item;
import se.project.coalingot.item.entity.ItemRequest;
import se.project.coalingot.item.service.ItemService;
import se.project.coalingot.util.AuctionMapper;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<?> getAllItems() {
        List<Item> output = itemService.getAllItem();
        return ResponseEntity.ok(AuctionMapper.INSTANCE.getItemDto(output));
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<?> getItem(
            @PathVariable("itemId") Long itemId
    ) {
        Item output = itemService.itemDetail(itemId);
        return ResponseEntity.ok(AuctionMapper.INSTANCE.getItemDto(output));
    }

    @PostMapping("/items")
    public ResponseEntity<?> postItem(
            @RequestBody ItemRequest itemRequest
    ){
        itemService.postItem(itemRequest);
        return ResponseEntity.ok("Item has been posted");
    }

    @PostMapping("/items/end-acution/{auctionId}")
    public ResponseEntity<?> endAuction(
            @PathVariable("auctionId") Long auctionId
    ){
        return ResponseEntity.ok(AuctionMapper.INSTANCE.getItemDto(itemService.endAuction(auctionId)));
    }
}
