package com.xtzn.service;

import com.xtzn.mapper.entity.RetainedProgram;

import java.util.List;

/**
 * 功能描述: <br>
 * 留存方案curd
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
public interface IRetainedProgramService {

    /**
     * 功能描述: <br>
     * 根据页码获取留存方案信息
     *
     * @param pageSize 页面大小
     * @param skips    从哪条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<RetainedProgram> selectRetainedProgramByPageIndex(Integer userId, Integer skips, Integer pageSize);

    /**
     * 功能描述: <br>
     * 查看单个留存方案信息
     *
     * @param id 留存方案id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public RetainedProgram selectRetainedProgramById(Integer id);

    /**
     * 功能描述: <br>
     * 更新留存方案信息
     *
     * @param map 留存方案相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateRetainedProgramContent(RetainedProgram retainedProgram);

    /**
     * 功能描述: <br>
     * 更新留存方案状态
     *
     * @param status 留存方案状态
     * @param id     留存方案id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateRetainedProgramStatus(Byte status, Integer id);

    /**
     * 功能描述: <br>
     * 删除单个留存方案信息
     *
     * @param id 要删除的留存方案id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteById(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除留存方案信息
     *
     * @param list 要删除的留存方案id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteBatchById(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的留存方案信息
     *
     * @param map 留存方案相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public int insertRetainedProgram(RetainedProgram retainedProgram);

    /**
     * 功能描述: <br>
     * 查询使用中的留存方案
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    public List<RetainedProgram> selectUsingRetainedProgram(Integer userId);

    public Integer selectCount(Integer userId);
}
