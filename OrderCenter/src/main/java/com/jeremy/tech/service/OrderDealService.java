package com.jeremy.tech.service;

import com.jeremy.tech.bean.AbstractOrder;
import com.jeremy.tech.componet.OrderQueue;
import com.jeremy.tech.exception.InvalidOperationException;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by jeremysong on 6/11/2017.
 */
public class OrderDealService {
    private static final Executor EXECUTOR = Executors.newCachedThreadPool();
    private OrderQueue<AbstractOrder> queue = OrderQueue.getInstance();

    private boolean isStarted = false;
    private long waitTime = 1000L;
    private final String threadName = "ORDER_SERVICE";

    public boolean isStarted() {
        return isStarted;
    }

    public synchronized void start() throws InvalidOperationException {
        if (isStarted) {
            throw new InvalidOperationException("The service has been started.");
        }

    }

    private void startInThread(){
        Runnable runnable = ()->{
            execute();
        };

        Thread orderThread = new Thread(runnable);
        orderThread.setName(threadName);
    }

    private void execute() {
        if (queue != null) {
            AbstractOrder order = (AbstractOrder) queue.poll();
            if (order != null) {
                EXECUTOR.execute(order);
            }
        }
    }
}
