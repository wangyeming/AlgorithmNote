def twoSum(nums, target):
    results = []
    begin, end = 0, len(nums) - 1
    while begin < end:
        if nums[begin] + nums[end] == target:
            results.append(nums[begin])
            results.append(nums[end])
            break
        elif nums[begin] + nums[end] > target:
            end -= 1
        else:
            begin += 1
    return results


data = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(twoSum(data, 16))
