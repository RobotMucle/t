package com.xtzn.service;

import com.xtzn.mapper.entity.IphoneModel;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月14日]
 */
public interface IIphoneModelService {

    public IphoneModel selectIphoneModelById(Integer id);

    public List<IphoneModel> selectIphoneModelByPage(Integer skips, Integer pageSize);

    public List<IphoneModel> selectAllIphoneModelByPage(Integer skips, Integer pageSize);

    public int insertIphoneModel(IphoneModel iphoneModel);

    public int updateIphoneModel(IphoneModel iphoneModel);

    public int deleteById(Integer id);

    public int deleteBatchById(List<Integer> list);

    public Integer selectCount();
}
