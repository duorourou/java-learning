package com.github.duorourou.springintegration.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class IntegrationConfiguration {

    @Bean
    public MessageChannel createCellphoneCmdChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel cellphoneCreatedEventChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel cellphoneCreatedLogChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow createCellphoneFlow(CommandActivator commandActivator,
                                               LogActivator logActivator) {
        return IntegrationFlows.from(createCellphoneCmdChannel())
                .handle(commandActivator)
                .channel(cellphoneCreatedEventChannel())
                .channel(cellphoneCreatedLogChannel())
                .handle(logActivator)
                .get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata defaultPoller() {
        PollerMetadata metadata = new PollerMetadata();
        return metadata;
    }
}
