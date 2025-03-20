package com.experiment1.astrology1.service;

import com.experiment1.astrology1.dto.RequestObject;
import com.experiment1.astrology1.dto.UserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JavaReqObjToJsonReqObj {
    private UserDetails userDetails;

    @Autowired
    private UserDetailsMappingService mappingService;

    public String returnJsonObject(UserDetails userDetails) throws JsonProcessingException {
        RequestObject requestObject = mappingService.convertToRequestObject(userDetails);
        System.out.println("In JavaReqObjToJsonReqObj displaying received Req Obj "+ requestObject);

        // Define JSON request body
//    String jsonRequestBody = """
//        {
//        "day": 16,
//        "month": 10,
//        "year": 1972,
//        "hour": 7,
//        "min": 45,
//        "lat": 19.132,
//        "lon": 72.342,
//        "tzone": 5.5
//       }""";

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody = objectMapper.writeValueAsString(requestObject);

        System.out.println("In JavaReqObjToJsonReqObj displaying received JSON_Obj "+jsonRequestBody);

        return jsonRequestBody;
    }


}
