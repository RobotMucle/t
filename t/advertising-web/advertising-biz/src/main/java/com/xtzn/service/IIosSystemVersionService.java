package com.xtzn.service;

import com.xtzn.mapper.entity.IosSystemVersion;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月14日]
 */
public interface IIosSystemVersionService {

    public IosSystemVersion selectIosSystemVersionById(Integer id);

    public List<IosSystemVersion> selectIosSystemVersionByPage(Integer skips, Integer pageSize);

    public List<IosSystemVersion> selectAllIosSystemVersionByPage(Integer skips, Integer pageSize);

    public int insertIosSystemVersion(IosSystemVersion iosSystemVersion);

    public int updateIosSystemVersion(IosSystemVersion iosSystemVersion);

    public int deleteById(Integer id);

    public int deleteBatchById(List<Integer> list);

    public List<Map<String, Object>> selectIosSystemVersionByGroup();

    public Integer selectCount();
}
