package id.ids.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "productID", length = 10)
    private String productId;

    @Column(name = "productName", nullable = false, length = 100)
    private String productName;

    @Column(name = "createBy", nullable = false, length = 100)
    private String createBy;

    @Column(name = "createOn", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createOn;

    @Column(name = "updateBy", length = 100)
    private String updateBy;

    @Column(name = "updateOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateOn;

    @Column(name = "deleteBy", length = 100)
    private String deleteBy;

    @Column(name = "deleteOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteOn;


    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    public String getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy;
    }

    public Date getDeleteOn() {
        return deleteOn;
    }

    public void setDeleteOn(Date deleteOn) {
        this.deleteOn = deleteOn;
    }
}

