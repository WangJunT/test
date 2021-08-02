package com.jy.netty;

public class DefaultPromiseTest {
    public static void main(String[] args) throws InterruptedException {
//        EventExecutor executor = new DefaultEventExecutor();
//        Promise promise = new DefaultPromise(executor);
//        promise.addListener((GenericFutureListener) future -> {
//            if (future.isSuccess()) {
//                System.out.println("成功");
//            } else {
//                System.out.println("失败");
//            }
//        }).addListener((GenericFutureListener) future -> {
//            System.out.println("执行完成");
//        });
//        executor.submit(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            promise.setSuccess("Hello");
//            promise.setFailure(new RuntimeException());
//        });
//        promise.sync();
    }
}
