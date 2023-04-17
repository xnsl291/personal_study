/*
* 주제 : 연소득 과세금액 계산
* 요구사항 : 2022년 소득세율표에 의거, 세금계산
*
* 작성자 : 조하나
*/

import java.util.Scanner;

public class JavaStudy08
{
    static Scanner scan = new Scanner(System.in);
    static final int omitted = 10000;
    static final long[] income_condition = {1200,3400,4200,6200,15000,20000,50000};
    static final double[] tax_ratio = {6,15,24,35,38,40,42,45};

    public static void main(String[] args)
    {
        int income = -1;
        long ratio_cal = 0; // 세율에 의한 세금
        long deduction_cal = 0; // 누진공제에 의한 세금
        int tax=0, i = 0;
        while(income<0)
        {
            System.out.printf("[과세금액 계산 프로그램]\n연소득을 입력해 주세요.:");
            income = scan.nextInt();
        }
        long income_cpy = income;
        income /= omitted;


        /*세율 계산*/
        while(income - income_condition[i] >0)
        {
            tax = (int) ((tax_ratio[i]/100) * income_condition[i]) * omitted;
            ratio_cal+= tax;
            System.out.printf("%8d * %2.0f%% = %10d \n", income_condition[i]*omitted, tax_ratio[i], tax);
            income -= (income_condition[i]);
            i++;
        }
        tax= (int)(income *(tax_ratio[i]/100) * omitted);
        System.out.printf("%8d * %2.0f%% = %10d \n", income*omitted, tax_ratio[i] , tax);
        ratio_cal+= tax;


        /*누진공제 계산*/
        long deduction = 0;
        for (int j =i; j>0; j--)
            deduction+=income_condition[j-1]*((tax_ratio[i]-tax_ratio[j-1])*0.01);
        deduction_cal = (long)(income_cpy*(tax_ratio[i]*0.01)) -deduction*omitted;

        System.out.printf("\n[세율에 의한 세금]:\t\t%10d\n",ratio_cal);
        System.out.printf("[누진공제 계산에 의한 세금]:%10d\n",deduction_cal);


    }
}
