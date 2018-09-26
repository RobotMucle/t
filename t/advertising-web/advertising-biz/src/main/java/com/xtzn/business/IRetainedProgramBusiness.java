package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.RetainedProgram;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * 留存方案业务
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
public interface IRetainedProgramBusiness {

    /**
     * 功能描述: <br>
     * 根据页码获取留存方案信息
     *
     * @param pageIndex 页码
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveRetainedProgramByPage(CSRequest csRequest);

    /**
     * 功能描述: <br>
     * 查看单个留存方案信息
     *
     * @param id 留存方案id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveSingleRetainedProgram(Integer id);

    /**
     * 功能描述: <br>
     * 更新留存方案信息
     *
     * @param map 留存方案相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateRetainedProgram(RetainedProgram retainedProgram);

    /**
     * 功能描述: <br>
     * 更新留存方案状态
     *
     * @param status 留存方案状态
     * @param id     留存方案id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateRetainedProgramByStatus(Byte status, Integer id);

    /**
     * 功能描述: <br>
     * 删除单个留存方案信息
     *
     * @param id 要删除的留存方案id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteSingleRetainedProgram(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除留存方案信息
     *
     * @param list 要删除的留存方案id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteBatchRetainedProgram(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的留存方案信息
     *
     * @param map 留存方案相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public CSResponse createRetainedProgram(RetainedProgram retainedProgram);

    /**
     * 功能描述: <br>
     * 查询使用中的留存方案
     *
     * @author zyw
     * @version [版本号, 2018年4月13日]
     */
    public CSResponse retrieveUsingRetainedProgram(RetainedProgram retainedProgram);
}
