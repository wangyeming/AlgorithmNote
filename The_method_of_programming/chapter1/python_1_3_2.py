def get_str_all_combination(str1):
    map = {}
    # 去重
    for s in str1:
        map[s] = 0
    results = []
    # 2^n-1个的二进制表示组合，位1表示有该字符，位0表示没有
    n = 1 << len(map.items())
    for i in range(n):
        # 第i次表示，将i展示为二进制，如010，表示，第二个和第四个字母是存在的，其它字母不存在
        result = ''
        for index, s in enumerate(str1):
            # 比如说index = 0，s = 'A'的时候，i=101，那就表示A是存在的。下次循环index = 1，s = 'B'不存在
            if (i & (1 << index)) != 0:
                result += s
        if result:
            results.append(result)
    return results


str = 'ABC'
results = get_str_all_combination(str)
print(len(results), results)
