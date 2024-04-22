package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjListGraph {
	
	private LinkedList<Integer>[] adj;
	private int V;
	private int E;
	
	public AdjListGraph(int nodes) {
		this.V = nodes;
		this.E = 0;
		this.adj = new LinkedList[nodes];
		for(int v =0; v < nodes; v++) {
			this.adj[v] = new LinkedList<>();
		}
	}
	
	public void addEdge(int u, int v) {
		this.adj[u].add(v);
		this.adj[v].add(u);
		E++;
	}
	
	public void bfs(int s) {
		boolean[] visited = new boolean[V];
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.offer(s);
		while(!q.isEmpty()) {
			int u = q.poll();
			System.out.println(u + " ");
			for(int v : adj[u]) {
				if(!visited[v]) {
					visited[v] = true;
					q.offer(v);
				}
			}
		}
	}
	
	public void dfs(int s) {
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		while(!stack.isEmpty()) {
			int u = stack.pop();
			if(!visited[u]) {
				visited[u] = true;
				System.out.println(u + " ");
			}
			for(int v : adj[u]) {
				if(!visited[v]) {
					stack.push(v);
				}
			}
		}
	}
	
	public void recursiveDFS() {
		boolean[] visited = new boolean[V];
		for(int v=0; v< V;v++) {
			if(!visited[v]) {
				recursiveDFS(v, visited);
			}
		}
	}
	
	public void recursiveDFS(int v, boolean[] visited) {
		  visited[v] = true;
		  System.out.println(v + " ");
		  for(int w : adj[v]) {
			  if(!visited[w]) {
				  recursiveDFS(w, visited);
			  }
		  }
		
	}
	
	public void ccDFS() {
		boolean[] visited = new boolean[V];
		int[] compId = new int[V];
		int count =0;
		for(int v=0; v<V; v++) {
			if(!visited[v]) {
				ccDFS(v, visited, compId, count);
				count++;
			}
		}
	}
	
	public void ccDFS(int v, boolean[] visited, int[] compId, int count) {
		visited[v] = true;
		compId[v]=count;
		for(int w : adj[v]) {
			if(!visited[w]) {
				ccDFS(v, visited, compId, count);
			}
		}
	}
		
	public void numIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int numOfIslands =0;
		boolean[][] visited = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0;j<m;j++) {
				if(!visited[i][j] || grid[i][j] == '1') {
					dfs(i, j, visited, grid);
					numOfIslands++;
				}
			}
		}
	}
	
	public void dfs(int row, int col, boolean[][] visited, char[][] grid) {
		 if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == '0') {
			 return;
		 }
		 visited[row][col] = true;
		 dfs(row -1, col, visited, grid);
		 dfs(row +1, col, visited, grid);
		 dfs(row, col +1, visited, grid);
		 dfs(row, col -1, visited, grid);
		 
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + "Vertices" + E + "Edges" + "\n");
		for(int v =0; v<V;v++) {
			sb.append(v + ":");
			for(int w : adj[v]) {
				sb.append(w+ " ");
				
			}
			sb.append("\n");
			}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		AdjListGraph g = new AdjListGraph(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(2, 4);
		System.out.println(g.toString());
		g.bfs(0);
		System.out.println("");
		g.dfs(0);
	}

}
