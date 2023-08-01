import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _10800_컬러볼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Ball[] balls = new Ball[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i, color, size);
        }

        Arrays.sort(balls, Comparator.comparingInt(b -> b.size));

        int[] answer = new int[N];
        int[] colors = new int[N+1];
        int index = 0, sum = 0;
        for(int i = 0; i < N; i++){
            while(balls[index].size < balls[i].size){
                sum += balls[index].size;
                colors[balls[index].color] += balls[index].size;
                index++;
            }
            answer[balls[i].idx] = sum - colors[balls[i].color];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.length; i++){
            sb.append(answer[i]+"\n");
        }
        System.out.println(sb);
    }

    public static class Ball{
        int idx, color, size;
        public Ball(int idx, int color, int size){
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }
}