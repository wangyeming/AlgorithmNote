def bubble_sort(unsort_nums):
    for i in range(len(unsort_nums) - 1):
        for j in range(0, len(unsort_nums) - i - 1):
            if unsort_nums[j] > unsort_nums[j + 1]:
                unsort_nums[j], unsort_nums[j + 1] = unsort_nums[j + 1], unsort_nums[j]


def selection_sort(unsort_nums):
    for i in range(len(unsort_nums)):
        min_index = i
        for j in range(i + 1, len(unsort_nums)):
            if unsort_nums[j] < unsort_nums[min_index]:
                min_index = j
        if min_index != i:
            unsort_nums[i], unsort_nums[min_index] = unsort_nums[min_index], unsort_nums[i]


def insertion_sort(unsort_nums):
    for i in range(1, len(unsort_nums)):
        pre_index = i - 1
        current = unsort_nums[i]
        while pre_index >= 0 and unsort_nums[pre_index] > current:
            unsort_nums[pre_index + 1] = unsort_nums[pre_index]
            pre_index -= 1
        unsort_nums[pre_index + 1] = current
