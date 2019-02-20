def max_product(array):
    max_end = array[0]
    min_end = array[0]
    max_result = array[0]

    for i in range(1, len(array)):
        print(max_end, min_end, max_result)
        end1 = max_end * array[i]
        end2 = min_end * array[i]
        max_end = max(max(end1, end2), array[i])
        min_end = min(min(end1, end2), array[i])
        max_result = max(max_result, max_end)

    return max_result


data = [-2.5, 4, 0, 3, 0.5, 8, -1]
print(max_product(data))
