T = int(input())
for i in range(T):
    sentence = list(input().split())
    ecnetnes = [i[::-1] for i in sentence]
    print(*ecnetnes)