while True:
    n = int(input())
    if n == 0:
        break
    else:
        word_dict = {}
        word = [input() for _ in range(n)]

        for i in range(len(word)):
            word_dict[word[i].lower()] = word[i]

        res = sorted(word_dict.items())
        print(res[0][1])