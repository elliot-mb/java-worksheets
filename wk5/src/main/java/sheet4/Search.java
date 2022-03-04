package sheet4;

import com.google.common.graph.*;
import com.google.common.graph.ImmutableValueGraph.Builder;


import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("UnstableApiUsage")
public class Search {

	/**
	 * Lists all nodes values in a given graph.
	 *
	 * @param graph the graph to query the nodes from
	 * @return set of all the nodes in the given graph
	 */
	static Set<Integer> listAllNodes(ImmutableValueGraph<Integer, Integer> graph) {
		return graph.nodes();
	}

	/**
	 * Lists all edge values in a given graph.
	 *
	 * @param graph the graph to query the edges from
	 * @return list of all the edges in the given graph, the order is not important
	 */
	static List<Integer> listAllEdgeValues(ImmutableValueGraph<Integer, Integer> graph) {
		Object[] nodes = graph.nodes().toArray();
		List<Integer> edges = new ArrayList<Integer>();
		for(int i = 0; i < nodes.length; i++){
			for(int j = i; j < nodes.length; j++){
				if(graph.edgeValue((Integer) nodes[i], (Integer) nodes[j]).isPresent()){
					edges.add(graph.edgeValue((Integer) nodes[i], (Integer) nodes[j]).get());
				}
			}
		}
		return edges;
	}

	/**
	 * Lists all nodes with 4 or more edges
	 *
	 * @param graph the graph to query the edges from
	 * @return set of all nodes that satisfy the condition
	 */
	static Set<Integer> findAllNodeWith4OrMoreEdges(
			ImmutableValueGraph<Integer, Integer> graph) {
		Object[] nodes = graph.nodes().toArray();
		Set<Integer> nodes40 = new HashSet<>();
		for(int i = 0; i < Search.listAllNodes(graph).size(); i++){
			if(graph.degree((Integer) nodes[i]) >= 4){
				nodes40.add((Integer) nodes[i]);
			}
		}
		return nodes40;
	}

	/**
	 * Lists all nodes with edges values that when summed, is > 20
	 * For example, a node with three connected edges containing the value: 1, 2, 3 has an edge
	 * sum of 6.
	 *
	 * @param graph the graph to query the edges from
	 * @return set of all nodes that satisfy the condition
	 */
	static Set<Integer> findAllNodesWithEdgeSumGreaterThan20(
			ImmutableValueGraph<Integer, Integer> graph) {
		Object[] nodes = listAllNodes(graph).toArray();
		Set<Integer> satisfy = new HashSet<Integer>();

		
		for (Object node : nodes) {
			List<Integer> edges = new ArrayList<Integer>();
			for (int i = 0; i < nodes.length; i++) {
				if (graph.edgeValue((Integer) node, (Integer) nodes[i]).isPresent()) {
					Integer edgeValue = graph.edgeValue((Integer) node, (Integer) nodes[i]).get();
					edges.add(edgeValue);
				}
			}
			Integer sum = 0;
			for (Integer edge : edges) { sum += edge; }


			if (sum > 20) { satisfy.add((Integer) node); }
		}

		return satisfy;
	}


	/**
	 * Finds the shortest possible path that travels from the source to destination, factoring the
	 * edge distances.
	 * A path that allows you to travel from the source to the destination with the minimum total
	 * edge distances is the shortest path.
	 *
	 * @param graph the graph to compute the shortest path with
	 * @param source the starting position of the search, the resulting list should start with
	 * this value
	 * @param destination the end position of the search, the resulting list should end with this
	 * value
	 * @return a list of nodes that represent the shortest path from source to destination where
	 * the first element is the source and the last element is the destination
	 */
	static Dictionary<Integer, ArrayList<Integer>> populate(Dictionary<Integer, ArrayList<Integer>> nodeDict,
															ImmutableValueGraph<Integer, Integer> graph, Integer source){
		nodeDict.put(source, new ArrayList<Integer>(Arrays.asList(0, null)));
		for(Object n : graph.nodes()){
			if((Integer) n != source) {
				nodeDict.put((Integer) n, new ArrayList<Integer>(Arrays.asList(Integer.MAX_VALUE, null)));
			}
		}
		return nodeDict;
	}

	static boolean searchList(Integer[] nodes, Integer x) {
		return Arrays.asList(nodes).contains(x);
	}

