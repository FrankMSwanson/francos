package com.francos.restaurant.domain.front;

import com.francos.restaurant.config.Constants;
import com.francos.restaurant.domain.base.BaseAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: frankswanson
 * Date: 5/4/14
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class OrderDetail extends BaseAuditEntity {

    /**
     * Support multiplicity at the detail level
     */
    @Column(columnDefinition = Constants.DB_INT_NN_DEF1)
    private int quantity;

    @ManyToOne
    private GuestOrder guestOrder;

    @ManyToOne
    private MenuItem menuItem;

    /**
     * This is the per item discount ... once per each in teh quantity
     */
    private BigDecimal discountPerItem;

}
