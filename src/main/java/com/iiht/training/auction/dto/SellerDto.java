package com.iiht.training.auction.dto;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
// import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SellerDto {
	private Long sellerId;
    
    @NotNull
	@Size(min = 3,max = 100, message = "sellerName should have at least 3 characters and atmost 100 characters")
	private String sellerName;
    
    @NotNull
    @Email
	@Size(min = 3,max = 100, message = "sellerEmail should have at least 3 characters and atmost 100 characters")
	private String sellerEmail;
    
    @NotNull
	@Size(min = 3,max = 100, message = "address should have at least 3 characters and atmost 100 characters")
	private String address;
    
    @NotNull
    @Min(10)
    @Max(10)
	private Long phoneNumber;

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, phoneNumber, sellerEmail, sellerId, sellerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SellerDto other = (SellerDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(sellerEmail, other.sellerEmail) && Objects.equals(sellerId, other.sellerId)
				&& Objects.equals(sellerName, other.sellerName);
	}
	
	

}