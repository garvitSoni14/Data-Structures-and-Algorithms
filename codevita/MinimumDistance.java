package codevita;
import java.util.*;
import java.awt.Point;

public class MinimumDistance {

    static class Line {
        Point a, b;
        Line(int x1, int y1, int x2, int y2) {
            a = new Point(x1, y1);
            b = new Point(x2, y2);
        }
    }

    static class Star {
        Set<Point> pts = new HashSet<>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lines.add(new Line(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Point src = new Point(sc.nextInt(), sc.nextInt());
        Point dest = new Point(sc.nextInt(), sc.nextInt());

        List<Star> stars = buildStars(lines);
        int srcStar = findStar(stars, src);
        int destStar = findStar(stars, dest);

        if (srcStar == -1 || destStar == -1) {
            System.out.println(distance(src, dest));
            return;
        }
        if (srcStar == destStar) {
            System.out.println(0);
            return;
        }

        List<List<Integer>> graph = buildGraph(stars);
        int steps = bfs(graph, srcStar, destStar);
        System.out.println(steps == -1 ? distance(src, dest) : steps - 1);
    }

    // --- Build Stars (connected by shared endpoints) ---
    static List<Star> buildStars(List<Line> lines) {
        int n = lines.size();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (connected(lines.get(i), lines.get(j))) {
                    union(parent, i, j);
                }
            }
        }

        Map<Integer, Star> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            map.putIfAbsent(root, new Star());
            Star s = map.get(root);
            s.pts.add(lines.get(i).a);
            s.pts.add(lines.get(i).b);
        }

        return new ArrayList<>(map.values());
    }

    static boolean connected(Line l1, Line l2) {
        return l1.a.equals(l2.a) || l1.a.equals(l2.b) || l1.b.equals(l2.a) || l1.b.equals(l2.b);
    }

    static int find(int[] parent, int x) {
        return parent[x] == x ? x : (parent[x] = find(parent, parent[x]));
    }

    static void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa != pb) parent[pb] = pa;
    }

    static int findStar(List<Star> stars, Point p) {
        for (int i = 0; i < stars.size(); i++) {
            if (stars.get(i).pts.contains(p)) return i;
        }
        return -1;
    }

    // --- Build Graph of Stars ---
    static List<List<Integer>> buildGraph(List<Star> stars) {
        int n = stars.size();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (canConnect(stars.get(i), stars.get(j))) {
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }
        return g;
    }

    // Two stars connect if any of their arms can touch after rotation (distance ≤ 1)
    static boolean canConnect(Star s1, Star s2) {
        for (Point a : s1.pts) {
            for (Point b : s2.pts) {
                int dx = Math.abs(a.x - b.x);
                int dy = Math.abs(a.y - b.y);
                if ((dx == 0 || dy == 0 || dx == dy) && Math.max(dx, dy) <= 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // --- BFS to find minimum stars between source and destination ---
    static int bfs(List<List<Integer>> g, int s, int d) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[g.size()];
        q.add(new int[]{s, 1});
        vis[s] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0], steps = cur[1];
            if (u == d) return steps;
            for (int v : g.get(u)) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(new int[]{v, steps + 1});
                }
            }
        }
        return -1;
    }

    static int distance(Point a, Point b) {
        return Math.max(Math.abs(a.x - b.x), Math.abs(a.y - b.y));
    }
}
