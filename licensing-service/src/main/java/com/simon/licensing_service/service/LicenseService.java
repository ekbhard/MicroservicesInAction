package com.simon.licensing_service.service;

import com.simon.licensing_service.model.License;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseService {

	public final MessageSource messageSource;

	public LicenseService(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public License getLicense(String licenseId, String organisationId) {
		return License.builder()
				       .id(new Random().nextInt())
				       .licenseId(licenseId)
				       .description("descr")
				       .organisationId(organisationId)
				       .productName("product 1")
				       .licenseType("full")
				       .build();
	}

	public String createLicense(License license, String organisationId, Locale locale) {
		String responseMessage = null;
		if (license != null) {
			license.setOrganisationId(organisationId);
			responseMessage = messageSource.getMessage("license.create.message", null, locale);
		}
		return responseMessage;
	}

	public String updateLicense(License license, String organizationId, Locale locale) {
		String responseMessage = null;
		if (license != null) {
			license.setOrganisationId(organizationId);
			responseMessage = String.format(
					messageSource.getMessage("license.update.message", null, locale), license.toString()
			);
		}
		return responseMessage;
	}

	public String deleteLicense(String licenseId, String organizationId) {
		String responseMessage = null;
		responseMessage = String.format(
				"Deleting license with id %s for the organization %s",
				licenseId, organizationId);
		return responseMessage;
	}
}
