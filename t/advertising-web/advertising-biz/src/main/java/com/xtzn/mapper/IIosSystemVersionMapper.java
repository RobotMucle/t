package com.xtzn.mapper;

import com.xtzn.mapper.entity.IosSystemVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月14日]
 */
public interface IIosSystemVersionMapper {

    public IosSystemVersion selectIosSystemVersionById(@Param("id") Integer id);

    public List<IosSystemVersion> selectIosSystemVersionByPage(@Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    public List<IosSystemVersion> selectAllIosSystemVersionByPage(@Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    public int insertIosSystemVersion(IosSystemVersion iosSystemVersion);

    public int updateIosSystemVersion(IosSystemVersion iosSystemVersion);

    public int deleteById(@Param("id") Integer id);

    public int deleteBatchById(@Param("list") List<Integer> list);

    public List<Map<String, Object>> selectIosSystemVersionByGroup();

    public Integer selectCount();
}
