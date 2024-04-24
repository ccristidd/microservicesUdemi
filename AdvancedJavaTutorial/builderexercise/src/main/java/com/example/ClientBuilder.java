package com.example;

import lombok.Builder;

public class ClientBuilder {

    @Builder(builderMethodName = "immutableClientBuilder")
    public static ImmutableClient newClient(int id, String name){
        return new ImmutableClient(id,name);
    }
}
