/*
* 주제 : 로또 당첨 프로그램
* 요구사항 : 로또 개수 입력 후, 개수만큼 1~45사이 숫자 중 6개 번호 랜덤 생성.
* 생성된 로또 번호의 당첨여부 판단(6개 맞아야 당첨)
*
* 작성자 : 조하나
*/
import java.util.*;
public class JavaStudy07
{
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    static final int lotto_num = 6;

    public static int[] gen_lotto() //로또 생성기
    {
        int[] lotto_set = new int[lotto_num];
        for(int i=0; i<lotto_num; i++)
            lotto_set[i] = rand.nextInt(1,46);

        return lotto_set;
    }

    public static void print_lotto(int[] target_lotto,int[] ans_lotto,boolean flag)
    { // 로또 번호 출력
        int match_num = 0;

        for(int i=0; i<target_lotto.length; i++)
        {
            System.out.printf("%02d", target_lotto[i]);
            if (i!=lotto_num-1 )
                System.out.printf(",");
            else
            {
                if (flag == true)
                {
                    match_num = match_lotto(target_lotto, ans_lotto);
                    if (match_num == 6)
                        System.out.printf(" 축!당첨!");
                    else
                        System.out.printf(" => %d개 일치", match_num);
                }
                System.out.printf("\n");
            }
        }
    }

    public static int match_lotto(int[] target_lotto, int[] ans_lotto)
    { // 일치하는 번호 개수 확인
        int match = 0 ;
        int[] ans_cpy = ans_lotto.clone();

        for(int i=0; i<ans_cpy.length; i++)
            for (int j = 0; j<lotto_num; j++)
                if (target_lotto[j] == ans_cpy[i])
                {
                    target_lotto[j] = -1;
                    match++;
                    break;
                }
        return match;
    }

    public static void main(String[] args)
    {
        int num = 0;


        while(num<1 || num>10)
        {
            System.out.printf("[로또 당첨 프로그램]\n");
            System.out.printf("로또 개수를 입력해 주세요. (숫자 1~10):");
            num = scan.nextInt();
        }

        int [][] input = new int[num][]; // 구매로또
        int[] lotto = gen_lotto(); //정답로또

        for (int i =0; i<num; i++)
            input[i] = gen_lotto();

        for(int i = 0; i<num; i++)
        {
            System.out.printf("%c\t",65+i);
            print_lotto(input[i],lotto,false);
        }

        System.out.printf("\n[로또 발표]\n\t");
        print_lotto(lotto,lotto,false);

        System.out.printf("\n[내 로또 결과]\n");
        for(int i=0; i<num; i++)
        {
            System.out.printf("%c\t",65+i);
            print_lotto(input[i],lotto,true);
        }
    }
}
