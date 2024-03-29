def solution(sequence, k):
    s = 0 # start
    e = 0 # end
    total = 0 # 총합
    min_length = 1000001 # sequence의 길이의 최댓값 +1
    answer = [] # 결과

    while  s < len(sequence) and e <= len(sequence):
        if total < k: # total < k 일 때, e를 증가시킴, 범위 확대(total 증가)
            if e != len(sequence):          
                total += sequence[e]
            e += 1

        elif total == k: # total == k 일 때, e를 증가시킴, 범위 확대(total 증가)
            if min_length > e - s: # 길이가 짧은 수열을 찾기
                min_length = e - s # 가장 짧을 경우 min_length에 저장하고 
                answer = [s, e-1] # res에 [s, e-1] 저장

            if e != len(sequence):          
                total += sequence[e]
            e += 1

        else: # total > k 일 때, s를 증가시킴, 범위 축소(total 감소)
            total -= sequence[s]
            s += 1

    return answer