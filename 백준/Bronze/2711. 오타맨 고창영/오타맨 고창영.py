N = int(input())

for i in range(N):
    num, sentence = map(str,input().split())
    num = int(num)
    print(sentence[:num-1],sentence[num:],sep='')