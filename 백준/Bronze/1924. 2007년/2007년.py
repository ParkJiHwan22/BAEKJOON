a, b = map(int, input().split())

day_dic = {
    1: 'MON',
    2: 'TUE',
    3: 'WED',
    4: 'THU',
    5: 'FRI',
    6: 'SAT',
    0: 'SUN'
}

month_dic = {
    1: 0,
    2: 3,
    3: 3,
    4: 6,
    5: 1,
    6: 4,
    7: 6,
    8: 2,
    9: 5,
    10: 0,
    11: 3,
    12: 5
}

print(day_dic[(month_dic[a] + b) % 7])