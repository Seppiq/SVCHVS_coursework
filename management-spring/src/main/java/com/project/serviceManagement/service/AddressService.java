package com.project.serviceManagement.service;

import java.util.List;

import com.project.serviceManagement.model.Address;

public interface AddressService {
	public Address addAddress(Address Address) ;
	public Address updteAddress(Address Address,Integer id);
	public void deleteAddress(Integer id);
	public List<Address> viewAddress();
	public Address getAddress(Integer id);
	List<Address> getAddressByCustomerId(Integer id);
}
