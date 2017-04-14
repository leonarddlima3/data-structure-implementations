/* @Author : Leonard D'lima
 * @Description : This program illustrates graph breadth first traversal technique
 * using adjaceny list representation
 */
package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class GraphOperations {
	static GraphNode v[]={null,null,null,null,null};
	static boolean visited[]={false,false,false,false,false};
	static int index=-1;
	GraphNode temp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphOperations go=new GraphOperations();
		System.out.println("Undirected Edges");
		go.connectVertices(1, 2);//connect vertices 1 and 2
		go.connectVertices(2, 3);//connect vertices 2 and 3
		go.connectVertices(2, 5);//connect vertices 2 and 5
		go.connectVertices(3, 4);//connect vertices 3 and 4
		
		System.out.println("\nChecking Connectivity (Implemented using Adjacency List Representation)");
		go.checkConnectivity(v[0],0);
		go.checkConnectivity(v[1],1);
		go.checkConnectivity(v[2],2);
		go.checkConnectivity(v[3],3);
		go.checkConnectivity(v[4],4);
		
		System.out.println("\nImplementing Breadth First Search Traversal");
		go.bfsTraversalUsingAdjacencyList();
	}
	
	public void checkConnectivity(GraphNode node, int pos){
		System.out.println("element : "+(pos+1));
		GraphNode temp=node;
		if(temp!=null){
			while(temp.next!=null){
				System.out.println(temp.data);
				temp=temp.next;
			}
			System.out.println(temp.data);
		}
		
	}
	
	public void connectVertices(int data1, int data2){
		System.out.println(data1+"-"+data2);
		if(v[data1-1]==null){
			GraphNode node=new GraphNode();
			node.data=data2;
			node.next=null;
			v[data1-1]=node;
		}else if(v[data1-1]!=null){
			GraphNode node=new GraphNode();
			node.data=data2;
			node.next=null;
			while(v[data1-1].next!=null){
				v[data1-1]=v[data1-1].next;
			}
			v[data1-1].next=node;
		}
		
		if(v[data2-1]==null){
			GraphNode node=new GraphNode();
			node.data=data1;
			node.next=null;
			v[data2-1]=node;
		}else if(v[data2-1]!=null){
			GraphNode node=new GraphNode();
			node.data=data1;
			node.next=null;
			while(v[data2-1].next!=null){
				v[data2-1]=v[data2-1].next;
			}
			v[data2-1].next=node;
		}
		
		
	}
	
	public void bfsTraversalUsingAdjacencyList(){
		Queue<GraphNode> queue=new LinkedList<>();
		Queue<Integer> queue1=new LinkedList<>();
		index=0;
		queue.add(v[0]);
		queue1.add(0);
		
		while(!queue.isEmpty()){
			temp=queue.remove();
			index=queue1.remove();
			System.out.println(index+1);
			//System.out.println("node removed from queue : "+(index+1));
			
			while(v[index].next!=null){
				if(!v[index].visited&&!visited[v[index].data-1]){
					v[index].visited=true;
					queue.add(v[v[index].data-1]);
					queue1.add(v[index].data-1);
					//System.out.println("node added to queue : "+(v[index].data));
				}
				v[index]=v[index].next;
			}
			if(!v[index].visited&&!visited[v[index].data-1]){
				v[index].visited=true;
				queue.add(v[v[index].data-1]);
				queue1.add(v[index].data-1);
				//System.out.println("node added to queue o: "+(v[index].data));
			}
			visited[index]=true;
			//System.out.println(queue.isEmpty());
		}
	}

}
