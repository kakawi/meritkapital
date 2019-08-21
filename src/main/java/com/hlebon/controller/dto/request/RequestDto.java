package com.hlebon.controller.dto.request;

import java.util.List;

public class RequestDto {
    private List<Dto> test;

    public List<Dto> getTest() {
        return test;
    }

    public RequestDto setTest(List<Dto> test) {
        this.test = test;
        return this;
    }
}
