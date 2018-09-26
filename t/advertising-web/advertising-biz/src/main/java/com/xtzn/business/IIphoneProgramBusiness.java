package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.IphoneProgram;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * 手机配置方案业务
 *
 * @author zyw
 * @version [版本号, 2018年4月11日]
 */
public interface IIphoneProgramBusiness {

    /**
     * 功能描述: <br>
     * 根据页码获取手机配置方案信息
     *
     * @param pageIndex 页码
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveIphoneProgramByPage(CSRequest csRequest);

    /**
     * 功能描述: <br>
     * 查看单个手机配置方案信息
     *
     * @param id 手机配置方案id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveSingleIphoneProgram(Integer id);

    /**
     * 功能描述: <br>
     * 更新手机配置方案信息
     *
     * @param map 手机配置方案相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateIphoneProgram(IphoneProgram iphoneProgram);

    /**
     * 功能描述: <br>
     * 更换使用的手机配置方案
     *
     * @param id 手机配置方案id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateIphoneProgramByStatus(IphoneProgram iphoneProgram);

    /**
     * 功能描述: <br>
     * 删除单个手机配置方案信息
     *
     * @param id 要删除的手机配置方案id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteSingleIphoneProgram(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除手机配置方案信息
     *
     * @param list 要删除的手机配置方案id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteBatchIphoneProgram(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的手机配置方案信息
     *
     * @param map 手机配置方案相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public CSResponse createIphoneProgram(IphoneProgram iphoneProgram);
}
