package com.francos.restaurant.domain.front;

import com.francos.restaurant.domain.base.BaseAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @ManyToOne
    private GuestOrder guestOrder;

    @ManyToOne
    private MenuItem menuItem;

    private BigDecimal discount;

}
