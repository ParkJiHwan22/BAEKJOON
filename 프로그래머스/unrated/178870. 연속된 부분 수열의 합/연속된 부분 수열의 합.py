def solution(sequence, k):
    s = 0
    e = 0
    total = 0
    min_num = 1000001
    answer = []

    while e <= len(sequence) and s < len(sequence):
        if e < len(sequence):
            if total < k:
                total += sequence[e]
                e += 1

            elif total == k:
                if min_num > e - s:
                    min_num = e - s
                    answer = [s, e-1]

                total += sequence[e]
                e += 1

            else:
                total -= sequence[s]
                s += 1

        else:
            if total < k:
                e += 1

            elif total == k:
                if min_num > e - s:
                    min_num = e - s
                    answer = [s, e-1]
                e += 1

            else:
                total -= sequence[s]
                s += 1

    return answer