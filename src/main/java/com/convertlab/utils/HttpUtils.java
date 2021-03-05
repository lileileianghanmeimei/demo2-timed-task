package com.convertlab.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;


public class HttpUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);


    public static JSONObject post(RestTemplate restTemplate,
                                  String hostPath,
                                  String url,
                                  String jsonParam) throws JSONException, JsonProcessingException {

       /* MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<String, String>();
        {
            for (String key : param.keySet()) {
                multiValueMap.add(key, param.get(key));
            }
        }*/

        HttpHeaders headers = new HttpHeaders();
        {
            MediaType type = MediaType.APPLICATION_JSON;
            headers.setContentType(type);
            headers.add("Accept", MediaType.ALL.toString());
        }
        log.info("url:{} parm:{} ", hostPath + url, jsonParam);
        ObjectMapper objectMapper = new ObjectMapper();
        String retJson = restTemplate.postForObject(hostPath + url, new HttpEntity(jsonParam, headers), String.class);
        if(StringUtils.isEmpty(retJson)){
            throw  new RuntimeException("requset 请求结果为空");
        }
        log.info("result:{}", retJson);
        return new JSONObject(retJson);
    }

}
