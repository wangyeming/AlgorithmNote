def binarySearch(array, value):
    left = 0
    right = len(array) - 1
    while left <= right:
        middle = left + (right - left) // 2
        if array[middle] > value:
            right = middle - 1
        elif array[middle] < value:
            left = middle + 1
        else:
            return middle
    return -1


data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]

print(binarySearch(data, 10))
