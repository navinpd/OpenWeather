package com.big.openweather.parameterized_listener;import java.util.HashMap;// Parameterized TPCResult interfacepublic interface TPCResult<T> {    // Result object    T getResult();    // Additional data if anything else need to be sent from SDK    HashMap<String, Object> getAdditionalInformation();}