package com.app.ifocusmission;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sandeep on 11/21/2015.
 */
public class NotificationIdRandomGenerator {
    private final static AtomicInteger integer = new AtomicInteger(0);

    public static int getID() {
        return integer.incrementAndGet();
    }
}
