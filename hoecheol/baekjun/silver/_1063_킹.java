import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1063_킹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] king = st.nextToken().toCharArray();
        char[] rock = st.nextToken().toCharArray();
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String mv_pos = br.readLine();
            char[] kingPosition = king.clone();
            char[] rockPosition = rock.clone();
            move(mv_pos, kingPosition);
            if (range(kingPosition)) continue;
            if (Arrays.equals(kingPosition, rockPosition)) {
                move(mv_pos, rockPosition);
                if (range(rockPosition)) continue;
            }
            king = kingPosition;
            rock = rockPosition;
        }

        System.out.println(king);
        System.out.println(rock);
    }

    public static boolean range(char[] next) {
        return (next[0] < 'A' || next[0] > 'H' || next[1] < '1' || next[1] > '8');
    }

    public static void move(String mv_pos, char[] next) {
        if ((mv_pos).contains("L")) {
            next[0]--;
        }
        if ((mv_pos).contains("R")) {
            next[0]++;
        }
        if ((mv_pos).contains("B")) {
            next[1]--;
        }
        if ((mv_pos).contains("T")) {
            next[1]++;
        }
    }
}