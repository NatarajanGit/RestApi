package com.rest.api.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.rest.api.exception.DataNotFoundException;
import com.rest.api.pojo.Address;
import com.rest.api.pojo.ErrorMessage;
import com.rest.api.pojo.Member;
import com.rest.api.pojo.MessageFilterBean;

@Path("members")
public class MemberResource {

	static List<Member> memberList = new ArrayList<Member>();

	static {

		Member m = new Member();
		m.setMembId(101);
		m.setMembName("Kumaresh");

		Member m1 = new Member();
		m1.setMembId(102);
		m1.setMembName("Venkat");

		Member m2 = new Member();
		m2.setMembId(103);
		m2.setMembName("Suban");

		Member m3 = new Member();
		m3.setMembId(104);
		m3.setMembName("McGill");

		memberList.add(m);
		memberList.add(m1);
		memberList.add(m2);
		memberList.add(m3);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> getMembers() {
		return memberList;
	}
	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public List<Member>
	 * getMemberById(@QueryParam("start") int start, @QueryParam("stop") int stop) {
	 * 
	 * List<Member> mList = new ArrayList<Member>(); for (Member m1 : memberList) {
	 * if ((m1.getMembId() >=start) && (m1.getMembId() <=stop)) mList.add(m1); }
	 * return mList; }
	 */

	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String handleParams(@BeanParam MessageFilterBean messageFilterBean) {
		if (messageFilterBean.getToken().equals("Allowed"))
			return messageFilterBean.getHelloMessage();
		else
			return "Invalid Login";

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{memberId}")
	public Response getMember(@PathParam("memberId") int membId, @Context UriInfo uriInfo) {
		for (Member m1 : memberList) {
			if ((m1.getMembId() == membId))
				return Response.created(uriInfo.getAbsolutePath()).entity(m1).build();
		}
		ErrorMessage err = new ErrorMessage("Err01","Error Thrown from WebApplicationContext");
		Response response = Response.status(Status.NOT_FOUND).entity(err).build();
		throw new WebApplicationException(response);
	}
	
	@Path("{memberId}/address")
	public AddressResource getAddress() {
		return new AddressResource();
		
	}

}
