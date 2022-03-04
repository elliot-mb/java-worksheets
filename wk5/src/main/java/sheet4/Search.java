package sheet4;

import com.google.common.graph.*;
import com.google.common.graph.ImmutableValueGraph.Builder;


import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.*;
import java.util.function.Predicate;
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

		nodeDict = populate(nodeDict, graph, source);
		
		int pos = 0;
		Integer[] visitedNodes = new Integer[35];
		Integer currentNode = source;
		Integer min = Integer.MAX_VALUE;
		Integer bestNode = -1;
		ArrayList<Integer> endPoints = new ArrayList<>(); //places we know at least one distance to (we've calculated at least once)
		endPoints.add(source);
		while (currentNode != destination) {
			//min = Integer.MAX_VALUE;

			System.out.println(currentNode);
			
			//getting successors
			Object[] succ = graph.successors(currentNode).toArray();

			for (Object node : succ) {
				System.out.print(node + " ");
			}

			System.out.println("");
			for (Object node : succ) {
				if(graph.edgeValue((Integer) node, currentNode).isPresent() && !Search.searchList(visitedNodes, (Integer)node) && (Integer)node != source) {
					Integer edgeVal = graph.edgeValue((Integer) node, currentNode).get();
					Integer distance = (nodeDict.get(currentNode).get(0) + edgeVal);

					//only update the distance if its shorter than our shortest to that node
					if(distance < nodeDict.get(node).get(0)) { nodeDict.put((Integer) node, new ArrayList<Integer>(Arrays.asList(distance, currentNode))); }
					//all endpoints can be distinct
					if(!endPoints.contains((Integer) node)) { endPoints.add((Integer) node); } //add this node to the endpoints list

					System.out.println("Node: " + node + ", Edge Value: " + edgeVal +  ", Distance: " + distance + ", Predecessor: " + nodeDict.get(node).get(1));
				}
			}
			visitedNodes[pos] = currentNode;

			endPoints.removeIf(Predicate.isEqual(currentNode)); //removes current node (its been fully visited)
			Integer localBestDist = Integer.MAX_VALUE; Integer d;
			ArrayList<Integer> debugDistances = new ArrayList<Integer>();
			for(Integer node : endPoints){// selects the shortest distance of all endpoints bar the ones already visited
				d = nodeDict.get(node).get(0);
				debugDistances.add(d);
				if(d < localBestDist){
					currentNode = node;
					localBestDist = d;
				}
			}
			System.out.println("Endpoint nodes: " + endPoints);
			System.out.println("Distances from source: " + debugDistances);
			//currentNode = bestNode;
			pos++;
		}

		List<Integer> path = new ArrayList<Integer>();

		path.add(0, currentNode);
		while (true) {
			currentNode = nodeDict.get(currentNode).get(1);
			path.add(0, currentNode);
			if(Objects.equals(currentNode, source)) {
				System.out.println("Path: " +path);
				return path;
			} //needs to include source
		}
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
