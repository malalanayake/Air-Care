package org.air.care.business;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * Given a connected directed graph, find all paths between any two input
 * points.
 * 
 * @author malalanayake
 *
 * @param <T>
 */
public class FindAllPaths<T> {

	private final DirectedWeightedGraph<T> graph;

	/**
	 * Takes in a graph. This graph should not be changed by the client
	 */
	public FindAllPaths(DirectedWeightedGraph<T> graph) {
		if (graph == null) {
			throw new NullPointerException("The input graph cannot be null.");
		}
		this.graph = graph;
	}

	private void validate(T source, T destination) {

		if (source == null) {
			throw new NullPointerException("The source: " + source
					+ " cannot be  null.");
		}
		if (destination == null) {
			throw new NullPointerException("The destination: " + destination
					+ " cannot be  null.");
		}
		if (source.equals(destination)) {
			throw new IllegalArgumentException("The source and destination: "
					+ source + " cannot be the same.");
		}
	}

	/**
	 * Returns the list of paths, where path itself is a list of nodes.
	 * 
	 */
	public List<List<T>> getAllPaths(T source, T destination) {
		validate(source, destination);

		List<List<T>> paths = new Vector<List<T>>();
		recursive(source, destination, paths, new LinkedHashSet<T>());
		return paths;
	}

	// so far this dude ignore's cycles.
	private void recursive(T current, T destination, List<List<T>> paths,
			LinkedHashSet<T> path) {
		path.add(current);

		if (current == destination) {
			paths.add(new Vector<T>(path));
			path.remove(current);
			return;
		}

		final Set<T> edges = graph.edgesFrom(current).keySet();

		for (T t : edges) {
			if (!path.contains(t)) {
				recursive(t, destination, paths, path);
			}
		}

		path.remove(current);
	}

}
