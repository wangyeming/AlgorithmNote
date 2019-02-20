def sort_odd_even(nums):
    left, right = 0, len(nums) - 1
    while left < right:
        while nums[left] % 2 == 1:
            left += 1
        while nums[right] % 2 == 0:
            right -= 1
        nums[left], nums[right] = nums[right], nums[left]


data = [1, 2, 3, 4, 5, 6, 7, 8, 9]
sort_odd_even(data)
print(data)
