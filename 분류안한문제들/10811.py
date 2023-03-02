n, m = map(int, input().split())
box = [_ for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    box = box[0:a]+box[b:a-1:-1]+box[b+1:]

print(*box[1:])
    