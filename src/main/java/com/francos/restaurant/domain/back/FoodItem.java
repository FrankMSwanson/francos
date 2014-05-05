package com.francos.restaurant.domain.back;

import com.francos.restaurant.domain.base.BaseAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Basic class to hold a slightly more abstract version of an ingredient.
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
    private String supplierId;

    @ManyToMany(mappedBy = "foodItems")
    private Set<Offering> offerings;

}
