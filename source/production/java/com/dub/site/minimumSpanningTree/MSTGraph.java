package com.dub.site.minimumSpanningTree;

import java.util.List;


/** Graph has Vertices and Adjacency Lists */
public class MSTGraph extends Graph {
	
	/**
	 * This subclass of Graph implements a Depth First Search algorithm
	 */
	private static final long serialVersionUID = 1L;
	
	private int N;
	
	private boolean finished = false;
	
	private int cost;// partial cost
	
	int[] keys; 
	
	private MinHeap queue;// minimum priority queue

	int time = 0;
	
	
	public MSTGraph(int N) {
		super(N);
		this.N = N;
		cost = 0;
		keys = new int[N];
	}
	
	public MSTGraph(MSTGraph source) {// deep copy c'tor
		super(source.N);
		this.N = source.N;
		this.finished = false;
			 		
		for (int i = 0; i < source.N; i++) {
			MSTVertex dfsVertex = (MSTVertex)source.getVertices()[i];
			this.getVertices()[i] = new MSTVertex(dfsVertex);
		}
	
	}
	
	
	
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public void display() {// used for debugging only
		for (int i = 0; i < N; i++) {
			MSTVertex mstv = (MSTVertex)vertices[i];
			System.out.println(mstv);
		}
		System.out.println();
	}
	
	public void displayWeights() {
		System.out.println("displayWeights");
		for (Vertex v : vertices) {// for each vertex
			for (WeightedEdge edge : v.getAdjacency()) {
				System.out.println(v.getName() + " "  
							+ this.vertices[edge.getTo()] + " " 
							+ edge.getWeight());
			}// for
		}// for
	}
	
	
	public void searchStep() {
		
		int mIndex = queue.extractMin();
		MSTVertex u = (MSTVertex)vertices[mIndex];
		
		List<WeightedEdge> conn = u.getAdjacency();
		
		for (int k = 0; k < conn.size(); k++) {
			int iv = conn.get(k).getTo();
			MSTVertex v = (MSTVertex)vertices[iv];
			int weight = conn.get(k).getWeight();
			if (queue.isInQueue(iv) && weight < keys[iv]) {
				v.setParent(mIndex);
				keys[iv] = weight;
				queue.decreaseKey(iv, weight);
			}
		}// for
		
		queue.display();
		
		displayMST();
		
		// update vertices
		for (int i1 = 0; i1 < N; i1++) {// for each index
			((MSTVertex)vertices[i1]).setKey(keys[i1]);
		}
		
		// update running cost
		cost = 0;// first reset
		for (int i1 = 0; i1 < N; i1++) {// for each vertex
			MSTVertex u1 = (MSTVertex)vertices[i1];
			List<WeightedEdge> conn1 = u1.getAdjacency();// all edges from u1 
			for (int k = 0; k < conn1.size(); k++) {
				int iv1 = conn1.get(k).getTo();
				MSTVertex v1 = (MSTVertex)vertices[iv1];
				if (v1.getParent() != null && v1.getParent() == i1) {
					cost += conn1.get(k).getWeight();
				}
			}
		}
		
		// prepare next step
		if (queue.isEmpty()) {
			this.finished = true;
		} 
		
	}// searchStep
		
	public void initPrim() {
	
		for (int i = 1; i < N; i++) {
			keys[i] = 1000;
		}
		keys[0] = 0;
		queue = new MinHeap(keys);
		queue.display();
	}
	
	public void displayMST() {// used for debugging only
		System.out.println("displayMST");
		for (int i1 = 0; i1 < N; i1++) {
			String name = vertices[i1].getName();
			Integer pIndex = ((MSTVertex)vertices[i1]).getParent();
			String parent = pIndex == null ? "" : vertices[pIndex].getName();
			System.out.println(name + " p " + parent);
		}
		System.out.println();
	}
	
}
