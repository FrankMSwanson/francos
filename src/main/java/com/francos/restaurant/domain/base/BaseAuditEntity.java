package com.francos.restaurant.domain.base;

import com.francos.restaurant.config.Constants;
import com.francos.restaurant.security.SecurityUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

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

    private static Logger log = LoggerFactory.getLogger(BaseAuditEntity.class);
    @Column(length = Constants.LOGIN_LENGTH, nullable = false,updatable = false)
    private String createdBy;
    @Column(nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime createdTime;

    @Column(length = Constants.LOGIN_LENGTH, nullable = false,updatable = false)
    private String updatedBy;
    @Column(nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime updatedTime;


    @PrePersist
    protected void onCreate() {

        log.debug("********uuuu********");
        createdBy = updatedBy = SecurityUtils.getCurrentLogin();
        updatedTime = createdTime = new LocalDateTime();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedBy = SecurityUtils.getCurrentLogin();
        updatedTime = new LocalDateTime();    }

}
