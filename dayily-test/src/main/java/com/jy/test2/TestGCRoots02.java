package com.jy.test2;


public class TestGCRoots02 {
    private static int _10MB = 10 * 1024 * 1024;
    private byte[] memory;

    private static TestGCRoots02 t;

    public TestGCRoots02(int size) {
        memory = new byte[size];
    }

    /**
     * -XXprintGcDetails
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        TestGCRoots02 t2 = new TestGCRoots02(4 * _10MB);
        t2.t = new TestGCRoots02(8 * _10MB);
        t2 = null;
        System.gc();
        Thread.sleep(Integer.MAX_VALUE);
    }
}

