package org.air.care.service.impl;

import java.util.List;

import org.air.care.model.PossiblePaths;
import org.air.care.repository.PossiblePathsRepository;
import org.air.care.service.PossiblePathsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PossiblePathsService implementation
 * 
 * @author malalanayake
 *
 */
@Service
@Transactional
public class PossiblePathsServiceImpl implements PossiblePathsService {

	@Autowired
	PossiblePathsRepository possiblePathsRepository;

	@Override
	public List<PossiblePaths> getAllPossiblePaths(String source,
			String destination) {
		return possiblePathsRepository.findPathsByAirports(source, destination);
	}

	@Override
	public PossiblePaths save(PossiblePaths paths) {
		return possiblePathsRepository.save(paths);
	}

}
