package com.xtzn.click.mapper;


import com.xtzn.click.mapper.entity.TaskList;
import org.apache.ibatis.annotations.Param;

public interface ITaskListMapper {

    public TaskList selectForRunClick(@Param("id") Integer taskId);

    //更新点击数
    public void updateClickNum(@Param("id") Integer id);

    //更新点击状态
    public void updateIsUnlockClick(@Param("id") Integer id, @Param("isUnlockClick") Byte isUnlockClick);

}
