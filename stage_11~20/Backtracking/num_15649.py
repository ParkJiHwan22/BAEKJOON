# 15649 N과 M (1)
# 문제
# 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

# 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
# 입력
# 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

# 출력
# 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 
# 구분해서 출력해야 한다.

# 수열은 사전 순으로 증가하는 순서로 출력해야 한다.

# from itertools import permutations

# n, m = map(int, input().split())
# num_list = [i for i in range(1, n+1)]

# permu = list(permutations(num_list,m))

# for i in range(len(permu)):
#     print(*permu[i])

#---------------------------------------------

n, m = map(int, input().split())
s = []

def dfs():
    if len(s) == m: # 숫자가 2개가 됐을 때
        print(' '.join(map(str, s))) # 두 문자를 붙여서 출력
        return

    for i in range(1, n+1):
        if i in s: # i가 s안에 있으면 다시 돌아감
            continue
        s.append(i) # i를 s안에 넣어줌
        dfs()
        s.pop() # 뒤에 수를 하나 뺌
dfs()


# 예제 입력 1 
# 3 1
# 예제 출력 1 
# 1
# 2
# 3

# 예제 입력 2 
# 4 2
# 예제 출력 2 
# 1 2
# 1 3
# 1 4
# 2 1
# 2 3
# 2 4
# 3 1
# 3 2
# 3 4
# 4 1
# 4 2
# 4 3

# 예제 입력 3 
# 4 4
# 예제 출력 3 
# 1 2 3 4
# 1 2 4 3
# 1 3 2 4
# 1 3 4 2
# 1 4 2 3
# 1 4 3 2
# 2 1 3 4
# 2 1 4 3
# 2 3 1 4
# 2 3 4 1
# 2 4 1 3
# 2 4 3 1
# 3 1 2 4
# 3 1 4 2
# 3 2 1 4
# 3 2 4 1
# 3 4 1 2
# 3 4 2 1
# 4 1 2 3
# 4 1 3 2
# 4 2 1 3
# 4 2 3 1
# 4 3 1 2
# 4 3 2 1