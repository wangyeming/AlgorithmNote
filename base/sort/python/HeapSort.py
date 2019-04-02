# 堆排序 时间复杂度O(nlog2n) 最坏情况O(nlog2n) 空间复杂度O(1) 不稳定
def heap_sort(unsort_nums):
    # 最后一个非叶子节点(假设为k，则2k+1=len(n)-1或2k+2=len(n)-1)
    last_non_leaf_node = (len(unsort_nums) - 2) // 2
    for i in range(last_non_leaf_node, -1, -1):
        print('--------heap_sort----------', i)
        # 从最后一个非叶子节点往前，挨个保证非叶子节点的值比叶子节点的大
        heap_adjust(unsort_nums, i, len(unsort_nums) - 1)

    # 此时堆的根节点是最大值
    for i in range(len(unsort_nums) - 1, 0, -1):
        # 交换堆顶元素和最后一个元素，最后一个元素排好了
        unsort_nums[0], unsort_nums[i] = unsort_nums[i], unsort_nums[0]
        print('\n***************')
        print('0 to ' + str(i), unsort_nums)
        print('***************\n')

        # 这里除了根节点以外，其它非叶子节点已经在上一轮调整过了，所以只需要调整第0个
        heap_adjust(unsort_nums, 0, i - 1)


# start必须是当前树结构中，最后一个没有保证比叶子节点要大的节点的index
def heap_adjust(unsort_nums, start, end):
    print('heap_adjust', start, end)
    if start >= end:
        return
    current = start
    left = 2 * current + 1
    right = left + 1

    if left > end:
        return
    if left <= end:
        if unsort_nums[current] < unsort_nums[left]:
            current = left
    if right <= end:
        if unsort_nums[current] < unsort_nums[right]:
            current = right

    if start != current:
        print('swap index', start, current, 'value', unsort_nums[start], unsort_nums[current])
        unsort_nums[start], unsort_nums[current] = unsort_nums[current], unsort_nums[start]
        print(data)
        heap_adjust(unsort_nums, current, end)


#               1
#       2               3
#   4      5       6       7
# 8
data = [1, 2, 3, 4, 5, 6, 7, 8]
heap_sort(data)
print(data)
