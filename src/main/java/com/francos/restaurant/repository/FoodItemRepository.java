package com.francos.restaurant.repository;

import com.francos.restaurant.domain.back.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the FoodItem entity.
 */
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

}
