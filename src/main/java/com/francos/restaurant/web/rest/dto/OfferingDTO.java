package com.francos.restaurant.web.rest.dto;

import com.francos.restaurant.domain.type.OfferingType;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: frankswanson
 * Date: 5/5/14
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
public class OfferingDTO {

    private long id;

    private String offeringType;

    private String description;
    private BigDecimal cost;
}
