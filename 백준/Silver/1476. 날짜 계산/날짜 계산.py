e, s, m = map(int, input().split())
s_num = m_num = 0
s_num += e
m_num += e
res = 0

while True:
    if s_num > 28:
        s_num = s_num % 28
        
    if m_num > 19:
        m_num = m_num % 19
                
    if s_num == s and m_num == m:
        break
    else:
        res += 15
        s_num += 15
        m_num += 15

print(res + e)