package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @NotEmpty(message = "Ten san pham khong duoc de trong")
    private String name;

    @NotNull
    @Min(value = 0, message = "Gia san pham phai lon hon hoac bang 0")
    private Double price;
    private String image;

    @NotNull
    @NotEmpty(message = "Mo ta chi tiet san pham khong duoc de trong")
    @Column(columnDefinition="MEDIUMTEXT")
    private String detailDesc;
    
    @NotNull
    @NotEmpty(message = "Mo ta ngan san pham khong duoc de trong")
    private String shortDesc;

    @NotNull
    @Min(value = 0, message = "So luong san pham phai lon hon hoac bang 0")
    private Long quantity;

    private Long sold = 0L; // Initialize sold to 0
    private String factory;
    private String target;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getDetailDesc() {
        return detailDesc;
    }
    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }
    public String getShortDesc() {
        return shortDesc;
    }
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    public long getSold() {
        return sold;
    }
    public void setSold(long sold) {
        this.sold = sold;
    }
    public String getFactory() {
        return factory;
    }
    public void setFactory(String factory) {
        this.factory = factory;
    }
    public String getTarget() {
        return target;
    }
    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", image=").append(image);
        sb.append(", detailDesc=").append(detailDesc);
        sb.append(", shortDesc=").append(shortDesc);
        sb.append(", quantity=").append(quantity);
        sb.append(", sold=").append(sold);
        sb.append(", factory=").append(factory);
        sb.append(", target=").append(target);
        sb.append('}');
        return sb.toString();
    }
    
    
}
