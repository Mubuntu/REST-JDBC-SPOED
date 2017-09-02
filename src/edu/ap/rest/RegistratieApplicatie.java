package edu.ap.rest;

import org.restlet.Restlet;
import org.restlet.routing.Router;

public class RegistratieApplicatie extends Restlet {
	  /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance of StudentResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("/registratieTable", RegistratieResource.class);

        return router;
    }

}
