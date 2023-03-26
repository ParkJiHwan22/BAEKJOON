import sys

score_dict = {'A+': 4.5, 'A0': 4.0, 'B+': 3.5, 'B0': 3.0, 'C+': 2.5, 'C0': 2.0, 'D+':	1.5, 'D0': 1.0, 'F': 0.0}
credit_dict = {'1.0': 1, '2.0': 2, '3.0': 3, '4.0': 4}
gpa, credit= 0, 0
for _ in range(20):
    score = list(sys.stdin.readline().split())
    if score[2] != 'P':
        gpa += credit_dict[score[1]] * score_dict[score[2]]
        credit += credit_dict[score[1]]
    
print(gpa/credit)