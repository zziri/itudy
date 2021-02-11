def main():
    n = int(input())

    limit = int(1e6)
    
    dp = [limit]*int((limit+1))

    dp[0], dp[1], dp[2], dp[3] = 0, 0, 1, 1
    
    for i in range(4, n+1):
        if i%2 == 0:
            dp[i] = min(dp[i], dp[int(i/2)] + 1)
        if i%3 == 0:
            dp[i] = min(dp[i], dp[int(i/3)] + 1)
        dp[i] = min(dp[i], dp[i-1] + 1)
            
    print(dp[n])


if __name__ == "__main__":
    main()
