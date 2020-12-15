package graph;

import java.util.ArrayList;

class GraphByList {
	private ArrayList<ArrayList<Integer>> adjList;
	private int n; // 차수
	
	
	public GraphByList(int initSize)
	{	
		// 인접리스트 생성
		adjList = new ArrayList<ArrayList<Integer>>();
		n = initSize;
		
		// 각 정점에 대한 인접리스트 초기화 
		for(int i=0; i<=n; i++) 
		{
			adjList.add(new ArrayList<Integer>());
		}
	}
	
	public ArrayList<Integer> getNode(int idx)
	{
		return adjList.get(idx);
	}
	
	public void insertEdge(int start, int end)
	{
		adjList.get(start).add(end);
		adjList.get(end).add(start);
	}
	
	public void insertEdgeSingle(int start, int end)
	{
		adjList.get(start).add(end);
	}
	
	public void printAdjList() 
	{
		for(int i=1; i<adjList.size(); i++)
		{
			System.out.printf("Adj Node of %d",i);
			for(int j=0; j<adjList.get(i).size(); j++)
			{
				System.out.printf(" -> %d",adjList.get(i).get(j));
			}
			System.out.println("");
		}
	}
}

public class GraphByListTest{
	public static void main(String[] args) {
		GraphByList adjList = new GraphByList(6);
		
		adjList.insertEdge(1, 2);
		adjList.insertEdge(1, 3);
		adjList.insertEdge(2, 3);
		adjList.insertEdge(2, 4);
		adjList.insertEdge(3, 4);
		adjList.insertEdge(3, 5);
		adjList.insertEdge(4, 5);
		adjList.insertEdge(4, 6);
		
		adjList.printAdjList();
	}
}
