def is_brother_str(str1, str2):
    if len(str1) != len(str2):
        return False
    map = {}
    for s in str1:
        if map.__contains__(s):
            map[s] += 1
        else:
            map[s] = 1
    for s in str2:
        if not map.__contains__(s):
            return False
        map[s] -= 1
        if map[s] == -1:
            return False
    return True


str1 = 'ABCB'
str2 = 'BADB'

print(is_brother_str(str1, str2))
