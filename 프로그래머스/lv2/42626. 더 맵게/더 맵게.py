import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while True:
        t = heapq.heappop(scoville)
        if t < K:
            if len(scoville) == 0:
                return -1
            else:
                heapq.heappush(scoville, t + heapq.heappop(scoville)*2)
                answer += 1
        else:
            heapq.heappush(scoville, t)
            return answer