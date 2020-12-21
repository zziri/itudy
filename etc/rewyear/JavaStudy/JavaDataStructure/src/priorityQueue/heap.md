# 우선순위 큐
우선순위를 가진 항목들을 저장하는 큐로서 일반적인 큐처럼 FIFO 구조가 아니라, 우선 순위가 높은 데이터가 먼저 나가게 됨

**히프(heap)**를 이용하여 구현
* 히프: 노드의 키의 중복을 허용하고    
		1) 최대 히프: 부모 노드의 키 값이 자식노드의 키 값보다 크거가 같은 완전 이진트리    
	2) 최소 히프: 부모 노드의 키 값이 자식노드의 키 값보다 작거가 같은 완전 이진트리	



**배열을 통해  구현**함으로서 부모 노드와 자식 노드간의 인덱스 계산이 쉬움    
	1) 부모 노드의 인덱스가 i일때
		* left자식노드 인덱스: 2i 
		* right자식노드: 2i + 1
	2) 노드 i의 부모 인덱스: i/2의 내림연산



## 히프에서의 삽입

1) 히프에 새로운 요소가 들어온다면 새로운 노드를 가장 마지막 노드에 이어서 삽입 후, 2) 이후 새로운 노드를 부모 노드들과 비교를 진행해가면서 적절한 위치에 삽입하여 히프의 성질을 만족시킴



## 히프에서의 삭제
1) 루트 노드를 삭제하고 2) 마지막 노드를 루트 노드로 이동한 후 3) 최대 단말 노드까지 비교해 나아가면서 적절한 위치에 삽입



## 히프 정렬
히프를 이용하여 정렬을 진행할 수 있는데, 정렬해야 하는 n개의 요소들을 히프에 삽입한 뒤 다시 삭제연산을 통해 꺼내오는 방식으로 정렬을 진행할 수 있다.



## 히프 시간복잡도

삽입, 삭제 연산의 경우 최악의 경우 트리의 높이만큼 진행하므로 **O(logn)**