	static List<Integer> shortestPathFromSourceToDestination(
			ImmutableValueGraph<Integer, Integer> graph,
			Integer source,
			Integer destination) {
		Dictionary<Integer, ArrayList<Integer>> nodeDict = new Hashtable<Integer, ArrayList<Integer>>();

		//System.out.println("I WANT TO GO TO " + destination + ", STARTING AT " + source);

		//Object sourceNode = nodeDict.get(source);
		nodeDict = populate(nodeDict, graph, source);
		
		int pos = 0;
		Integer[] visitedNodes = new Integer[35];
		Object currentNode = source;
		Integer min = Integer.MAX_VALUE;
		Integer bestNode = -1;
		while ((Integer) currentNode != destination) {
			//min = Integer.MAX_VALUE;

			System.out.println(currentNode);
			
			//getting successors
			Object[] succ = graph.successors((Integer) currentNode).toArray();
			//System.out.println(succ); just prints a memory address

			for (Object node : succ) {
				System.out.print(node + " ");
			}

			System.out.println("");
			Integer localMin = Integer.MAX_VALUE; //will select best immediate node
			for (Object node : succ) {
				
				//gets the current node's min value from paths
				
				//System.out.println("Min is " + min);
				if(graph.edgeValue((Integer) node, (Integer) currentNode).isPresent() && !Search.searchList(visitedNodes, (Integer)node) && (Integer)node != source) {
					System.out.println("Min so far is " + min); //just gonna pop this in here to know its talking about nodes its still to visit

					//gets distance between node and current node
					Integer edgeVal = graph.edgeValue((Integer) node, (Integer) currentNode).get();
					//calculates the total distance (incl. previous path)
					Integer distance = (nodeDict.get((Integer) currentNode).get(0) + edgeVal);
					System.out.println("Node: " + (Integer)node + " Edge Value: " + edgeVal +  " Distance: " + distance + " Predecessor: " + nodeDict.get((Integer) node).get(1));
					//if this is less than the current key value held in the node, replace and is now
					//best node
					if(distance < min){
						min = distance;
						bestNode = (Integer) node;
						System.out.println("Best Node is " + bestNode);
					}

					if (searchList(visitedNodes, bestNode)) min = distance;
					//update table respectively
					if (distance < (nodeDict.get((Integer) node).get(0))){
						nodeDict.put((Integer) node, new ArrayList<Integer>(Arrays.asList(distance, (Integer) currentNode)));
					}
					
				}
			}
			visitedNodes[pos] = (Integer)currentNode;
			currentNode = bestNode;
			pos++;
		}

		List<Integer> path = new ArrayList<Integer>();

		while (currentNode != source) {
			path.add((Integer) currentNode);
			currentNode = nodeDict.get(currentNode).get(1);
		}

		return path;

	}

//	static List<Integer> shortestPathFromSourceToDestinatioN(
//			ImmutableValueGraph<Integer, Integer> graph,
//			Integer source,
//			Integer destination) {
//
//		// trying my hand for practise and understanding (https://youtu.be/pVfj6mxhdMw)
//
//		//shortest distance from the source to every node
//		ArrayList<Integer>
//				node     = new ArrayList<Integer>(),
//				shortest = new ArrayList<Integer>(),
//				previous = new ArrayList<Integer>(),
//				visited  = new ArrayList<Integer>(),
//				successor = new ArrayList<Integer>();
//		Integer current = source; //current node
//		int dist = Integer.MAX_VALUE; //best distance to the next node
//		node.set(0, source);
//		shortest.set(0, 0);
//		previous.set(0, null);
//		node.addAll(graph.nodes());
//		while(current != destination){
//			successor.addAll(graph.successors(current));
//			for(Integer s : successor){
//				if(graph.edgeValue(current, s) );
//			}
//		}
//	}

	// reads in a graph stored in plan text, not part of any question but feel free to study at how
	// a graph is constructed
	static ImmutableValueGraph<Integer, Integer> readGraph(String content) {
		List<String> lines = content.lines().collect(Collectors.toList());
		if (lines.isEmpty()) throw new IllegalArgumentException("No lines");
		int currentLine = 0;

		String[] topLine = lines.get(currentLine++).split(" ");
		int numberOfNodes = Integer.parseInt(topLine[0]);
		int numberOfEdges = Integer.parseInt(topLine[1]);

		Builder<Integer, Integer> builder = ValueGraphBuilder
				.undirected()
				.expectedNodeCount(numberOfNodes)
				.immutable();


		for (int i = 0; i < numberOfNodes; i++) {
			String line = lines.get(currentLine++);
			if (line.isEmpty()) continue;
			builder.addNode(Integer.parseInt(line));
		}

		for (int i = 0; i < numberOfEdges; i++) {
			String line = lines.get(currentLine++);
			if (line.isEmpty()) continue;

			String[] s = line.split(" ");
			if (s.length != 3) throw new IllegalArgumentException("Bad edge line:" + line);
			builder.putEdgeValue(Integer.parseInt(s[0]),
					Integer.parseInt(s[1]),
					Integer.parseInt(s[2]));
		}
		return builder.build();
	}


}
