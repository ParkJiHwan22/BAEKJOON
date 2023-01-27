N = int(input())

words_list = [input() for i in range(N)]
words_dict = {}

for i in words_list:
   words_dict[i] = len(i)

words_items = list(words_dict.items())
words_items = sorted(words_items)
words_items = sorted(words_items, key = lambda x:x[1])

for i in range(len(words_items)):
    print(words_items[i][0])
