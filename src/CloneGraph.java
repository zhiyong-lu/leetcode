import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//133. Clone Graph
public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		node2.neighbors.add(node3);
		node2.neighbors.add(node1);
		node3.neighbors.add(node4);
		node3.neighbors.add(node2);
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);
		
		
		cloneGraphDFS(node1);
		
		
	}
//	https://www.cnblogs.com/grandyang/p/4267628.html
    public static GraphNode cloneGraphBFS(GraphNode node) {
		Queue<GraphNode> queue = new LinkedList<>();
		Map<GraphNode, GraphNode> map = new HashMap();
		
		queue.offer(node);
//		GraphNode currCloneNode = new GraphNode(node.val, new ArrayList<>());
		map.put(node, new GraphNode(node.val, new ArrayList<>()));
		while (!queue.isEmpty()) {
			GraphNode currNode = queue.poll();
			
			for (GraphNode neighbor:currNode.neighbors) {
				if (map.containsKey(neighbor)) {
					map.get(currNode).neighbors.add(map.get(neighbor));
				} else {
//					GraphNode newNeighborNode = new GraphNode(neighbor.val, new ArrayList<>());
					map.put(neighbor, new GraphNode(neighbor.val, new ArrayList<>()));
					queue.offer(neighbor);
				}
			}
		}
    	
    	return map.get(node);
    }
    
    
//    Map<GraphNode, Node> map = new HashMap<>();
    public static GraphNode cloneGraphDFS(GraphNode node) {
    	Map<GraphNode, GraphNode> map = new HashMap<>();
    	GraphNode graphNode = cloneGraphDFSHelper(node, map);
    	return graphNode;
    }
    
    private static GraphNode cloneGraphDFSHelper(GraphNode node, Map<GraphNode, GraphNode> map) {
    	  map.put(node, new GraphNode(node.val, new ArrayList<>()));
 	     
          for(GraphNode neighbor: node.neighbors){
              if(map.containsKey(neighbor)){
                  map.get(node).neighbors.add(map.get(neighbor)); 
              }else{
                  map.get(node).neighbors.add(cloneGraphDFSHelper(neighbor, map));
              }
          }
       
          return map.get(node);	
    }

}
