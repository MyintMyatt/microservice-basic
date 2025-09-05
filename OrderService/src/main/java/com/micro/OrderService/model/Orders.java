package com.micro.OrderService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tblOrders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String order_number;
    private Integer user_id;
    private Integer product_id;
    private int quantity;
    private double total_price;
    private LocalDate order_date;

    public Long getId() {
        return id;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }



    @PostPersist
    private void updateOrderNumber() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        String year = String.format("%02d", currentDate.getYear() % 100);  // Last two digits of the year
        String month = String.format("%02d", currentDate.getMonthValue());  // 2-digit month
        String day = String.format("%02d", currentDate.getDayOfMonth());    // 2-digit day

        // Format ID to be 6 digits, padded with zeros if necessary
        String formattedId = String.format("%06d", this.id);

        // Construct order_number in the desired format
        this.order_number = "OID" + year + month + day + formattedId;
        this.order_date = LocalDate.now();
    }
}
