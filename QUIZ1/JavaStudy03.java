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
        System.out.printf("[입장권 계산]\n나이를 입력해 주세요.(숫자):");
        int age = scan.nextInt();

        System.out.printf("입장시간을 입력해 주세요.(숫자입력):");
        int entrance = scan.nextInt();
        /*시간 범위 외 입력시 continue */

        System.out.printf("국가유공자 여부를 입력해 주세요.(y/n):");
        String merit1 = scan.next();

        System.out.printf("복지카드 여부를 입력해 주세요.(y/n):");
        String merit2 = scan.next();

        int fee = age<3 ? 0 : (age <13 || entrance>=17) ? SPECIAL_D : (merit1=="y"||merit1=="Y" || merit2=="y"||merit2=="Y") ? BASIC_D : ORIGINAL;

        System.out.printf("입장료: %d",fee);

    }
}