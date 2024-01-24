package com.example.userservice.util;

import io.prometheus.client.Counter;

public class MetricUtil {
    private MetricUtil(){}

    private static final Counter myCounter = Counter.build()
            .name("my_counter")
            .labelNames("userService", "demo")
            .help("this is demo counter").register();

    public static void myCounter(String val) {
        myCounter.labels("userService", val);
    }
}
