package com.xtzn.service.impl;

import com.xtzn.mapper.ITaskConfigurationMapper;
import com.xtzn.mapper.entity.TaskConfiguration;
import com.xtzn.service.ITaskConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月19日]
 */
@Service
public class TaskConfigurationServiceImpl implements ITaskConfigurationService {

    @Autowired
    private ITaskConfigurationMapper taskConfigurationDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public List<Map<String, Object>> selectTaskConfigurationByPage(Integer skips, Integer pageSize) {

        return taskConfigurationDao.selectTaskConfigurationByPage(skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public List<Map<String, Object>> selectAllTaskConfiguration(Integer userId) {

        return taskConfigurationDao.selectAllTaskConfiguration(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Map<String, Object> selectTaskConfigurationById(Integer id) {

        return taskConfigurationDao.selectTaskConfigurationById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public Integer selectCount() {

        return taskConfigurationDao.selectCount();
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public int deleteById(Integer id) {

        return taskConfigurationDao.deleteById(id);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public int deleteBatchById(List<Integer> list) {

        return taskConfigurationDao.deleteBatchById(list);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public int insertTaskConfiguration(TaskConfiguration taskConfiguration) {

        return taskConfigurationDao.insertTaskConfiguration(taskConfiguration);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月19日]
     */
    @Override
    public int updateTaskConfiguration(TaskConfiguration taskConfiguration) {

        return taskConfigurationDao.updateTaskConfiguration(taskConfiguration);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月25日]
     */
    @Override
    public String selectConfigurationName(String configurationName, Integer userId) {

        return taskConfigurationDao.selectConfigurationName(configurationName, userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public List<String> selectBundleNameByLua(Integer userId) {

        return taskConfigurationDao.selectBundleNameByLua(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月28日]
     */
    @Override
    public List<String> selectBundleNameForTask(Integer userId) {

        return taskConfigurationDao.selectBundleNameForTask(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年5月7日]
     */
    @Override
    public List<String> selectDifferBundleName(Integer userId) {

        return taskConfigurationDao.selectDifferBundleName(userId);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月25日]
     */
    @Override
    public List<Map<String, Object>> selectTaskConfigurationByUser(Integer userId, Integer skips, Integer pageSize) {

        return taskConfigurationDao.selectTaskConfigurationByUser(userId, skips, pageSize);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年6月25日]
     */
    @Override
    public Integer selectCountByUser(Integer userId) {

        return taskConfigurationDao.selectCountByUser(userId);
    }

}
