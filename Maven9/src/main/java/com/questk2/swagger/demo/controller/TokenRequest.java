package com.questk2.swagger.demo.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

public class TokenRequest {


	private static final long serialVersionUID = 1L;

	@Schema(required = true, description = "full url of the Insight feature url.....", example = "https://qa")
	private String productUrl;
	@Schema(required = true, description  = "The marketing url", example = "https://www.equilar.com")
	private String marketingUrl;
	//TODO upgrade it after swagger 3.0.0 release https://stackoverflow.com/questions/40989038/swagger-apimodelproperty-example-value-for-liststring-property/50132642#50132642
	@Schema(required = true, description  = "a list of user emails", allowableValues = "r")
	private List<String> emails;
	@Schema(required = false, description  = "a Disclosure Search keyword", example = "pay vs performance")
	private String disclosureSearchKeyword;
	
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	public String getMarketingUrl() {
		return marketingUrl;
	}
	public void setMarketingUrl(String marketingUrl) {
		this.marketingUrl = marketingUrl;
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	public String getDisclosureSearchKeyword() {
		return disclosureSearchKeyword;
	}
	public void setDisclosureSearchKeyword(String disclosureSearchKeyword) {
		this.disclosureSearchKeyword = disclosureSearchKeyword;
	}
	


}
