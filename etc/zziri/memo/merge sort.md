# merge sort

분할 정복 방법을 통해 구현하는 빠른 정렬 방법입니다

## Time Complexity


|평균|최선|최악|
|:---:|:---:|:---:|
|O(nlogn)|O(nlogn)|O(nlogn)|

## 장단점

- 빠른 정렬 성능을 보여줍니다
- `quick sort`와는 달리 `안정 정렬`입니다
- 순차적으로 정렬하므로 `Linked List` 자료구조의 자료들을 정렬할 때 유리합니다
- merge 과정에서 별도의 메모리를 소모합니다

## 구현 방법

1. `List`(array, linked list, ...) 자료구조를 재귀적으로 구간을 나눕니다
2. 구간으로 나누어진 두 개의 부분 집합을 병합하는 merge 함수를 호출합니다
3. merge 함수 내에서는 두 개의 부분 집합이 이미 정렬이 되어있으므로 순차적으로 비교하면서 두 개의 부분 집합으로 쪼개지기 전 집합에 차곡차곡 자료를 삽입합니다
4. 두 개의 부분 집합을 비교하면서 자료를 삽입하고 남은 나머지는 순차적으로 삽입합니다

## Source Code

구간을 나누는 함수는 아래와 같이 간단하게 재귀적으로 구현할 수 있습니다

```python
def merge_sort(arr, left, right):
    if left < right:
        mid = int((left+right)/2)

        merge_sort(arr, left, mid)
        merge_sort(arr, mid+1, right)
        merge(arr, left, mid, right)
```

이후 병합하는 과정은 두 부분 집합을 순회하며 순차적으로 원래의 배열에 삽입합니다

```python
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
```

전체 소스코드를 작성합니다

```python
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
```

실행해서 결과를 확인합니다

```bash
> python merge_sort.py
[-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
[-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
```

