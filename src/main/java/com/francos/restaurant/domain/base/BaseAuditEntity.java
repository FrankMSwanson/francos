package com.francos.restaurant.domain.base;

import com.francos.restaurant.config.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created with IntelliJ IDEA.
 * User: frankswanson
 * Date: 5/4/14
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class BaseAuditEntity extends BaseEntity{

    @Column(length = Constants.LOGIN_LENGTH, nullable = false,updatable = false)
    private String createdBy;
    @Column(nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime createdTime;


    private String updatedBy;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime updateTime;


}
