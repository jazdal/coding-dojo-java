package com.sternritter.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sternritter.relationships.models.License;
import com.sternritter.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	// Adds the LicenseRepository as a dependency:
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	// Returns all the licenses (READ):
	public List<License> allLicenses() {
		return licenseRepository.findAll();
	}
	
	// Creates a license (CREATE):
	public License create(License license) {
		return licenseRepository.save(license);
	}
	
	// Retrieves a license (READ):
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
	
	// Updates a license (UPDATE):
	public License update(License license) {
		return licenseRepository.save(license);
	}
	
	// Deletes a license (DELETE):
	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);
	}
}
