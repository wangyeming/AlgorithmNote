coin = [1, 2, 5, 10]
money = 100


def coin_exchange(sum, coin_type_count):
    if sum == 0:
        return 1
    if sum < 0 or coin_type_count == 0:
        return 0
    # n元，m种面值的兑换方式数 = (假设第m种面值为k) n元，(m-1)种面值 + (n - k)元, m种面值
    return coin_exchange(sum, coin_type_count - 1) + coin_exchange(sum - coin[coin_type_count - 1], coin_type_count)

# def coin_exchange2(sum, coin_type_count):


print(coin_exchange(100, len(coin)))
for i in range(1, 20):
    print(i, coin_exchange(i, len(coin)))
