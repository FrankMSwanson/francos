package com.francos.restaurant.domain.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: frankswanson
 * Date: 5/4/14
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Staff extends BaseAuditEntity {

    private String firstName;
    private String lastName;

}
