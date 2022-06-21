package it.univaq.sosygroup.ticketingsystem.prototype.loadbalancers.lbticketservice.configuration;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class TicketServiceConfiguration {

    @Bean
    @Primary
    ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new TicketServiceInstanceListSupplier("ticketservice");
    }
}

class TicketServiceInstanceListSupplier implements ServiceInstanceListSupplier {

    private final String serviceId;

    TicketServiceInstanceListSupplier(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

    /*
     * REFINE: Move this hard-coded information to a configuration file
     */
    @Override
    public Flux<List<ServiceInstance>> get() {
        return Flux.just(Arrays
                .asList(new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8150, false),
                        new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8151, false),
                        new DefaultServiceInstance(serviceId + "3", serviceId, "localhost", 8152, false)));
    }
}
