package com.xtzn.service;

import com.xtzn.mapper.entity.TaskConfiguration;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */
public interface ITaskConfigurationService {

    public List<Map<String, Object>> selectTaskConfigurationByPage(Integer skips, Integer pageSize);

    public List<Map<String, Object>> selectTaskConfigurationByUser(Integer userId, Integer skips, Integer pageSize);

    public List<Map<String, Object>> selectAllTaskConfiguration(Integer userId);

    public Map<String, Object> selectTaskConfigurationById(Integer id);

    public Integer selectCount();

    public Integer selectCountByUser(Integer userId);

    public int deleteById(Integer id);

    public int deleteBatchById(List<Integer> list);

    public int insertTaskConfiguration(TaskConfiguration taskConfiguration);

    public int updateTaskConfiguration(TaskConfiguration taskConfiguration);

    public String selectConfigurationName(String configurationName, Integer userId);

    public List<String> selectBundleNameByLua(Integer userId);

    public List<String> selectBundleNameForTask(Integer userId);

    public List<String> selectDifferBundleName(Integer userId);
}
