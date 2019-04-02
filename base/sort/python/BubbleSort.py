# 时间复杂度O(n^2),最坏情况O(n^2)，最好情况O(n),空间复杂度O(1),稳定
def bubble_sort(unsort_nums):
    for i in range(len(unsort_nums) - 1):
        for j in range(len(unsort_nums) - i - 1):
            print(i, j+1)
            if unsort_nums[j] > unsort_nums[j + 1]:
                unsort_nums[j], unsort_nums[j + 1] = unsort_nums[j + 1], unsort_nums[j]