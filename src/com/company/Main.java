package com.company;

    class Lucky {
        static final NeedObject to = new NeedObject();

        static class LuckyThread extends Thread {
            @Override
            public void run() {
                while (true) {
                    synchronized (to) {
                        if(999999 <= to.getX()) break;
                        to.incrementX();
                        if ((to.getX() % 10) + (to.getX() / 10) % 10 + (to.getX() / 100) % 10 == (to.getX() / 1000)
                                % 10 + (to.getX() / 10000) % 10 + (to.getX() / 100000) % 10) {
                            System.out.println(to.getX() + " " + this.getName());
                            to.incrementCount();
                        }
                    }
                }
            }

            public static int getCount(){
                return to.getCount();
            }
        }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new LuckyThread();
        Thread t2 = new LuckyThread();
        Thread t3 = new LuckyThread();
        t1.setName("First thread");
        t2.setName("Second thread");
        t3.setName("Last thread");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + LuckyThread.getCount());
    }
}