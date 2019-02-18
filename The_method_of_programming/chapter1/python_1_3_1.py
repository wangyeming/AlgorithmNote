def get_str_all_arrangement(str1):
    map = {

    }
    for s in str1:
        map[s] = 1
    results = []
    length = 0
    while length < len(str1):
        new_results = []
        for key, value in map.items():
            if length > 0:
                for result in results:
                    new_results.append(result + key)
            else:
                new_results.append(key)
        length += 1
        results = new_results
    return results


str = 'ABCB'
results = get_str_all_arrangement(str)
print(len(results), results)
