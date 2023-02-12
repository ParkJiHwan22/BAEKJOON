# 2231 분해합
# 문제
# 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 
# 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 
# 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.

# 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

# 입력
# 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

# 출력
# 첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.

# n = input()
# num = int(n)
# num_list = []

# if len(n) <= 3:
#     for i in range(num):
#         i_sum = 0
#         for j in str(i):
#             i_sum += int(j)
#         if num == int(i) + i_sum:
#             num_list.append(i)
            
    
# if len(n) > 3:
#     for i in range(num-100, num):
#         i_sum = 0
#         for j in str(i):
#             i_sum += int(j)
#         if num == int(i) + i_sum:
#             num_list.append(i)

# if num_list == []:
#     print(0)
        
# else:
#     print(num_list[0])

# ------------------------------------------------------------------------

# N = int(input())
# result = 0 
# for i in range(1, N+1):
#     num_list = list(map(int, str(i))) # [3, 3]의 형태로 저장
#     print(num_list)
#     result = i + sum(num_list)
#     if result == N:
#         print(i)
#         break

#     if i == N:
#         print(0)

#=====================================================================

N = int(input())

if N <= 100: # 풀이 시간을 줄이기 위해서 100을 기준으로 나누었음
             # 각 자리 숫자의 합이 아무리 커도 100을 넘지않으므로
    for num in range(1, N + 1): # 1부터 N까지 반복
        cnt = 0
        for i in str(num): # 각 자리 숫자를 cnt에 더함
            cnt += int(i)

        if num + cnt == N: # num이 생성자인지 판단
            print(num)
            break

        elif num == N: # 생성자가 없는 경우 0을 출력
            print(0)

else:
    for num in range(N - 100, N + 1):  # N - 100부터 N까지 반복
        cnt = 0
        for i in str(num):
            cnt += int(i)
        
        if num + cnt == N: # num이 생성자인지 판단
            print(num)
            break

        elif num == N: # 생성자가 없는 경우 0을 출력
            print(0)

# 예제 입력 1 
# 216
# 예제 출력 1 
# 198