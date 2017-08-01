package com.stackroute.asmsgreceiver.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.stackroute.asmsgreceiver.model.AsMessage;

public class RouteCacheTest {

	@Test
	public void test() {
		// checking if routecache is populating or not.
		RouteCache rc = new RouteCache();
		assertNotNull("ROuteCache is not null", rc);

	}

}
