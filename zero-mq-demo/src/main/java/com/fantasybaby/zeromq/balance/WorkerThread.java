package com.fantasybaby.zeromq.balance;

import org.zeromq.ZMQ;

public class WorkerThread extends Thread {
    private ZMQ.Context ctx;
    private int handled = 0;
    private int totalHandled = 0;
    private int threadNo = 0;

    public WorkerThread(int threadNo, ZMQ.Context ctx) {
        super("Worker-" + threadNo);
        this.threadNo = threadNo;
        this.ctx = ctx;
    }

    public void run() {
        try {
            // Create PULL socket
            ZMQ.Socket socket = ctx.socket(ZMQ.PULL);
            // Set high water mark to 2,
            // so that when this peer had 2 messages
            // in its buffer, ZeroMQ skipped to next workers
            socket.setHWM(2);
            // Connect to in-process endpoint
            socket.connect("inproc://workers");

            while (true) {
                byte[] msg;
                try {
                    // Get work piece
                    msg = socket.recv(0);
                } catch (Exception e) {
                    // ZeroMQ throws exception when
                    // the context is terminated
                    socket.close();
                    break;
                }
                handled++;
                totalHandled++;
                System.out.println(getName()
                        + " handled work piece " + msg[0]);
                int sleepTime = (threadNo % 2 == 0) ? 100 : 200;
                // Handle work, by sleeping for some time
                Thread.sleep(sleepTime);
            }
            System.out.println(getName()
                        + " handled count " + handled);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
