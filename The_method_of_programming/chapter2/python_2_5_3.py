coin = [1, 2, 5, 10]
money = 100


def coin_exchange(sum):
    results = [1] + [0] * sum
    for i in range(len(coin)):
        for j in range(coin[i], sum+1, 1):
            results[j] += results[j - coin[i]]
            print(i, j, j - coin[i], results[j])
    return results


print(coin_exchange(20))
