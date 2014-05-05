package com.francos.restaurant.repository;

import com.francos.restaurant.domain.front.GuestOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the GuestOrder entity.
 */
public interface GuestOrderRepository extends JpaRepository<GuestOrder, Long> {

}
