package com.minseok.domain

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.minseok.data", "com.minseok.domain")
class DomainConfigure {
}