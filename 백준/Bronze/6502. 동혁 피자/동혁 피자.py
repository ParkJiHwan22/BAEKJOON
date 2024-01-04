number = 1

while True :
  value = input()
  if value == '0' :
    break
  else :
    r, w, l = map(int, value.split())

    table = r * 2
    pizza = (w**2 + l**2) ** 0.5

    if table >= pizza :
      print(f"Pizza {number} fits on the table.")
    else :
      print(f"Pizza {number} does not fit on the table.")
    
    number += 1