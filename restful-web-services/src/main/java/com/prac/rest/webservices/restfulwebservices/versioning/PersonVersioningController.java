package com.prac.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	// Path based versioning
	
	@RequestMapping(value="/v1/Person", method=RequestMethod.GET)
	public PersonV1 getPersonV1() {
		return new PersonV1("Rajneesh Kochhar");
	}

	@RequestMapping(value="/v2/Person", method=RequestMethod.GET)
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Rajneesh","Kochhar"));
	}

	
	
	
	// Parameter based versioning

	@RequestMapping(value="/Person/param", params="version=v1")
	public PersonV1 getParamV1() {
		return new PersonV1("Rajneesh Kochhar");
	}

	@RequestMapping(value="/Person/param", params="version=v2")
	public PersonV2 getParamV2() {
		return new PersonV2(new Name("Rajneesh","Kochhar"));
	}

	
	// Header based versioning

	@RequestMapping(value="/Person/param", headers="X-API-Version=1")
	public PersonV1 getHeaderV1() {
		return new PersonV1("Rajneesh Kochhar");
	}

	@RequestMapping(value="/Person/param", headers="X-API-Version=2")
	public PersonV2 getHeaderV2() {
		return new PersonV2(new Name("Rajneesh","Kochhar"));
	}


	// Content Negotiation / Accept Versioning based versioning

	@RequestMapping(value="/Person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 getProducesV1() {
		return new PersonV1("Rajneesh Kochhar");
	}

	@RequestMapping(value="/Person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 getProducesV2() {
		return new PersonV2(new Name("Rajneesh","Kochhar"));
	}

	
}
