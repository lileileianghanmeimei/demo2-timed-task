package com.convertlab.controller;


import com.convertlab.service.ILogTableService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author limei
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/convertlab/log-table")
@EnableScheduling
public class LogTableController {

    @Autowired
    private ILogTableService iLogTableService;

    @Scheduled(cron = "0/30 * * * * ?")
    public void testRestInterface() throws JsonProcessingException {
        iLogTableService.revokeRestAndInsertLog();
        System.out.println("xxxxxxxxxxxxx");
    }

}
