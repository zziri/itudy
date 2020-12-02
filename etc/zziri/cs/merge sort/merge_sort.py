
import sys


def merge(arr, left, mid, right):
    larr = arr[left:mid+1]
    rarr = arr[mid+1:right+1]
    
    ll, rl, i, j, idx = len(larr), len(rarr), 0, 0, left

    while ll > i and rl > j:
        if larr[i] <= rarr[j]:
            arr[idx] = larr[i]
            i += 1
        else:
            arr[idx] = rarr[j]
            j += 1
        idx += 1
    
    while ll > i:
        arr[idx] = larr[i]
        idx += 1
        i += 1
    
    while rl > j:
        arr[idx] = rarr[j]
        idx += 1
        j += 1


def merge_sort(arr, left, right):
    if left < right:
        mid = int((left+right)/2)

        merge_sort(arr, left, mid)
        merge_sort(arr, mid+1, right)
        merge(arr, left, mid, right)


def sorting(arr):
    merge_sort(arr, 0, len(arr)-1)
    

def main(args):
    if not args:
        arr = [10, 2, 1, 3, 9, -1, 5, 4, 7, 8, 6, 0]
    else:
        arr = list(map(int, args))

    answer = sorted(arr)
    sorting(arr)

    print(arr)
    print(answer)

    return 0


if __name__ == "__main__":
    exit(main(sys.argv[1:]))
