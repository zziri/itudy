package binarySearch.ex3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void sol()
	{
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 떡 갯수
        int m = sc.nextInt(); // 요청 떡 길이

        // 각 떡의 개별 높이 정보 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 높이 범위 기반으로 이진 탐색을 위한 시작점과 끝점 설정
        int start = 0;
        int end = (int) 1e9; // 높이 최대 값: 1,000,000,000
        
        int result = 0; 
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            
            // 이진 탐색으로 선정한 높이 값으로 짤랐을때 남은 떡의 길이 구하기
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) 
                	total += arr[i] - mid; 
            }
      
            if (total < m) // 남은 떡의 양이 부족한 경우 절단기 높이 낮춰 더 많이 자르기(왼쪽 부분 탐색)  
                end = mid - 1;
            else // 떡의 양이 충분한 경우 절단기 높이 높혀 덜 자르기(오른쪽 부분 탐색)
            { 
                result = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록 
                start = mid + 1;
            }
        }

        System.out.println(result);
	}
	
	public static void main(String[] args) {
		sol();

	}

}
