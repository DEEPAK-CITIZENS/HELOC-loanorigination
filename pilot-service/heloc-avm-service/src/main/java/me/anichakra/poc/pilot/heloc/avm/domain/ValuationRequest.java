package me.anichakra.poc.pilot.heloc.avm.domain;

import java.io.Serializable;

public class ValuationRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String propertyAddress;
	private String propertyType;

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
}
