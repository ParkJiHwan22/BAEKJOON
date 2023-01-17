N = int(input())
num_list = [int(input()) for i in range(N)]
print(*sorted(num_list), sep='\n')
