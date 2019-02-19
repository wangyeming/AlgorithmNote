def max_sub_array(nums):
    cur_sum = 0
    max_sum = 0
    for num in nums:
        if cur_sum > 0:
            cur_sum += num
        else:
            cur_sum = num
        if cur_sum > max_sum:
            max_sum = cur_sum
        print(num, cur_sum, max_sum)
    return max_sum


data = [-1, 3, -2, 6, -5, 6, 9]
print(max_sub_array(data))