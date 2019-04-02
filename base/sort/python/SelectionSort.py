# 时间复杂度O(n^2),最坏情况O(n^2)，最好情况O(n^2),空间复杂度O(1),稳定
def selection_sort(unsort_nums):
    for i in range(len(unsort_nums)):
        min_index = i
        for j in range(i + 1, len(unsort_nums)):
            if unsort_nums[j] < unsort_nums[min_index]:
                min_index = j
        if min_index != i:
            unsort_nums[i], unsort_nums[min_index] = unsort_nums[min_index], unsort_nums[i]
