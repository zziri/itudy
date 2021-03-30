
def solution(A):
    lib = dict()
    for n in A:
        lib[n] = lib.get(n, 0) + 1
    
    ret = 0

    for key, value in lib.items():
        if value & 0x01:
            ret = key
            break
        
    return ret
