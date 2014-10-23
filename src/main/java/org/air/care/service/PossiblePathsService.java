package org.air.care.service;

import java.util.List;

import org.air.care.model.PossiblePaths;

/**
 * Possible path service operations
 * 
 * @author malalanayake
 *
 */
public interface PossiblePathsService {

	public List<PossiblePaths> getAllPossiblePaths(String source,
			String destination);

	public PossiblePaths save(PossiblePaths paths);
}
