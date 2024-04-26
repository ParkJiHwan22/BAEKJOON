N = int(input())
A, B, C = map(int, input().split())

def max_satisfied_soldiers(N, A, B, C):
    satisfied_fried = min(N, A)
    satisfied_soy = min(N, B)
    satisfied_spicy = min(N, C)

    total_satisfied = satisfied_fried + satisfied_soy + satisfied_spicy
    return total_satisfied

result = max_satisfied_soldiers(N, A, B, C)
print(result)