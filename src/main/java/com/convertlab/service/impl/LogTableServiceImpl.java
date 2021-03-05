package com.convertlab.service.impl;

import com.convertlab.entity.LogTable;
import com.convertlab.mapper.LogTableMapper;
import com.convertlab.model.LoginUserReq;
import com.convertlab.service.ILogTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.convertlab.utils.HttpUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limei
 * @since 2021-03-04
 */
@Service
public class LogTableServiceImpl extends ServiceImpl<LogTableMapper, LogTable> implements ILogTableService {

    @Autowired
    private LogTableMapper logTableMapper;

    @Autowired
    private RestTemplate restTemplate;

    private static final String HOST_PATH = "http://localhost:8080/";

    @Override
    public int insertException(LogTable logTable) {
        int a=logTableMapper.insert(logTable);
        return a;
    }

    @Override
    public void revokeRestAndInsertLog() throws JsonProcessingException {
        LoginUserReq loginUserReq = new LoginUserReq();
        loginUserReq.setUserName("limei01");
        loginUserReq.setPassword("123456");

        String interfaceName = "login";
        JSONObject jsonObject = new JSONObject();
        //把对象转换JSON格式字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String requestParam = objectMapper.writeValueAsString(loginUserReq);
        try {
            jsonObject = HttpUtils.post(this.restTemplate, HOST_PATH,interfaceName,requestParam);
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            LogTable logTable = new LogTable();
            logTable.setApiName(interfaceName);
            logTable.setRequestBody(objectMapper.writeValueAsString(requestParam));
            logTable.setReturnResult(jsonObject.toString());
            this.insertException(logTable);
        }
    }
}
