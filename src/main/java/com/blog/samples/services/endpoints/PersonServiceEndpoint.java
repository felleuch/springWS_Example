package com.blog.samples.services.endpoints;

import com.blog.samples.services.PersonService;
import com.blog.samples.webservices.personservice.PersonDetailRequest;
import com.blog.samples.webservices.personservice.PersonDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by faiez.elleuch on 13/03/14.
 */


@Endpoint
public class PersonServiceEndpoint {

	private static final String TARGET_NAMESPACE = "http://com/blog/samples/webservices/personservice";

	@Autowired
	PersonService personService_i;


	@PayloadRoot(localPart = "PersonDetailRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload	PersonDetailResponse getPersonInfosById(@RequestPayload PersonDetailRequest personDetailRequest){

		PersonDetailResponse personDetailResponse = new PersonDetailResponse();


		personDetailResponse.setCodeRetour("OK");
		personDetailResponse.setPersonInfos(personService_i.getPersonById(personDetailRequest.getIdPerson()));

		return personDetailResponse;
	}

	public void setPersonService_i(PersonService personService_i) {
		this.personService_i = personService_i;
	}
}
