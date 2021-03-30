
def solution(A, K):
    ret = [0]*len(A)
    base = len(A)-K
    for i in range(len(A)):
        ret[i] = A[(base+i)%len(A)]
    
    return ret
