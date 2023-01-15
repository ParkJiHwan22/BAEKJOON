lst = []
x, y, w, h = map(int, input().split())
lst.append(x)
lst.append(y)
lst.append(h-y)
lst.append(w-x)

print(min(lst))