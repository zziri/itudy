# mutex semaphore

뮤텍스와 세마포어의 특징과 차이점을 알아봅니다

## semaphore

세마포어는 counting/binary 두 가지 종류가 있습니다

counting은 세마포어 값을 자원의 갯수로 초기화합니다 (경우에 따라 0으로 초기화 하는 경우도 있습니다)

자원을 취득할 때 P(S) 연산을 통해서 취득합니다. 이때 세마포어 값이 1만큼 줄어듭니다.

자원을 반환할 때 V(S) 연산을 통해서 반환합니다. 이때 세마포어 값이 1만큼 증가합니다.

자원을 취득할 수 없다면, 즉 세마포어 값이 0이라면 busy wait 방식 혹은 block & wakeup 방식을 사용해서 해당 프로세스(혹은 스레드)를 대기시킵니다

세마포어는 소유하지 않은 프로세스(혹은 스레드)가 세마포어를 해제할 수도 있습니다. // V(S) 연산

## mutex

mutual exclusion(상호배제)와 같은 말입니다

binary 세마포어라고도 합니다

자원을 취득할 때 lock 연산을 통해서 취득합니다

자원을 반환할 때 unlock 연산을 통해서 반환합니다

자원을 취득할 수 없다면, 즉 locked 상태라면 해당 프로세스(혹은 스레드)를 대기시킵니다

뮤텍스는 소유한 프로세스(혹은 스레드)가 해제해야 합니다

## mutex vs semaphore

세마포어로 뮤텍스를 구현할 수 있습니다(binary semaphore)

세마포어는 소유하지 않아도 해제가 가능하지만 뮤텍스는 소유한 프로세스(혹은 스레드)가 해제해야 합니다

OS마다 차이가 있을 수 있으나 대부분의 경우 세마포어는 프로세스, 뮤텍스는 스레드를 대상으로 동기화할 때 사용합니다

세마포어는 대부분의 경우 파일의 형태로 존재하고 뮤텍스는 해당 스레드(혹은 프로세스)의 주소 공간에 존재합니다. 또한, 대부분의 경우 뮤텍스는 프로세스가 종료될 때 자동으로 Clean up 됩니다.