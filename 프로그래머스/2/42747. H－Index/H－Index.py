def solution(citations):
    citations.sort(reverse=True)
    answer = 0
    for i, c in enumerate(citations):
        if i < c:
            answer = i + 1
    return answer