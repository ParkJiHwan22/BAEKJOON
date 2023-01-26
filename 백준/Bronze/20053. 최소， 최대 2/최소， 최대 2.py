T = int(input())

for i in range(T):
    n = int(input())
    num_list = list(map(int, input().split()))
    print(min(num_list), max(num_list))