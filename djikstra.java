import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class djikstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int mat[][] = new int[V+1][V+1];
        int inf = Integer.MAX_VALUE/2 -1;
        int a;
        int b;
        int c;
        boolean visited2[]=new boolean[V+1];
        int length2[]=new int[V+1];
        for (int i = 0; i < E; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st1.nextToken());
            b = Integer.parseInt(st1.nextToken());
            c = Integer.parseInt(st1.nextToken());
            mat[a][b] = c;
            mat[b][a] = c;
        }
        for(int i=1; i<=V; i++)
        {
            if(length2[i]==inf)
            {
                bw.write("-1" + "\n");
            }
            else
            {
                bw.write(length2[i] + "\n");
            }
        }
        bw.flush();
    }
}
	