def fibonacci(n):
    if n == 1:
        return 1
    if n == 2:
        return 2
    return fibonacci(n - 1) + fibonacci(n - 2)


print(fibonacci(5))


def fibonacci2(n):
    dp = [1, 1, 0]
    if n < 2:
        return 1
    for i in range(n - 1):
        dp[2] = dp[0] + dp[1]
        dp[0] = dp[1]
        dp[1] = dp[2]
    return dp[2]


for i in range(1, 20):
    print(fibonacci2(i))
