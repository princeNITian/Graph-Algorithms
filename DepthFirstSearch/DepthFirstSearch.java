package DepthFirstSearch;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

	private Stack<Vertex> stack;
	
	public DepthFirstSearch() {
		this.stack = new Stack<>();
	}
	
	public void dfs(List<Vertex> vertexList) {
		for(Vertex v:vertexList) {
			if(!v.isVisited()) {
				v.setVisited(true);
				//dfsWithStack(v);
				dfsRecursion(v);
			}
		}
	}

	private void dfsRecursion(Vertex v) {
		System.out.print(v+" ");
		
		for(Vertex vertex: v.getNeighbourList()) {
			if(!vertex.isVisited()) {
				vertex.setVisited(true);
				dfsRecursion(vertex);
			}
		}
		
	}

	private void dfsWithStack(Vertex rootVertex) {
		this.stack.add(rootVertex);
		rootVertex.setVisited(true);
		
		while(!stack.isEmpty()) {
			Vertex actualVertex = this.stack.pop();
			System.out.print(actualVertex+" ");
			
			for(Vertex v: actualVertex.getNeighbourList()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					this.stack.push(v);
				}
			}
			
			
		}
		
	}
}
