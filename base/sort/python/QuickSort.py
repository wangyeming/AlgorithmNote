# 时间复杂度O(nlog2n),最坏情况O(n^2)，最好情况O(nlog2n),空间复杂度O(nlog2n),不稳定
def quick_sort(unsort_nums):
    _quick_sort(unsort_nums, 0, len(unsort_nums) - 1)


def _quick_sort(unsort_nums, left, right):
    if left >= right:
        return
    index = _part_sort(unsort_nums, left, right)
    _quick_sort(unsort_nums, left, index - 1)
    _quick_sort(unsort_nums, index, right)


def _part_sort(unsort_nums, left, right):
    print('----------')
    pivot = unsort_nums[right]
    while left < right:
        while left < right and unsort_nums[left] <= pivot:
            left += 1
        if left < right:
            unsort_nums[left], unsort_nums[right] = unsort_nums[right], unsort_nums[left]
            print('1swap ' + str(left) + '(' + str(unsort_nums[left]) + ') and ' + str(right) + '('
                  + str(unsort_nums[right]) + ') ' + str(unsort_nums))
        while left < right and unsort_nums[right] >= pivot:
            right -= 1
        if left < right:
            unsort_nums[left], unsort_nums[right] = unsort_nums[right], unsort_nums[left]
            print('2swap ' + str(left) + '(' + str(unsort_nums[left]) + ') and ' + str(right) + '('
                  + str(unsort_nums[right]) + ') ' + str(unsort_nums))
    return left
