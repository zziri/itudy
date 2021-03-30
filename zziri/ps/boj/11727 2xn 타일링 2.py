def main():
    dp = [0]*1001

    dp[1], dp[2], dp[3] = 1, 3, 5
    
    n = int(input())
    
    for i in range(4, n+1):
        dp[i] = dp[i-1] + dp[i-2]*2
    
    print(dp[n]%10007)


if __name__ == "__main__":
    main()
