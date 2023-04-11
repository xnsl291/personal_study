print("[구구단 출력]")
for i in range(1,10):
    for j in range(1,10):
        print("%02d x %02d = %02d" %(j,i,i*j),end="\t")
    print()