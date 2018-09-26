package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.PersonType;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月16日]
 */
public interface IPersonTypeBusiness {

    public CSResponse retrievePersonTypeByPageIndex(CSRequest csRequest);

    public CSResponse retrieveAllPersonType(PersonType personType);

    public CSResponse retrievePersonTypeById(Integer id);

    public CSResponse createPersonType(PersonType personType);

    public CSResponse modifyPersonTypeContent(PersonType personType);

    public CSResponse deleteBatchById(List<Integer> list);

    public CSResponse deleteById(Integer id);
}
