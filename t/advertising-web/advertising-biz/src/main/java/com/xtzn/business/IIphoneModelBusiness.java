package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.IphoneModel;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月14日]
 */
public interface IIphoneModelBusiness {

    public CSResponse retrieveIphoneModelById(Integer id);

    public CSResponse retrieveIphoneModelByPage(CSRequest csRequest);

    public CSResponse createIphoneModel(IphoneModel iphoneModel);

    public CSResponse updateIphoneModel(IphoneModel iphoneModel);

    public CSResponse deleteById(Integer id);

    public CSResponse deleteBatchById(List<Integer> list);
}
