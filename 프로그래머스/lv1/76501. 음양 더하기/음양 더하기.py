def solution(absolutes, signs):
    result = 0
    for i in range(len(absolutes)):
        if signs[i] == 1:
            result += absolutes[i] * 1
    
        else:
            result += absolutes[i] * -1
    
    return result
