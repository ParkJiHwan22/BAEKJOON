# 1700 멀티탭 스케줄링
# 문제
# 기숙사에서 살고 있는 준규는 한 개의 멀티탭을 이용하고 있다. 준규는 키보드, 헤어드라이기, 핸드폰 충전기, 디지털 카메라 충전기 등 여러 개의 전기용품을 사용하면서 
# 어쩔 수 없이 각종 전기용품의 플러그를 뺐다 꽂았다 하는 불편함을 겪고 있다. 그래서 준규는 자신의 생활 패턴을 분석하여, 자기가 사용하고 있는 전기용품의 
# 사용순서를 알아내었고, 이를 기반으로 플러그를 빼는 횟수를 최소화하는 방법을 고안하여 보다 쾌적한 생활환경을 만들려고 한다.

# 예를 들어 3 구(구멍이 세 개 달린) 멀티탭을 쓸 때, 전기용품의 사용 순서가 아래와 같이 주어진다면,

# 키보드
# 헤어드라이기
# 핸드폰 충전기
# 디지털 카메라 충전기
# 키보드
# 헤어드라이기
# 키보드, 헤어드라이기, 핸드폰 충전기의 플러그를 순서대로 멀티탭에 꽂은 다음 디지털 카메라 충전기 플러그를 꽂기 전에 핸드폰충전기 플러그를 빼는 것이 최적일 것이므로 
# 플러그는 한 번만 빼면 된다.

# 입력
# 첫 줄에는 멀티탭 구멍의 개수 N (1 ≤ N ≤ 100)과 전기 용품의 총 사용횟수 K (1 ≤ K ≤ 100)가 정수로 주어진다. 두 번째 줄에는 전기용품의 이름이 K 이하의 자연수로 사용 
# 순서대로 주어진다. 각 줄의 모든 정수 사이는 공백문자로 구분되어 있다.

# 출력
# 하나씩 플러그를 빼는 최소의 횟수를 출력하시오.

from collections import deque

n, k = map(int, input().split())
num_list = list(map(int, input().split()))

cnt = 0
multi_tap = []
queue = deque()
for i in range(k):
    if num_list[i] in multi_tap: # 멀티탭에 같은 전기용품이 꽂혀 있을 때
        continue
    elif len(multi_tap) < n:  # 멀티탭에 구멍이 남아 있을 때
        multi_tap.append(num_list[i])
    
    else: # 멀티탭에 꽉차있고, 전기용품이 안 꽂혀 있을 때
        cnt += 1
        for j in range(i, k):
            if num_list[j] in multi_tap: # 이후 해당 전기용품을 다시 사용할 경우
                queue.appendleft(multi_tap.pop(multi_tap.index(num_list[j]))) # 멀티탭에서 꺼낸 후 순서대로 queue에 더함
            
        if len(queue) == n: # 다음 번에 사용할 전기용품만 꽂혀있는 경우
            queue.popleft() # 가장 마지막에 들어온 제품을 꺼냄
            while queue:
                multi_tap.append(queue.popleft()) # 큐에 있던 전기용품을 멀티탭에 다시 넣음
            multi_tap.append(num_list[i]) # 새로운 전기 용품을 꽂음
        else: # 다음 번에 사용하지 않을 전기용품이 꽂혀있는 경우
            multi_tap.pop() # 멀티탭에 있는 제품 중 순서에 상관없이 1개 꺼냄
            while queue:
                multi_tap.append(queue.popleft()) # 큐에 있던 전기용품을 멀티탭에 다시 넣음
            multi_tap.append(num_list[i]) # 새로운 전기 용품을 꽂음
                
print(cnt)
            
        


# 예제 입력 1 
# 2 7
# 2 3 2 3 1 2 7
# 예제 출력 1 
# 2