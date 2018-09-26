package com.xtzn.mapper;

import com.xtzn.mapper.entity.TaskRecord;

public interface ITaskRecordMapper {

    /**
     * 功能描述: <br>
     * 插入任务历史记录
     *
     * @param taskReport 任务历史记录数据
     * @author zyw
     * @version [版本号, 2018年4月6日]
     */
    public int insertTaskReport(TaskRecord taskReport);


}