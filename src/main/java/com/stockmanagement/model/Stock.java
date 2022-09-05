package com.stockmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @created Barnaba Mutai
 * @created 05/ 09/ 2022 - 10:44 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "stocks",uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})}
)
public class Stock {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(name="stock_id",nullable = false)
    private String stock_id;
    @Column(name="type",nullable = false)
    private String type;
    @Column(name="symbol",nullable = false)
    private String symbol;
    @Column(name="shares",nullable = false)
    private String shares;
    @Column(name="price",nullable = false)
    private String price;
    @Column(name="timestamp",nullable = false)
    private String timestamp;
    @Column(name="user_id",nullable = false)
    private String user_id;
    @Column(name="user_name",nullable = false)
    private String user_name;
}
