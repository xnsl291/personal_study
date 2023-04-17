/*
 * 주제 : 주민등록번호 생성 프로그램
 * 요구사항 : 로직에 맞는 주민등록번호 생성
 * 생년월일(6자리)-성별(1자리)+랜덤번호(6자리)
 *
 * 작성자 : 조하나
 */

import java.util.Scanner;
import java.time.YearMonth;
import java.time.LocalDate;
import java.util.Random;

public class JavaStudy04
{
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();

    public static int get_input(String question , int year)
    {
        String gender = "";
        while(!gender.equalsIgnoreCase("f") && !gender.equalsIgnoreCase("m"))
        {
            System.out.printf(question);
            gender = scan.next();
        }

        int int_gender = (int)(year/2000)>0?3:1;
        int_gender += gender.equalsIgnoreCase("m")?0:1;

        return int_gender;
    }

    public static int get_input(String question,int min, int max)
    {
        int int_input = -1;

        while (int_input < min || int_input > max) {
            System.out.printf(question);
            int_input = scan.nextInt();
        }

        return int_input;
    }

    public static void main(String[] args)
    {
        /*min : 1800, max: 현재년도*/
        int cur_year = YearMonth.now().getYear();
        String year = get_input("출생년도를 입력해주세요.(yyyy):",1900,cur_year)+"";

        /*min : 1, max: 12*/
        int month = get_input("출생월을 입력해주세요.(mm):",1,12);

        /*min : 1, max: 해당 년월의 마지막날*/
        int end_day = YearMonth.from(LocalDate.of(Integer.parseInt(year),month,1)).atEndOfMonth().getDayOfMonth();
        int day = get_input("출생일을 입력해주세요.(dd):",1,end_day);

        int gender = get_input("성별을 입력해 주세요.(m/f):" , Integer.parseInt(year));

        /*yy+mm+dd - 성별+랜덤 6자리 숫자*/
        System.out.printf("%s%02d%02d-%d%06d",year.substring(2,4),month,day,gender,rand.nextInt(1000000));
    }
}