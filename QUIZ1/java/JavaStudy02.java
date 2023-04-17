/*
* 주제 : 결제 금액 캐시백 계산 프로그램
* 요구사항 : 결제 금액의 10% 캐시백, 100원단위, 최대 300원 적립
* 작성자 : 조하나
*/

import java.util.Scanner;
public class JavaStudy02 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            System.out.printf("[캐시백 계산]\n결제 금액을 입력해 주세요.(금액):");
            int amount = scan.nextInt();

            /*음수 입력 방지*/
            if (amount>=0)
            {
                int point = (amount*0.1) >300 ? 300 : (int)(amount*0.001)*100;
                System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.",amount,point);
                break;
            }
        }
    }
}