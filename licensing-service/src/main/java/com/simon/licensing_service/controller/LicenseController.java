package com.simon.licensing_service.controller;

import com.simon.licensing_service.model.License;
import com.simon.licensing_service.service.LicenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping(value = "v1/organisation/{organizationId}/license")
public class LicenseController {

	private final LicenseService licenseService;

	public LicenseController(LicenseService service) {
		this.licenseService = service;
	}

	@GetMapping(value = "/{licenseId}")
	public ResponseEntity<License> getLicense(@PathVariable String organizationId,
	                                          @PathVariable String licenseId) {
		License license = licenseService.getLicense(licenseId, organizationId);
		return ResponseEntity.ok(license);
	}

	@PutMapping
	public ResponseEntity<String> updateLicense(
			@PathVariable("organizationId")
			String organizationId,
			@RequestBody License request,
			@RequestHeader(value = "Accept-Language", required = false)
			Locale locale) {
		return ResponseEntity.ok(
				licenseService.updateLicense(request, organizationId, locale));
	}

	@PostMapping
	public ResponseEntity<String> createLicense(
			@PathVariable("organizationId") String organizationId,
			@RequestBody License request,
			@RequestHeader(value = "Accept-Language", required = false)
			Locale locale) {
		return ResponseEntity.ok(licenseService.createLicense(request, organizationId, locale));
	}

	@DeleteMapping(value = "/{licenseId}")
	public ResponseEntity<String> deleteLicense(
			@PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId) {
		return ResponseEntity.ok(licenseService.deleteLicense(licenseId,
				organizationId));
	}
}
