package com.fantasybaby.mqtt.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONWriter;
import com.fantasybaby.mqtt.demo.data.AgvStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created on 6/22/2021.
 *
 * @author Reid Liu
 */
@SpringBootApplication
public class MqttDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqttDemoApplication.class, args);
        test();
    }


    private static void test(){

        MqttPushClient client = MqttPushClient.getInstance();
//        client.subscribe("/#");
        AgvStatus agv = new AgvStatus();
        agv.setOnline(3);
        agv.setOffline(6);
        agv.setException(7);
        client.publish("v1/devices/me/telemetry", JSON.toJSONString(agv));
    }
}
