def get_topK_minimum(data, k):
    quick_select(data, k, 0, len(data) - 1)
    return data[:k]


# 这里参考了快排的思路，目标就是找到符合条件的主元()
def quick_select(data, k, left, right):
    if left >= right:
        return
    print('-----quick_select-----', left, right, data[left:right + 1])
    i, j = left, right
    pivot = data[right]
    while i < j:
        while i < j and data[i] <= pivot:
            i += 1
        if i < j:
            data[i], data[j] = data[j], data[i]
            print('swap ' + str(i) + '(' + str(data[i]) + ') and ' + str(j) + '(' + str(data[j]) + ') ' + str(data))
        while i < j and data[j] >= pivot:
            j -= 1
        if i < j:
            data[i], data[j] = data[j], data[i]
            print('swap ' + str(i) + '(' + str(data[i]) + ') and ' + str(j) + '(' + str(data[j]) + ') ' + str(data))

    if k <= i:
        quick_select(data, k, left, i - 1)
    else:
        quick_select(data, k, i, right)


data = [10, 2, 56, 12, 89, 3, 4, 77]
print(get_topK_minimum(data, 3), data)
