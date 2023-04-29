s, k, h = map(int, input().split())

univ_lst = {s: 'Soongsil', k: 'Korea', h: 'Hanyang'}
if sum(univ_lst) >= 100:
    print('OK')
else:
    print(univ_lst[min(univ_lst)])