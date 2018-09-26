package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月23日]
 */
public interface INoReturnAllianceBusiness {

    public CSResponse selectNoReturnAllianceByPage(CSRequest csRequest);

    public CSResponse deleteBatchById(List<Integer> list);

    public CSResponse insertNoReturnAlliance(List<String> list, Integer userId);
}
