package com.jeremy.tech.componet;

import com.jeremy.tech.bean.AbstractOrder;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jeremysong on 6/11/2017.
 */
public class OrderQueue<E extends AbstractOrder> extends LinkedBlockingQueue{

    private static OrderQueue queue = new OrderQueue();

    private OrderQueue(){}

    public static OrderQueue getInstance() {
        return queue;
    }
}
