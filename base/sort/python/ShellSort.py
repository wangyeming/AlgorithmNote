def shell_sort(unsort_nums):
    # 动态步长
    step = 1
    while step < (len(unsort_nums) // 3):
        step = step * 3 + 1
    print('init step', step)
    while step > 0:
        print('step', step)
        for i in range(step, len(unsort_nums)):
            print('i', i)
            while i >= step and unsort_nums[i] < unsort_nums[i - step]:
                print('i', i, 'i - step', i - step)
                unsort_nums[i], unsort_nums[i-step] = unsort_nums[i-step], unsort_nums[i]
                i -= step
        step = step // 3

