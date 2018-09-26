package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.AccountInfo;
import com.xtzn.vo.DataRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 功能描述: <br>
 * 账号信息业务
 *
 * @author zyw
 * @version [版本号, 2018年4月11日]
 */
public interface IAccountInfoBusiness {

    /**
     * 功能描述: <br>
     * 根据页码获取账号信息
     *
     * @param pageIndex 页码
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveAccountInfoByPage(DataRequest dataRequest);

    /**
     * 功能描述: <br>
     * 查看单个账号信息
     *
     * @param id 账号信息id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveSingleAccountInfo(Integer id);

    /**
     * 功能描述: <br>
     * 更新账号信息
     *
     * @param map 账号信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateAccountInfo(AccountInfo accountInfo);

    /**
     * 功能描述: <br>
     * 更新账号信息状态
     *
     * @param status 账号信息状态
     * @param id     账号信息id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateAccountInfoByStatus(Byte status, Integer id);

    /**
     * 功能描述: <br>
     * 删除单个账号信息
     *
     * @param id 要删除的账号信息id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteSingleAccountInfo(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除账号信息
     *
     * @param list 要删除的账号信息id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteBatchAccountInfo(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的账号信息
     *
     * @param map 账号信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public CSResponse createAccountInfo(String user, Integer type, Integer userId);

    public CSResponse deleteBatchByCondition(DataRequest dataRequest);

    public CSResponse uploadAccountInfo(HttpServletRequest request, MultipartFile file);
}
