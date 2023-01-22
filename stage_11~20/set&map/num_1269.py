# 1269 대칭 차집합
# 문제
# 자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다. 이때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 
# 작성하시오. 두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.

# 예를 들어, A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때,  A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로, 
# 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.

# 입력
# 첫째 줄에 집합 A의 원소의 개수와 집합 B의 원소의 개수가 빈 칸을 사이에 두고 주어진다. 둘째 줄에는 집합 A의 모든 원소가, 
# 셋째 줄에는 집합 B의 모든 원소가 빈 칸을 사이에 두고 각각 주어진다. 각 집합의 원소의 개수는 200,000을 넘지 않으며, 
# 모든 원소의 값은 100,000,000을 넘지 않는다.

# 출력
# 첫째 줄에 대칭 차집합의 원소의 개수를 출력한다.

# A, B = map(int, input().split())
# A_list = list(map(int, input().split()))
# B_list = list(map(int, input().split()))
# A_dict = {}
# B_dict = {}

# for i in A_list:
#     A_dict[i] = 0

# for i in B_list:
#     B_dict[i] = 0

# cnt_A = 0
# for i in A_list:
#     if i not in B_dict:
#         cnt_A += 1

# cnt_B = 0
# for i in B_list:
#     if i not in A_dict:
#         cnt_B += 1

# print(cnt_A + cnt_B)

#----------------------------------------
n, m = map(int, input().split())
A = set(map(int, input().split())) # 중복 제거
B = set(map(int, input().split()))

print(len(A-B)+len(B-A))  # set의 연산은 A-B로 해도 되나보다



# 예제 입력 1 
# 3 5
# 1 2 4
# 2 3 4 5 6

# 예제 출력 1 
# 4