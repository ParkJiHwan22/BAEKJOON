import datetime

def calculate_live_day(year, month, day):
    input_day = datetime.datetime(year=year, month=month, day=day)
    std_day = datetime.datetime(year=year, month=1, day=1)
    
    datetime_info = input_day - std_day
    
    return datetime_info.days + 1

if __name__ == "__main__":
    while True:
        day, month, year = map(int, input().split())
        
        if day == 0 and month ==0 and year == 0:
            break
        print(calculate_live_day(year, month, day))