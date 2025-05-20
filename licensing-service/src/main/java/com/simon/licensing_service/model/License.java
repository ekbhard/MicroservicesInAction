package com.simon.licensing_service.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class License {

	private int id;
	private String licenseId;
	private String description;
	private String organisationId;
	private String productName;
	private String licenseType;

}
