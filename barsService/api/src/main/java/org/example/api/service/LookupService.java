package org.example.api.service;


import org.example.remote.DisciplineService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class LookupService {

    private Context context;

    @PostConstruct
    private void init() throws NamingException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "http://localhost:10080/tomee/ejb");

        this.context = new InitialContext(properties);
    }

    @Produces
    public DisciplineService getDisciplineService() throws NamingException {
        return (DisciplineService) context.lookup("java:/global/ejb/DisciplineServiceImpl!org.example.remote.DisciplineService");
    }
}
