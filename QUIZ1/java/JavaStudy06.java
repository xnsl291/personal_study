/*
* 주제 : 가상 대선 당선 시뮬레이션
* 요구사항 : 총 투표 1만건.
* 투표 결과는 4명 후보 동일비율로 랜덤생성
*
* 작성자 : 조하나
*/
import java.util.Random;

public class JavaStudy06
{
    static final int candi_num = 4;
    static final int total_voter = 100000;
    static final double ratio = 100.0/total_voter;

    static Random rand = new Random();

    public static void main(String[] args)
    {
        int  max = 0 , winner = 0;
        int[] record = new int[candi_num];
        String[] candidate = new String[]{"이재명","윤석열","심상정","안철수"};

        for (int voter=1; voter<=total_voter ; voter++)
        {
            int vote = rand.nextInt(0,candi_num); // 랜덤 투표
            record[vote]++; // 후보별 투표자수
            System.out.printf("[투표진행율]: %.2f%%, %d명 투표 => %s \n",voter *ratio,voter,candidate[vote]);

            for (int i=0; i<candi_num; i++)
                System.out.printf("[기호:%d] %s: %.2f%%, (투표수: %d)\n", i + 1, candidate[i], record[i] *ratio, record[i]);
            System.out.println();
        }
        for (int i = 0; i < record.length; i++)
            if (max < record[i]) // 최다득표자 찾기
            {
                max = record[i];
                winner = i;
            }
        System.out.printf("[투표결과] 당선인: %s", candidate[winner]);
    }
}
