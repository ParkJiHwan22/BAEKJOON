# 18870 좌표 압축
# 문제
# 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

# Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.

# X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

# 입력
# 첫째 줄에 N이 주어진다.

# 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

# 출력
# 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

# 제한
# 1 ≤ N ≤ 1,000,000
# -109 ≤ Xi ≤ 109

import sys

n = int(sys.stdin.readline())
num_list = list(map(int, sys.stdin.readline().split()))

tmp_lst = sorted(list(set(num_list))) # 같은 값 없애고 리스트로 바꾼 다음 정렬, 여기가 핵심!!
tmp_dict = {}

for i in range(len(tmp_lst)): # range에 len(tmp_lst)를 돌린다
    tmp_dict[tmp_lst[i]] = i

for j in num_list:
    print(tmp_dict[j], end=' ')

    
# ----------------------------------------------------------------

# import sys

# input = sys.stdin.readline

# n = int(input())
# arr = list(map(int, input().split()))

# arr2 = sorted(list(set(arr)))
# dic = {arr2[i] : i for i in range(len(arr2))}
# for i in arr:
#     print(dic[i], end = ' ')

# 예제 입력 1 
# 5
# 2 4 -10 4 -9
# 예제 출력 1 
# 2 3 0 3 1

# 예제 입력 2 
# 6
# 1000 999 1000 999 1000 999
# 예제 출력 2 
# 1 0 1 0 1 0