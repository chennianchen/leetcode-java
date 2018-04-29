package leetcode.并查集;

/**
 * Created by jiangyunxiong on 2018/4/29.
 */
public class UnionFind {

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        UF uf = new UF(N);
        for (int[] e : edges){
            int u = e[0], v = e[1];
            if(uf.find(u) == uf.find(v)){
                return e;
            }
            uf.union(u, v);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        int[][] edges = {{1,2}, {1,3}, {2,3}};
        System.out.println(uf.findRedundantConnection(edges));
    }
}

class UF {
    int[] id;

    //初始化
    UF(int N) {
        id = new int[N + 1];
        for(int i = 0;i < id.length; i++){
            id[i] = i;
        }
    }

    void union(int u, int v){
        int uID = find(u);
        int vID = find(v);
        if (uID == vID){
            return;
        }
        for (int i = 0;i < id.length;i++){
            if(id[i] == uID){
                id[i] = vID;
            }
        }
    }

    int find(int p){
        return id[p];
    }
}
