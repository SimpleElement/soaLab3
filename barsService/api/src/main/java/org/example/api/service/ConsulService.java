package org.example.api.service;

import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.sun.net.httpserver.HttpsServer;

import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServlet;
import java.util.UUID;

public class ConsulService {

    @EJB
    private HttpServlet httpServlet;

    @Produces
    public void registerInConsul() {
        Consul.builder().withUrl("http://localhost:8500").build().agentClient().register(
                ImmutableRegistration.builder()
                        .id(UUID.randomUUID().toString())
                        .name("bars-service")
                        .port(Integer.parseInt(httpServlet.getInitParameter("httpsPort")))
                        .build()
        );
    }
}
