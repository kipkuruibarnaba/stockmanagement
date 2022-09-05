package com.stockmanagement.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @created Barnaba Mutai
 * @created 04/ 09/ 2022 - 5:21 PM
 */
@Data
public class StockDTO {
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("shares")
    private String shares;
    @JsonProperty("price")
    private String price;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("user")
    private User user;
}
