import sys

n, m = map(int, sys.stdin.readline().split())
page = set(map(int, sys.stdin.readline().split()))
need_page = []

for i in range(1, n+1):
    if i not in page:
        need_page.append(i)

if len(need_page) == 0:
    print(0)
else:
    ink = 7
    for j in range(len(need_page) - 1):
        if need_page[j] + 3 >= need_page[j+1]:
            ink += (need_page[j+1] - need_page[j]) * 2
        else:
            ink += 7

    print(ink)
