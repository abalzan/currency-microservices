package com.andrei.microservices.limitsservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties("limits-service")
public class LimitConfiguration {

    private int minimum;
    private int maximum;
}
xclip -sel clip < ~/.ssh/id_rsa.pubxclip -sel clip < ~/.ssh/id_rsa.pub