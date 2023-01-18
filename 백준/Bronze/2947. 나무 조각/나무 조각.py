seq = list(map(int, input().split()))

while True:
    for i in range(4):
        if seq[i] > seq[i+1]:
            seq[i], seq[i+1] = seq[i+1], seq[i]
            print(*seq)
    if seq == [1, 2, 3, 4, 5]:
        break