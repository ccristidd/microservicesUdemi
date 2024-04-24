package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientBuilderTest {
    //test the method builder.
    //the builder of a class is defined in another class.
    @Test
    void newClient() {
        ImmutableClient immutableClient = ClientBuilder.immutableClientBuilder()
                .id(1)
                .name("ClientName")
                .build();
        assertThat(immutableClient.getName()).isEqualTo("ClientName");
    }
}