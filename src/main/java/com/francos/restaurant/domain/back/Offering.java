package com.francos.restaurant.domain.back;

import com.francos.restaurant.domain.back.FoodItem;
import com.francos.restaurant.domain.base.BaseAuditEntity;
import com.francos.restaurant.domain.type.OfferingType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * An item that is availble to be created in teh restraunt.
 *
 * User: frankswanson
 * Date: 5/4/14
 * Time: 4:37 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Offering extends BaseAuditEntity {


    @Enumerated(EnumType.STRING)
    private OfferingType offeringType;

    private String description;

    private BigDecimal cost;


    @ManyToMany
    @JoinTable(name="offering_food_items",
            joinColumns={@JoinColumn(name="offering_id")},
            inverseJoinColumns={@JoinColumn(name="food_item_id")})
    private Set<FoodItem> foodItems;

    //Link to external stockSystem
    private Long stockId;
}
