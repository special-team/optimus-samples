package org.ufox.rubik.optimus.archer.business.customer.entity;

import com.github.ooknight.rubik.core.entity.UEntity;
import org.ufox.rubik.optimus.archer.business.customer.enums.CustomerState;
import org.ufox.rubik.optimus.archer.business.customer.extension.Address;

import com.alibaba.fastjson.annotation.JSONField;
import io.ebean.annotation.DbJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "e_business_customer")
public class Customer extends UEntity {

    @Column(name = "name_")
    @JSONField(ordinal = 101)
    private String name;
    @Column(name = "mobile_")
    @JSONField(ordinal = 102)
    private String mobile;
    @Column(name = "mail_")
    @JSONField(ordinal = 103)
    private String mail;
    @DbJson
    @Column(name = "address_")
    @JSONField(ordinal = 104)
    private Address address;
    @Column(name = "state_")
    @JSONField(ordinal = 105)
    private CustomerState state;
    @Column(name = "gid_")
    @JSONField(ordinal = 106)
    private Long gid;
}
