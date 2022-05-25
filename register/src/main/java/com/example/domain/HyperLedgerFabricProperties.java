package com.example.domain;

import jdk.nashorn.internal.objects.annotations.Property;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "fabric")
@Data
public class HyperLedgerFabricProperties {

    @Property
    String networkConnectionConfigPath;

    @Property
    String certificatePath;

    @Property
    String privateKeyPath;
}