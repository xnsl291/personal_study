# import time
import datetime
import calendar
import random
def convert_gender(gender ,year):
    score =0
    score +=1 if year<2000 else 3
    score += 1 if gender in("F","f") else 0
    return score

def get_input(question, flag=0,min=0, max=0):
    while(True):
        print(question,end="")
        response = input()
        
        if (flag and response in ("f","F","m","M")):
            return convert_gender(response,min)
        
        elif(flag==0):
            response = int(response)
            if (response>=min and response <= max):
                return response
    
year = get_input("출생년도를 입력해 주세요.(yyyy):",0,1800, datetime.datetime.now().year) # = int(time.ctime()[-4:])
month = get_input("출생월을 입력해 주세요.(mm):",0,1,12)
day = get_input("출생일을 입력해 주세요.(dd):",0,1, calendar.monthrange(year, month)[1])
gender = get_input("성별을 입력해 주세요.(m/f):",1,year)
print(f"%s%02d%02d-%d%d"%(str(year)[2:],month,day,gender,random.randint(100000, 1000000)))
