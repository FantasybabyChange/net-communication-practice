package com.fantasybaby.mqtt.demo.data;

import lombok.Data;

/**
 * Created on 6/22/2021.
 *
 * @author Reid Liu
 */
@Data
public class AgvStatus {
    private Integer online;
    private Integer offline;
    private Integer exception;
}
