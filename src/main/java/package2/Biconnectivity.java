package main.java.package2;

import java.util.*;

public class Biconnectivity {

	List<Integer>[] bicongraph;
	boolean[] isVisited;
	Stack<Integer> theStack;
	int timer;
	int[] timeOfIn;
	int[] lowLinkData;
	List<List<Integer>> edgeBiconComps;
	List<Integer> theCutPoints;
	List<String> theBridges;

	public List<List<Integer>> biconnectivity(List<Integer>[] graph) {
		int n = graph.length;
		this.bicongraph = graph;
		isVisited = new boolean[n];
		theStack = new Stack<>();
		timer = 0;
		timeOfIn = new int[n];
		lowLinkData = new int[n];
		edgeBiconComps = new ArrayList<>();
		theCutPoints = new ArrayList<>();
		theBridges = new ArrayList<>();

		for (int u = 0; u < n; u++)
			if (!isVisited[u])
				dfs(u, -1);

		return edgeBiconComps;
	}

	void dfs(int u, int p) {
		isVisited[u] = true;
		lowLinkData[u] = timeOfIn[u] = timer++;
		theStack.add(u);
		int childrenCount = 0;
		boolean isCutPoint = false;
		for (int v : bicongraph[u]) {
			if (v == p)
				continue;
			if (isVisited[v]) {
				lowLinkData[u] = Math.min(lowLinkData[u], timeOfIn[v]); // or lowlink[u] = Math.min(lowlink[u], lowlink[v]);
			} else {
				dfs(v, u);
				lowLinkData[u] = Math.min(lowLinkData[u], lowLinkData[v]);
				isCutPoint |=  timeOfIn[u] <= lowLinkData[v];
				if (timeOfIn[u] < lowLinkData[v]) // or if (lowlink[v] == tin[v])
					theBridges.add("(" + u + "," + v + ")");
				++childrenCount;
			}
		}
		if (p == -1)
			isCutPoint = childrenCount >= 2;
		if (isCutPoint)
			theCutPoints.add(u);
		if (timeOfIn[u] == lowLinkData[u]) {
			List<Integer> theComponent = new ArrayList<>();
			while (true) {
				int x = theStack.pop();
				theComponent.add(x);
				if (x == u)
					break;
			}
			edgeBiconComps.add(theComponent);
		}
	}

	public static List<Integer>[] ebcTree(List<Integer>[] graph, List<List<Integer>> components) {
		int[] comp = new int[graph.length];
		for (int i = 0; i < components.size(); i++)
			for (int u : components.get(i))
				comp[u] = i;
		List<Integer>[] g = Stream.generate(ArrayList::new).limit(components.size()).toArray(List[]::new);
		for (int u = 0; u < graph.length; u++)
			for (int v : graph[u])
				if (comp[u] != comp[v])
					g[comp[u]].add(comp[v]);
		return g;
	}

	public static void main(String[] args) {
		List<Integer>[] graph = Stream.generate(ArrayList::new).limit(6).toArray(List[]::new);

		int[][] esges = {{0, 1}, {1, 2}, {0, 2}, {2, 3}, {1, 4}, {4, 5}, {5, 1}};
		for (int[] edge : esges) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}

		Biconnectivity bc = new Biconnectivity();
		List<List<Integer>> components = bc.biconnectivity(graph);

		System.out.println("edge-biconnected components:" + components);
		System.out.println("cut points: " + bc.theCutPoints);
		System.out.println("bridges:" + bc.theBridges);
		System.out.println("condensation tree:" + Arrays.toString(ebcTree(graph, components)));
	}
}