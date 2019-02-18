def reverse_string(string, start, end):
    # 因为python的str类是不可变的，这里只能模拟字符串被reverse的情况
    if start >= end:
        return string
    str_list = list(string)
    s = start
    e = end
    while start < end:
        tmp = str_list[start]
        str_list[start] = str_list[end]
        str_list[end] = tmp
        start += 1
        end -= 1
    return ''.join(str_list)


def reverse_words(string):
    word_start = -1
    new_string = string
    for idx in range(len(string)):
        if idx == len(string) - 1:
            if word_start != -1:
                new_string = reverse_string(new_string, word_start, idx)
                break
        s = new_string[idx]
        if s is ' ':
            if word_start == -1:
                continue
            new_string = reverse_string(new_string, word_start, idx - 1)
            word_start = -1
        else:
            if word_start == -1:
                word_start = idx
    return new_string


string = 'I am a student.'
reverse_words_string = reverse_words(string)
print(reverse_string(reverse_words_string, 0, len(reverse_words_string) - 1))
