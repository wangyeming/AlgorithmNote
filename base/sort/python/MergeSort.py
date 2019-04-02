# 时间复杂度O(nlog2n),最坏情况O(nlog2n)，最好情况O(nlog2n),空间复杂度O(n), 稳定
def merge_sort(unsort_nums):
    sort_nums = _merge_sort(unsort_nums)
    for idx, num in enumerate(unsort_nums):
        unsort_nums[idx] = sort_nums[idx]


def _merge_sort(unsort_nums):
    if len(unsort_nums) < 2:
        return unsort_nums
    mid = len(unsort_nums) // 2
    left_nums = unsort_nums[:mid]
    right_nums = unsort_nums[mid:]
    return _merge(_merge_sort(left_nums), _merge_sort(right_nums))


def _merge(left, right):
    result = []
    while left and right:
        if left[0] <= right[0]:
            result.append(left.pop(0))
        else:
            result.append(right.pop(0))

    if left:
        result.extend(left)
    if right:
        result.extend(right)
    return result
