package se.project.coalingot.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.project.coalingot.auction.entity.Auction;
import se.project.coalingot.auction.repository.AuctionRepository;
import se.project.coalingot.auction.service.AuctionService;
import se.project.coalingot.auctionuser.entity.AuctionUser;
import se.project.coalingot.auctionuser.repository.AuctionUserRepository;
import se.project.coalingot.item.entity.Item;
import se.project.coalingot.item.repository.ItemRepository;
import se.project.coalingot.security.entity.Authority;
import se.project.coalingot.security.entity.AuthorityName;
import se.project.coalingot.security.repository.AuthorityRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    AuctionUserRepository auctionUserRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    AuctionRepository auctionRepository;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        addUser();
        addItem();
        addAuction();
    }


    AuctionUser newUser;
    Item[] items = new Item[3];
    public void addUser() {
        Authority roleUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        authorityRepository.save(roleUser);

        newUser = new AuctionUser();

        newUser.setFirstname("Coal");
        newUser.setLastname("Ingot");
        newUser.setUsername("Coal123");
        newUser.setEmail("Coal@ingot.com");
        newUser.setPassword(encoder.encode("Ingot321"));
        newUser.setEnabled(true);
        newUser.setLastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));

        newUser.getAuthorities().add(roleUser);
        auctionUserRepository.save(newUser);
    }

    public void addItem() {
        String[] image = {
                "https://randomwordgenerator.com/img/picture-generator/52e2d64a4851a514f1dc8460962e33791c3ad6e04e507441722978d6944acc_640.jpg",
                "https://randomwordgenerator.com/img/picture-generator/52e0dc404c5ab10ff3d8992cc12c30771037dbf85254784b772872dc944f_640.jpg",
                "https://randomwordgenerator.com/img/picture-generator/54e8dd444253a514f1dc8460962e33791c3ad6e04e507440772872dc9344c6_640.jpg"
        };
        for(int i=0;i<3;i++){
            items[i] = Item.builder()
                    .itemName("Item " + (i+1))
                    .itemImage(image[i])
                    .itemDescription("It is an item number " + (i + 1))
                    .price(1.20)
                    .build();
            itemRepository.save(
                    items[i]
            );
        }
    }

    public void addAuction() {
        Auction auc1 = Auction.builder()
                .auctionItem(items[0])
                .startDate(Timestamp.valueOf(LocalDateTime.now()))
                .endDate(Timestamp.valueOf(LocalDateTime.now()))
                .highestPrice(1.50)
                .status(true)
                .build();
        auctionRepository.save(auc1);


        Auction auc2 = Auction.builder()
                .auctionItem(items[1])
                .startDate(Timestamp.valueOf(LocalDateTime.now()))
                .endDate(Timestamp.valueOf(LocalDateTime.now()))
                .highestPrice(1.50)
                .status(true)
                .build();
        auctionRepository.save(auc2);

        Auction auc3 = Auction.builder()
                .auctionItem(items[2])
                .startDate(Timestamp.valueOf(LocalDateTime.now()))
                .endDate(Timestamp.valueOf(LocalDateTime.now()))
                .highestPrice(1.50)
                .status(true)
                .build();
        auctionRepository.save(auc3);
    }

}
