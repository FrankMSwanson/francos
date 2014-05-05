package com.francos.restaurant.domain.back;

import com.francos.restaurant.domain.back.FoodItem;
import com.francos.restaurant.domain.base.BaseAuditEntity;
import com.francos.restaurant.domain.type.OfferingType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
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


    private OfferingType offeringType;

    private String description;

    private BigDecimal cost;


    private Set<FoodItem> ingredients;

    //Link to external stockSystem
    private Long stockId;
}
