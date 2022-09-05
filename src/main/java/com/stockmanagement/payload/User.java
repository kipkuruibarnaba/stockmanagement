package com.stockmanagement.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @created Barnaba Mutai
 * @created 04/ 09/ 2022 - 10:21 PM
 */
@Data
public class User {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
}
