package com.xtzn.mapper;

import com.xtzn.mapper.entity.RetainedProgram;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述: <br>
 * 留存方案curd
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
public interface IRetainedProgramMapper {

    /**
     * 功能描述: <br>
     * 根据页码获取留存方案信息
     *
     * @param pageSize 页面大小
     * @param skips    从哪条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<RetainedProgram> selectRetainedProgramByPageIndex(@Param("userId") Integer userId, @Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    /**
     * 功能描述: <br>
     * 查看单个留存方案信息
     *
     * @param id 留存方案id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public RetainedProgram selectRetainedProgramById(@Param("id") Integer id);

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
    public int updateRetainedProgramStatus(@Param("status") Byte status, @Param("id") Integer id);

    /**
     * 功能描述: <br>
     * 删除单个留存方案信息
     *
     * @param id 要删除的留存方案id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteById(@Param("id") Integer id);

    /**
     * 功能描述: <br>
     * 批量删除留存方案信息
     *
     * @param list 要删除的留存方案id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteBatchById(@Param("list") List<Integer> list);

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
    public List<RetainedProgram> selectUsingRetainedProgram(@Param("userId") Integer userId);

    public Integer selectCount(@Param("userId") Integer userId);
}
