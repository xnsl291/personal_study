print("[캐시백 계산]")
print("결제 금액을 입력해 주세요.(금액):",end="")
price = int(input())
point = int(price/10000)*100 if price<=30000 else 300
print(f"결제 금액은 {price}원이고, 캐시백은 {point}원 입니다.")
