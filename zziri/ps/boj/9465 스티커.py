
def main():
    tc = int(input())
    for _ in range(tc):
        # input
        n = int(input())
        dp = [[0]*(n+1), [0]*(n+1)]
        for i in range(2):
            temp = list(map(int, input().split()))
            for j in range(n):
                dp[i][j+1] = temp[j]
        
        # solve
        for i in range(2, n+1):
            dp[0][i] += max(dp[1][i-2], dp[1][i-1])
            dp[1][i] += max(dp[0][i-2], dp[0][i-1])
        
        print(max(dp[0][n], dp[1][n]))



if __name__ == "__main__":
    main()