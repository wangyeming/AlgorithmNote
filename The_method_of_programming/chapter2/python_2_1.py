def get_topK_minimum(data, k):
    quick_select(data, k, 0, len(data) - 1)
    return data[:k]


# 这里参考了快排的思路，目标就是找到符合条件的主元()
def quick_select(data, k, left, right):
    if left >= right:
        return
    print('quick_select', left, right, data)
    i, j = left, right
    while i < j:
        while i < j and data[i] <= data[j]:
            i += 1
        while i < j and data[j] >= data[i]:
            j -= 1
        print('swap ' + i + '(' + data[i] + ') and ' + 'j' + '(' + data[j] + ')')
        data[i], data[j] = data[j], data[i]

    if k <= i:
        quick_select(data, k, left, i - 1)
    else:
        quick_select(data, k, i, right)


data = [10, 2, 56, 12, 89, 3, 4, 77]
print(get_topK_minimum(data, 3), data)
