def sum_of_number(sum, n):
    list1 = []
    if n <= 0 or sum <= 0:
        return
    if sum == n:
        list1 = list(reversed(list1))
        print(list1)
        print(n)
        list1 = list(reversed(list1))
    list1.insert(0, n)
    sum_of_number(sum - n, n - 1)
    list1.pop(0)
    sum_of_number(sum, n - 1)


sum_of_number(10, 3)
