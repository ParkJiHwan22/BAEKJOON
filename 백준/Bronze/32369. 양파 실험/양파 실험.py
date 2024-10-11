N, A, B = map(int, input().split())

praise_length = 1
blame_length = 1

for _ in range(N):
    praise_length += A
    blame_length += B

    if blame_length > praise_length:
        praise_length, blame_length = blame_length, praise_length

    elif blame_length == praise_length:
        blame_length -= 1

print(praise_length, blame_length)