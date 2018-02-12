package com.rest.api.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.rest.api.pojo.ErrorMessage;


public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	public Response toResponse(DataNotFoundException arg0) {
		ErrorMessage err = new ErrorMessage("Err01","Error Thrown");
		return Response.status(Status.NOT_FOUND).entity(err).build();
	}

	

}
