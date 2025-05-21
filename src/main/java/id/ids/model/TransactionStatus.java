package id.ids.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_status")
public class TransactionStatus {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

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


    public TransactionStatus() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
