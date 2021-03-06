package com.zopper.bsi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zopper.bsi.enums.RequestSource;
import com.zopper.bsi.enums.RequestStatus;
import com.zopper.bsi.enums.RequestType;

import java.time.Clock;
import java.util.Date;

@Entity
@Table(name = "brand_service_request")
public class ServiceRequest extends BaseModel {

	public ServiceRequest() {
		this.requestStatus = RequestStatus.REQUEST_CREATED;
		this.dateOfRequest = new Date(Clock.systemUTC().millis()).toString();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8647014155575488587L;

	@Column(name = "DATE_OF_REQUEST")
	private String dateOfRequest;
	
	@Column(name = "REQUEST_TYPE")
	@Enumerated(EnumType.STRING)
	private RequestType requestType;

	@Column(name = "REQUEST_SOURCE")
	@Enumerated(EnumType.STRING)
	private RequestSource requestSource;

	@Column(name = "REQUEST_STATUS")
	@Enumerated(EnumType.STRING)
	private RequestStatus requestStatus;

	@Column(name = "BRAND_ID")
	private String brandId;
	
	@Column(name = "SPECIFIC_BRAND_ID")
	private Long specificBrandId;
	
	@Column(name = "REFERENCE_NUMBER")
	private String referenceNumber;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BRAND_SERVICE_ONBOARD_DATA_ID")
	private ServiceOnboardSummary serviceOnboardSummary;

	public String getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(String dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public RequestSource getRequestSource() {
		return requestSource;
	}

	public void setRequestSource(RequestSource requestSource) {
		this.requestSource = requestSource;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public ServiceOnboardSummary getServiceOnboardSummary() {
		return serviceOnboardSummary;
	}

	public void setServiceOnboardSummary(ServiceOnboardSummary serviceOnboardSummary) {
		this.serviceOnboardSummary = serviceOnboardSummary;
	}

	public Long getSpecificBrandId() {
		return specificBrandId;
	}

	public void setSpecificBrandId(Long specificBrandId) {
		this.specificBrandId = specificBrandId;
	}
	
}
