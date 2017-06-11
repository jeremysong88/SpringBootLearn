package com.jeremy.tech;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jeremysong on 6/11/2017.
 */
public class SimpleOrderCenter {
    private LinkedBlockingQueue<Runnable> messageQueue = new LinkedBlockingQueue();
    private Executor executor = Executors.newSingleThreadExecutor();
    private boolean isDealStarted = false;

    /**
     * 向队列中添加任务实例
     *
     * @param task 任务实例，对象必须实现{@code Runnable}接口
     */
    public synchronized void addTask(Runnable task) {
        messageQueue.add(task);
    }

    /**
     * 通知信息中心开始处理任务
     */
    public synchronized void startDealTask() {
        if (!isDealStarted) {
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        Runnable task = messageQueue.poll();
                        if (null != task) {
                            executor.execute(task);
                        } else {
                            try {
                                System.out.println("Waiting task ...");
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                @Override
                protected void finalize() throws Throwable {
                    super.finalize();
                    isDealStarted = false;
                }
            }).start();
            isDealStarted = true;
        }
    }

    /**
     * 任务对象类，实现{@code Runnable}接口，用以执行具体业务
     */
    private static class MTask implements Runnable {
        private String taskName;

        public MTask(String taskName) {
            this.taskName = taskName;
        }

        public void run() {
            System.out.println("Task: " + taskName + " is started");
            try {
                Thread.sleep(new Random().nextInt(5) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            callBack();
        }

        /**
         * 回调函数
         * 可使用其他业务对象实例作为构造函数参数传入，在{@link #run()}方法
         * 中根据具体业务通知需求酌情调用
         */
        public void callBack() {
            System.out.println("Task: " + taskName + " is finished!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final SimpleOrderCenter center = new SimpleOrderCenter();
        center.startDealTask();

        Thread taskA = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 30; i++) {
                    center.addTask(new MTask("Task-A-" + i));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread taskB = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 30; i++) {
                    center.addTask(new MTask("Task-B-" + i));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread taskC = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 30; i++) {
                    center.addTask(new MTask("Task-C-" + i));
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        taskA.start();
        taskB.start();
        taskC.start();
    }
}
