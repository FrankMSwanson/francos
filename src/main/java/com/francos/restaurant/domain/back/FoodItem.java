package com.francos.restaurant.domain.back;

import com.francos.restaurant.domain.base.BaseAuditEntity;
import com.francos.restaurant.domain.type.MeasureType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Basic class to hold a slightly more abstract version of an ingredient.
 *
 * this will track the stock and amount we pay for a given unit of measure.
 *
 * User: frankswanson
 * Date: 5/4/14
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class FoodItem extends BaseAuditEntity {

    private String description;

    @ManyToMany(mappedBy = "foodItems")
    private Set<Offering> offerings;



    private String supplierId;

    @Column(precision = 7, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private MeasureType measureType;

    private int stock;
}
