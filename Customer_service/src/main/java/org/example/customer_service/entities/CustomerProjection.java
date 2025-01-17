package org.example.customer_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer",types =
        customer.class)
interface CustomerProjection extends Projection{

    public Long getId();
    public String getName();
    public String getEmail();

}