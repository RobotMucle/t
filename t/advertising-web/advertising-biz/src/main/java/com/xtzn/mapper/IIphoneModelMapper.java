package com.xtzn.mapper;
/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月14日]
 */

import com.xtzn.mapper.entity.IphoneModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IIphoneModelMapper {

    public IphoneModel selectIphoneModelById(@Param("id") Integer id);

    public List<IphoneModel> selectIphoneModelByPage(@Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    public List<IphoneModel> selectAllIphoneModelByPage(@Param("skips") Integer skips, @Param("pageSize") Integer pageSize);

    public int insertIphoneModel(IphoneModel iphoneModel);

    public int updateIphoneModel(IphoneModel iphoneModel);

    public int deleteById(@Param("id") Integer id);

    public int deleteBatchById(@Param("list") List<Integer> list);

    public Integer selectCount();
}
