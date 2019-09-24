package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CriticalConnection {
	
	// Need to change. Runs in 139 ms. 
	static int time = 0;
	static LinkedList<Integer>[] adj;
	static List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public static void main(String args[]) {
				 
		List<List<Integer>> connections = new ArrayList<>();
		connections.add(new ArrayList<>(Arrays.asList(0,1)));
		connections.add(new ArrayList<>(Arrays.asList(1,2)));
		connections.add(new ArrayList<>(Arrays.asList(2,0)));
		connections.add(new ArrayList<>(Arrays.asList(1,3)));
		
		criticalConnections(4, connections);
	}

	public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		adj = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		for (List<Integer> connection : connections) {
			adj[connection.get(0)].add(connection.get(1));
			adj[connection.get(1)].add(connection.get(0));
		}

		boolean visited[] = new boolean[n];
		int disc[] = new int[n];
		int low[] = new int[n];
		int parent[] = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = -1;
			visited[i] = false;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == false)
				connectionUtil(i, visited, disc, low, parent);
		}
		return result;

	}

	public static void connectionUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent) {
		visited[u] = true;
		disc[u] = low[u] = ++time;
		Iterator<Integer> i = adj[u].iterator();
		while (i.hasNext()) {
			int v = i.next();
			if (!visited[v]) {
				parent[v] = u;
				connectionUtil(v, visited, disc, low, parent);
				low[u] = Math.min(low[u], low[v]);
				if (low[v] > disc[u]) {
					result.add(new ArrayList<Integer>(Arrays.asList(u, v)));
				}
			} else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
	}
}
