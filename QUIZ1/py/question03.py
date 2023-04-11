FEE = 10000
BASIC_DISCOUNT = 8000
SPECIAL_DISCOUNT = 4000

def get_response(question,min,max,flag=True):
    while(True):
        print(question,end="")
        response = input()
        respone = int(respone) if ( flag and int(response) >= min and int(response) < max) else 1 if (flag==False and response in ("y","Y","n","N")) else  -1
        if respone!=-1:
            break
        
    return response

def fee_calculation():
    print("[입장권 계산]")
    age = get_response("나이를 입력해 주세요.(숫자):",0,150)
    entrance_time = get_response("입장시간을 입력해 주세요.(숫자입력):",1,24)
    nation_merit = get_response("국가유공자 여부를 입력해 주세요.(y/n):",0,0,False)
    welfare_merit = get_response("복지카드 여부를 입력해 주세요.(y/n):",0,0,False)
    return 0 if age<3 else SPECIAL_DISCOUNT if (age<13 or entrance_time>=17) else BASIC_DISCOUNT if (nation_merit+welfare_merit>0) else FEE

print("입장료: ",fee_calculation())
