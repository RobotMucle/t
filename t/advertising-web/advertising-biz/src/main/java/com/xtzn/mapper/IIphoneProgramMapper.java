package com.xtzn.mapper;

import com.xtzn.mapper.entity.IphoneProgram;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * 手机配置方案curd
 *
 * @author zyw
 * @version [版本号, 2018年4月11日]
 */
public interface IIphoneProgramMapper {

    /**
     * 功能描述: <br>
     * 根据页码获取手机配置方案信息
     *
     * @param pageSize 页面大小
     * @param skips    从哪条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<Map<String, Object>> selectIphoneProgramByPageIndex(@Param("userId") Integer userId, @Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    /**
     * 功能描述: <br>
     * 查看单个手机配置方案信息
     *
     * @param id 手机配置方案 id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public IphoneProgram selectIphoneProgramById(@Param("id") Integer id);

    /**
     * 功能描述: <br>
     * 更新手机配置方案信息
     *
     * @param map 手机配置方案相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateIphoneProgramContent(IphoneProgram iphoneProgram);

    /**
     * 功能描述: <br>
     * 更换使用的手机配置方案
     *
     * @param id 手机配置方案 id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateIphoneProgramStatus(IphoneProgram iphoneProgram);

    /**
     * 功能描述: <br>
     * 删除单个手机配置方案信息
     *
     * @param id 要删除的手机配置方案 id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteById(@Param("id") Integer id);

    /**
     * 功能描述: <br>
     * 批量删除手机配置方案信息
     *
     * @param list 要删除的手机配置方案 id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteBatchById(@Param("list") List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的手机配置方案信息
     *
     * @param map 手机配置方案相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public int insertIphoneProgram(IphoneProgram iphoneProgram);

    public Integer selectCount(@Param("userId") Integer userId);

    public Map<String, Object> selectIphoneProgramForLua(@Param("userId") Integer userId);
}
