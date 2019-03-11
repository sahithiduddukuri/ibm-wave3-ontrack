package com.stackroute.deliverymanagerlogin.security;

import com.stackroute.deliverymanagerlogin.model.DeliveryManager;

import java.util.Map;

@FunctionalInterface
public interface SecurityTokenGenerator {
    Map<String, String> generateToken(DeliveryManager deliveryManager);
}
