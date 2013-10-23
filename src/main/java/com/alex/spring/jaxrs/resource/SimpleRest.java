package com.alex.spring.jaxrs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/restful")
public class SimpleRest {

	@GET
	@Produces("text/html")
	public String getHello(){
		System.out.println("In Secure rest with Spring Sequrity");
		return "<html>" + "<body><b>Hello, my friend!</b><hr/>"
				+ "<h2 align=\"center\">This is simple Rest servise with Spring Sequrity!!!</h2>"
				+ "</body></html>";
	}
}
