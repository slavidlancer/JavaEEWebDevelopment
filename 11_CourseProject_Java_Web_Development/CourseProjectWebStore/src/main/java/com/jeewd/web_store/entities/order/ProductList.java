package com.jeewd.web_store.entities.order;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.jeewd.web_store.entities.product.Product;

@Entity
@Table(name = "PRODUCT_LIST")
public class ProductList {
    @Id
    /*@SequenceGenerator(name = "product_list_gen",
            sequenceName = "product_list_seq", initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_list_gen")*/
    @Column(name = "ID")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @Column(name = "QUANTITY")
    private Integer quantity;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
