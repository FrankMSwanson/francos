package com.francos.restaurant.web.rest.dto;

import com.francos.restaurant.domain.back.Offering;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: frankswanson
 * Date: 5/5/14
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
public class MenuItemDTO {


    private Long id;

    private BigDecimal price;

    private boolean active;

    private String description;
}
