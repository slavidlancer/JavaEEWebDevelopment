package com.jeewd.web_store.entities.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType {
    @Id
    @SequenceGenerator(name = "product_type_gen",
            sequenceName = "product_type_seq", initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_type_gen")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
