# 1300 K번째 수
# 문제
# 세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. 
# B를 오름차순 정렬했을 때, B[k]를 구해보자.

# 배열 A와 B의 인덱스는 1부터 시작한다.

# 입력
# 첫째 줄에 배열의 크기 N이 주어진다. N은 105보다 작거나 같은 자연수이다. 둘째 줄에 k가 주어진다. k는 min(109, N2)보다 작거나 같은 자연수이다.

# 출력
# B[k]를 출력한다.

import sys
import time
start = time.time()

N = int(sys.stdin.readline())
K = int(sys.stdin.readline())
A = []
B = []

for i in range(1, N+1):
    for j in range(i, N+1):
        if i != j:
            B.append(i*j)
            B.append(i*j)
        else:
            B.append(i*j)

B = sorted(B)
print(B[K])


print("time :", time.time() - start)  # 현재시각 - 시작시간 = 실행 시간


# start = 0
# end = N**2

# while start <= end:
#     mid = (start + end) // 2

#     if mid > K:
#         end = mid - 1
#     else:
#         start = mid + 1


        



# 예제 입력 1 
# 3
# 7
# 예제 출력 1 
# 6