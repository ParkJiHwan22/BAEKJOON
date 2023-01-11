# 소수
# 문제
# 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.

# 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 
# 이들 소수의 합은 620이고, 최솟값은 61이 된다.

# 입력
# 입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.

# M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.

# 출력
# M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다. 

# 단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.

M = int(input())
N = int(input())
lst = []


for i in range(M, N+1): # 자연수 M부터 N까지 출력
    cnt = 0 # cnt를 초기화 시켜줌
    if i == 1: # 1일 때는 특수하므로 따로 소수가 아니라고 표시
        cnt +=1
    elif i == 2: # 2일 때는 소수라고 표시
        True

    for j in range(2, i): # j를 2부터 i-1까지 반복
        if i % j == 0: # 소수는 1과 자기 자신을 제외한 모든 수로 나누어지지 않는다. 
            cnt += 1 # 나누어졌을 경우 
        
    if cnt == 0: # 1과 자기 자신을 제외한 모든 수로 나누어지지 않았을 경우
        lst.append(i) # 리스트에 추가

if lst == []: # 리스트가 비어있을 때, 소수가 없다는 뜻
    print(-1)
else:
    print(sum(lst), min(lst), sep='\n')





# 예제 입력 1 
# 60
# 100
# 예제 출력 1 
# 620
# 61

# 예제 입력 2 
# 64
# 65
# 예제 출력 2 
# -1