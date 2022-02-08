package se.project.coalingot.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.project.coalingot.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
