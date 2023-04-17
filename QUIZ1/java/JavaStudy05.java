/*
* 주제 : 달력 출력 프로그램
* 요구사항 : 입력받은 year & month의 달력 출력
* 작성자 : 조하나
*/

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class JavaStudy05
{
    static Scanner scan = new Scanner(System.in);

    public static void print_cal(int year, int month)
    {
        int dayOfWeek = LocalDate.of(year,month,1).getDayOfWeek().getValue(); //요일
        int end_day = YearMonth.from(LocalDate.of(year,month,1)).atEndOfMonth().getDayOfMonth(); //마지막날
        int cnt = dayOfWeek;

        System.out.printf("[%d년 %02d월]\n",year,month);
        System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
        if (cnt > 6)
            cnt = 0;
        else
            for (int week = 0; week < dayOfWeek; week++)
                System.out.printf("\t");

        for (int day = 1; day < end_day+1; day++)
        {
            if (cnt == 7)
            {
                cnt = 0;
                System.out.printf("\n");
            }
            System.out.printf("%02d\t", day);
            cnt++;
        }
    }

    public static void main(String[] args)
    {
        int month = -1;
        System.out.printf("[달력 출력 프로그램]\n달력의 년도를 입력해 주세요.(yyyy):");
        int year = scan.nextInt();

        while(month<1||month>12)
        {
            System.out.printf("달력의 월을 입력해 주세요.(mm):");
            month = scan.nextInt();
        }

        print_cal(year,month);
    }
}
