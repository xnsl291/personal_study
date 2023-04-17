/*
* 주제 : 콘솔 화면에 구구단 출력하기
* 요구사항 : 1~9단, String.format함수 사용
* 작성자 : 조하나
*/

public class JavaStudy01 {
    public static void main(String[] args)
    {
        for (int i=1;i<10;i++)
        {
            for (int j = 1; j < 10; j++)
                System.out.printf(String.format("%02d X %02d = %02d\t", j, i, i * j));
            System.out.printf("\n");
        }
    }
}