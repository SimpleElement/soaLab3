package org.example.soa_lab3_LabService.configuration;

import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.UUID;

@Configuration
public class ConsulConfiguration {

    @Bean
    public void registerInConsul() throws MalformedObjectNameException, ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException {

        Integer port = (Integer) ManagementFactory.getPlatformMBeanServer().getAttribute(new ObjectName("jboss.as:socket-binding-group=standard-sockets,socket-binding=https"), "port");

        Consul.builder().withUrl("http://localhost:8500").build().agentClient().register(
                ImmutableRegistration.builder()
                .id(UUID.randomUUID().toString())
                .name("lab-service")
                .port(port)
                .build()
        );

        //System.out.println(Consul.builder().build().healthClient().getAllServiceInstances("lab-service").getResponse().get(0).getService().getPort());
    }
}
