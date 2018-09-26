package com.xtzn.business.impl;

import com.xtzn.business.IIdfaBusiness;
import com.xtzn.click.vo.CSResponse;
import com.xtzn.enums.ResponseEnum;
import com.xtzn.mapper.entity.Idfa;
import com.xtzn.service.IIdfaService;
import com.xtzn.vo.DataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年4月25日]
 */
@Component
public class IdfaBusinessImpl implements IIdfaBusiness {

    @Autowired
    private IIdfaService idfaService;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月25日]
     */
    @Override
    public CSResponse selectAccessibleIdfaCount(DataRequest dataRequest) {
        if ("".equals(dataRequest.getTaskName())) {
            dataRequest.setTaskName(null);
        }
        if ("".equals(dataRequest.getThirdParty())) {
            dataRequest.setThirdParty(null);
        }
        Integer count = idfaService.selectAccessibleIdfaCount(dataRequest);
        return new CSResponse(count);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年4月25日]
     */
    @Override
    public CSResponse createIdfa(Idfa idfa) {
        String idfaCode = idfa.getIdfaCode();
        String[] idfaCodes = idfaCode.split("\n");
        List<String> list = Arrays.asList(idfaCodes);
        int i = idfaService.insertIdfa(list, idfa.getThirdParty(), idfa.getUserId());
        if (i > 0) {
            return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
        }
        return new CSResponse(ResponseEnum.DATA_ERROR.getCode(), ResponseEnum.DATA_ERROR.getDesc());
    }

}
