import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

@SuppressWarnings("unchecked")
public class djikstra2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        ArrayList<pair>[] adj = new ArrayList[V];
        boolean visited[] = new boolean[V];
        int out[] = new int[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        int a;
        int b;
        int c;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            pair p = new pair(c, b - 1);
            adj[a - 1].add(p);
            p = new pair(c, a - 1);
            adj[b - 1].add(p);
        }
        Arrays.fill(out, -1);
        PriorityQueue<pair> Q = new PriorityQueue<>();
        pair p = new pair(0, S - 1);
        Q.offer(p);
        while (!Q.isEmpty()) {
            b = Q.peek().second;
            a = Q.poll().first;
            if (visited[b]) {
                continue;
            }
            visited[b]=true;
            out[b] = a;
            for (int i = 0; i < (adj[b].size()); i++) {
                p = new pair(adj[b].get(i).first + a, adj[b].get(i).second);
                Q.offer(p);
            }
        }
        for (int i = 0; i < V; i++) {
            bw.write(out[i] + "\n");
        }
        bw.flush();
    }
}

class pair implements Comparable<pair> {
    int first, second;

    pair(int a, int b) {
        first = a;
        second = b;
    }

    @Override
    public int compareTo(pair ok) {
        return (int) (Math.signum(first - ok.first));
    }
}
	