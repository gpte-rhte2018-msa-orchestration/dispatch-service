package com.acme.ride.dispatch.tracing;

import io.opentracing.Tracer;
import io.opentracing.contrib.jms.spring.TracingJmsListenerConfigurer;
import io.opentracing.contrib.jms.spring.TracingJmsListenerEndpointRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListenerConfigurer;

@Configuration
public class TracingJmsConfiguration {

    @Bean
    public TracingJmsListenerEndpointRegistry createTracingJmsListenerEndpointRegistry(
            Tracer tracer) {
        return new TracingJmsListenerEndpointRegistry(tracer);
    }

    @Bean
    public JmsListenerConfigurer createTracingJmsListenerConfigurer(
            TracingJmsListenerEndpointRegistry registry) {
        return new TracingJmsListenerConfigurer(registry);
    }

}
