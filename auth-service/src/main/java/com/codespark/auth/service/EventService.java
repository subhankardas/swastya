package com.codespark.auth.service;

public interface EventService {

    <K, V> void publish(String topic, K key, V message);

}
