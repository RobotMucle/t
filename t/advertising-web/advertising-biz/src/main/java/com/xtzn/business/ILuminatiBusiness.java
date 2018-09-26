package com.xtzn.business;

import com.xtzn.click.vo.CSResponse;
import com.xtzn.mapper.entity.Luminati;
import com.xtzn.vo.CSRequest;

import java.util.List;

/**
 * 功能描述: <br>
 * luminati业务
 *
 * @author zyw
 * @version [版本号, 2018年4月10日]
 */
public interface ILuminatiBusiness {

    /**
     * 功能描述: <br>
     * 根据页码获取liminati信息
     *
     * @param pageIndex 页码
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveLuminatiByPage(CSRequest csRequest);

    /**
     * 功能描述: <br>
     * 查看单个liminati信息
     *
     * @param id liminati id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse retrieveSingleLuminati(Integer id);

    /**
     * 功能描述: <br>
     * 更新liminati信息
     *
     * @param map liminati相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateLuminati(Luminati luminati);

    /**
     * 功能描述: <br>
     * 更换正在使用的liminati
     *
     * @param id liminati id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse updateLuminatiByStatus(Luminati luminati);

    /**
     * 功能描述: <br>
     * 删除单个liminati信息
     *
     * @param id 要删除的liminati id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteSingleLuminati(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除liminati信息
     *
     * @param list 要删除的liminati id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public CSResponse deleteBatchLuminati(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的liminati信息
     *
     * @param map liminati相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public CSResponse createLuminati(Luminati luminati);
}
