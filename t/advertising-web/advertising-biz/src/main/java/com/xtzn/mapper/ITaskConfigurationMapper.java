package com.xtzn.mapper;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */

import com.xtzn.mapper.entity.TaskConfiguration;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ITaskConfigurationMapper {

    public List<Map<String, Object>> selectTaskConfigurationByPage(@Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    public List<Map<String, Object>> selectTaskConfigurationByUser(@Param("userId") Integer userId, @Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    public List<Map<String, Object>> selectAllTaskConfiguration(@Param("userId") Integer userId);

    public Map<String, Object> selectTaskConfigurationById(@Param("id") Integer id);

    public Integer selectCount();

    public Integer selectCountByUser(@Param("userId") Integer userId);

    public int deleteById(@Param("id") Integer id);

    public int deleteBatchById(@Param("list") List<Integer> list);

    public int insertTaskConfiguration(TaskConfiguration taskConfiguration);

    public int updateTaskConfiguration(TaskConfiguration taskConfiguration);

    public String selectConfigurationName(@Param("configurationName") String configurationName, @Param("userId") Integer userId);

    public List<String> selectBundleNameByLua(@Param("userId") Integer userId);

    public List<String> selectBundleNameForTask(@Param("userId") Integer userId);

    public List<String> selectDifferBundleName(@Param("userId") Integer userId);
}
