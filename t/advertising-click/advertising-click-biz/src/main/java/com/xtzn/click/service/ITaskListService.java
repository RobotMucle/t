package com.xtzn.click.service;

import com.xtzn.click.mapper.entity.TaskList;

public interface ITaskListService {
    /**
     * 功能描述: <br>
     * 根据任务id查询跑点击业务需要的数据：任务状态，任务cr值，国家，link以及是否处于跑点击状态
     *
     * @param taskId 任务id
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    public TaskList selectForRunClick(Integer taskId);

    /**
     * 功能描述: <br>
     * 更新任务跑点击总数
     *
     * @param id 任务id
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    public void updateClickNum(Integer id);

    /**
     * 功能描述: <br>
     * 更新任务是否处于跑点击状态
     *
     * @param id 任务id
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    public void updateIsUnlockClick(Integer id, Byte isUnlockClick);


}
