
def solution(N):
    base, idx = 1, 0
    arr = list()
    while True:
        if base > N:
            break
        
        if base & N != 0:
            arr.append(idx)
        
        base, idx = base << 1, idx + 1
    
    if len(arr) < 2:
        return 0
    
    ret = 0

    for i in range(len(arr)-1):
        ret = max(ret, arr[i+1] - arr[i] - 1)
    
    return ret
