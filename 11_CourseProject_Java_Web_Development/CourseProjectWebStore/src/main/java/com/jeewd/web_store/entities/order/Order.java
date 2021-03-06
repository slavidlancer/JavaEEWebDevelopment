package com.jeewd.web_store.entities.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import com.jeewd.web_store.entities.customer.Customer;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    /*@SequenceGenerator(name = "order_gen", sequenceName = "order_seq",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order_gen")*/
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "OVERALL_PRICE")
    private BigDecimal overallPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER")
    private Customer customer;
    @Column(name = "PURCHASE_DATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date purchaseDate;
    @Column(name = "STATUS")
    private String status;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PRODUCT_LIST",
    joinColumns = {@JoinColumn(name = "ORDER_ID",
            referencedColumnName = "ID")},
    inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID",
            referencedColumnName = "ID")})
    private List<ProductList> productList;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public BigDecimal getOverallPrice() {
        return overallPrice;
    }
    
    public void setOverallPrice(BigDecimal overallPrice) {
        this.overallPrice = overallPrice;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Date getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<ProductList> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductList> productList) {
        this.productList = productList;
    }
}
