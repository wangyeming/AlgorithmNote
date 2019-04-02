# 时间复杂度O(n^2),最坏情况O(n^2)，最好情况O(n),空间复杂度O(1),不稳定
def insertion_sort(unsort_nums):
    for i in range(1, len(unsort_nums)):
        # 待排序的元素前一个元素的index
        pre_index = i - 1
        current = unsort_nums[i]
        while pre_index >= 0 and unsort_nums[pre_index] > current:
            # 元素向后移动一位
            unsort_nums[pre_index + 1] = unsort_nums[pre_index]
            pre_index -= 1
        # 找到插入的index后，将值插入进去
        unsort_nums[pre_index + 1] = current