/*
 * 주제 : 놀이동산 입장권 계산 프로그램
 * 요구사항 : 입장료(기본 10000원)는 다음과 같은 우대조건에 따라 다름
 * - 나이, 입장시간, 국가유공자, 복지카드 여부순으로 입력
 * - 3세 미만 무료입장,
 * - 13세 미만 or 17시 이후입장 특별할인(4000),
 * - 복지카드, 국가유공자 일반 할인(8000) 적용
 *
 * 작성자 : 조하나
 */

import java.util.Scanner;

public class JavaStudy03 {
    static Scanner scan = new Scanner(System.in);
    static final int ORIGINAL = 10000;
    static final int BASIC_D = 8000;
    static final int SPECIAL_D = 4000;

    public static void main(String[] args)
    {
        int age=0,entrance=0;
        String nation_merit ="",welfare_merit="";

        while(age<=0)
        {
            System.out.printf("[입장권 계산]\n나이를 입력해 주세요.(숫자):");
            age = scan.nextInt();
        }

        while(entrance<1 || entrance > 24)
        {
            System.out.printf("입장시간을 입력해 주세요.(숫자입력):");
            entrance = scan.nextInt();
        }

        while(!nation_merit.equals("n")&& !nation_merit.equals("y"))
        {
            System.out.printf("국가유공자 여부를 입력해 주세요.(y/n):");
            nation_merit = scan.next();
        }

        while(!welfare_merit.equals("n")&& !welfare_merit.equals("y"))
        {
            System.out.printf("복지카드 여부를 입력해 주세요.(y/n):");
            welfare_merit = scan.next();
        }

        int fee = age<3 ? 0 : (age <13 || entrance>=17) ? SPECIAL_D : (nation_merit=="y" || welfare_merit=="y") ? BASIC_D : ORIGINAL;
        System.out.printf("입장료: %d",fee);
    }

}