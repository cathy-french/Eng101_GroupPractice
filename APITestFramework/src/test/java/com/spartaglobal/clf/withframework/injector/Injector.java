package com.spartaglobal.clf.withframework.injector;

import com.spartaglobal.clf.withframework.dto.ActivityDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Injector {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static ActivityDTO injectActivityDTO(String path) {
        ActivityDTO activityDTO = new ActivityDTO();
        try {
            activityDTO = objectMapper.readValue(new URL(path), ActivityDTO.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return activityDTO;
    }

    // have more static methods which return different DTOs
}
