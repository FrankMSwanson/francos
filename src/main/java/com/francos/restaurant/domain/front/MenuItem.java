package com.francos.restaurant.domain.front;

import com.francos.restaurant.domain.back.Offering;
import com.francos.restaurant.domain.base.BaseAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The current menu of items offered
 *
 * Menu items that our systems know how to precess come and go from the menu.
 *
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class MenuItem extends BaseAuditEntity {


    private Offering offering;

    //THe amount we will charge for this item on the current menu
    private BigDecimal price;

    //An item may have been offered. and is no longer. we will be able bring back and rember last offered price.
    private boolean active;

    //Will essentially override menuItem descripion if choose to be set
    private String description;


}
