package com.rest.api.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.api.pojo.Address;

@Path("/")
public class AddressResource {

	static List<Address> addressList = new ArrayList<Address>();

	static {

		Address address = new Address();
		address.setAddressId(501);
		address.setStreetName("Adam Street");
		address.setCity("Chennai");
		address.setState("TamilNadu");

		addressList.add(address);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{addressId}")
	public Address getAddress(@PathParam("addressId") int addressId, @PathParam("memberId") int memberId) {
		
		System.out.println("MemberId : "+memberId);
		for (Address address : addressList) {
			if (address.getAddressId() == addressId)
				return address;
		}
		return null;
	}
}
