package com.francos.restaurant.repository;

import com.francos.restaurant.domain.front.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Menu entity.
 */
public interface MenuRepository extends JpaRepository<MenuItem, Long> {

}
