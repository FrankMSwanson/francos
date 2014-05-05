package com.francos.restaurant.domain.front;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateDeserializer;
import com.francos.restaurant.domain.base.BaseAuditEntity;
import com.francos.restaurant.domain.base.Staff;
import com.francos.restaurant.domain.util.CustomLocalDateSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * A GuestOrder.
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class GuestOrder extends BaseAuditEntity {


    @ManyToOne
    private Staff server;

    private String tableName;

    @OneToMany(mappedBy = "guestOrder", fetch = FetchType.EAGER)
    private List<OrderDetail> items;


    @Column(precision = 9, scale = 2)
    private BigDecimal itemTotal;
    @Column(precision = 7, scale = 2)
    private BigDecimal discount;

    @Column(precision = 7, scale = 2)
    private BigDecimal tip;
    @Column(precision = 7, scale = 2)
    private BigDecimal tax;
    @Column(precision = 9, scale = 2)
    private BigDecimal total;
}
