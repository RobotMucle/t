package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.TaskConfiguration;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */
public interface ITaskConfigurationBusiness {

    public CSResponse selectTaskConfigurationByPage(CSRequest csRequest);

    public CSResponse selectTaskConfigurationByUser(CSRequest csRequest);

    public CSResponse selectAllTaskConfiguration(Integer userId);

    public CSResponse selectTaskConfigurationById(Integer id);

    public CSResponse deleteById(Integer id);

    public CSResponse deleteBatchById(List<Integer> list);

    public CSResponse insertTaskConfiguration(TaskConfiguration taskConfiguration, String users);

    public CSResponse updateTaskConfiguration(TaskConfiguration taskConfiguration);

    public CSResponse selectConfigurationName(String configurationName, Integer userId);
}
