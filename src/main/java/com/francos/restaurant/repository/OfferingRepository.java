package com.francos.restaurant.repository;

import com.francos.restaurant.domain.back.Offering;
import com.francos.restaurant.domain.front.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Offering entity.
 */
public interface OfferingRepository extends JpaRepository<Offering, Long> {


}
