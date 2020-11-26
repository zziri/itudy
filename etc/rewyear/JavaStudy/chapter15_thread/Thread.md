# Thread 프로그래밍

## Thread 구현
1. Thread 클래스 상속받아 구현

2. Runnable 인터페이스 구현

   


## Thread 우선순위
Thread.MIN_PRIORITY(=1) ~ Thread.MAX_PRIORITY(=10) 범위의 우선순위가 존재함.   
(디폴트 우선순위: Thread.NORM_PRIORITY(=5))
우선순위가 높은 thread가 CPU를 배분 받을 확률이 높음.   
int getPriority() / setPriority(int newPriority)  메서드를 통해 우선순위를 Get/Set 할 수 있음.



## join() 메서드
다른 thread의 결과를 보고 스레드 동작을 진행해야 하는 일이 있을 경우 join() 메서드를 활용.   
join() 메서드를 호출한 thread가 non-runnable 상태가 됨.
(join메서드를 호출당한 thread가 dead될때까지)  
![join호출상태](https://github.com/zziri/itudy/blob/master/image/)



## interrupt() 메서드
다른 thread에 예외를 발생시키는 interrupt를 보냄.   
thread가 join(), sleep(), wait() 메서드에 의해 blocking되었다면 interrupt에 의해 다시 runnable상태가 될 수 있음.



## Thread 종료하기
데몬이나 서비스에서 대개 thread는 while문을 통해 무한반복을 하는데 Thread.stop()메서드가 아닌 flag를 이용하여 thread를 종료하는 방식을 많이 사용함.



## Thread 동기화(synchronization)
Multi Thread 프로그래밍에서 공유자원에 대한 동시 접근을 막기위해 하나의 thread만 접근 가능하게 해야한다. 이때 공유자원을 **임계영역(Critical Section)**이라고 하며, 이를 위해 해당 자원에 **lock(*mutex*)**을 걸어주어 동시접근을 막고 thread간의 접근 순서를 맞추는 행위를 **동기화**라고 한다.

![thread 동기화](https://github.com/zziri/itudy/blob/master/image/)

#### Java에서 동기화 구현

* **synchronized 키워드:** synchronized 키워드 이용하면 해당 메서드가 실행될때, 이 메서드에 속해있는 객체에  lock을 건다.
* **synchronized 수행문:** 참조형 수식에 해당하는 객체에 lock을 건다.
```
synchronized(참조형 수식){

}
// 참조형 수식에 해당되는 객체에 lock을 검
```



## wait() / notify() 메서드
* **wait():** 사용하려는 리소스가 더 이상 유효하지 않은 경우(lock이 되어있는 상태) 리소스를 사용할 수 있을 때까지 thread를 non-runnable상태로 전환. 이렇게 wait상태가 된 thread는 notify가 호출될 때까지 기다림
* **notify():** wait하고 있는 thread 중 한 thread를 runnable한 상태로 깨움
* **notifyAll():** wait하고 있는 모든 thread를 runnable한 상태로 만든다음 다시 scheduler에 의해서 CPU를 점유하게 함(notify()보다 좀 더 공평하게 자원배분)