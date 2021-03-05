package com.convertlab.service;

import com.convertlab.entity.LogTable;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author limei
 * @since 2021-03-04
 */
public interface ILogTableService extends IService<LogTable> {


    /**
     * 插入调用接口返回信息
     * @return
     */
    int insertException(LogTable logTable);

    void revokeRestAndInsertLog() throws JsonProcessingException;

}
