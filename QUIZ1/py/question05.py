import calendar
def get_input(question,min,max):
    while(True):
        print(question,end="")
        response = int(input())
        if response >=min and response <= max: 
            return response

def print_cal(year,month):
    print(f"\n[{year}년 {month}월] \n\n일\t월\t화\t수\t목\t금\t토")
    cnt,end_date = calendar.monthrange(year, month)
    print((cnt+1)*"\t",end="")
    for i in range(1,end_date+1):
        print("%02d"%(i),end="\t") if cnt%7!=5 else print("%02d"%(i))
        cnt+=1
    
print("[달력 출력 프로그램]")
year = get_input("달력의 년도를 입력해 주세요.(yyyy):",0,10000)
month = get_input("달력의 월을 입력해 주세요.(mm):",1,12)
print_cal(year,month)

        

    

