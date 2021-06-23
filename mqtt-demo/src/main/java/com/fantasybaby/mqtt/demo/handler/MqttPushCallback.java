package com.fantasybaby.mqtt.demo.handler;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created on 6/22/2021.
 *
 * @author Reid Liu
 */
@Slf4j
public class MqttPushCallback implements MqttCallback {

    @Override
    public void connectionLost(Throwable cause) {
        log.error("lost connect {}", this, cause);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.debug("{} delivery is complete", token.isComplete());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        log.debug("Topic:{},Message:{} ", topic, message.getPayload());
    }

}
