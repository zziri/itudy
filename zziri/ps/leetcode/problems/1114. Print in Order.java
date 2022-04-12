// MEMO : 이렇게 푸는거 맞나.. 동기화문제

// Runtime: 22 ms, faster than 37.38% of Java online submissions for Print in Order.
// Memory Usage: 43.4 MB, less than 17.63% of Java online submissions for Print in Order.
class Foo {
    private CountDownLatch latch;
    private CountDownLatch first;
    private CountDownLatch second;

    public Foo() {
        latch = new CountDownLatch(3);
        first = new CountDownLatch(1);
        second = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        latch.countDown();
        latch.await();
        printFirst.run();
        first.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        latch.countDown();
        latch.await();
        first.await();
        printSecond.run();
        second.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        latch.countDown();
        latch.await();
        second.await();
        printThird.run();
    }
}