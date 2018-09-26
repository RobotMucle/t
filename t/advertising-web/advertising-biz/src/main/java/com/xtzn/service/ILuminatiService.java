package com.xtzn.service;

import com.xtzn.mapper.entity.Luminati;

import java.util.List;

public interface ILuminatiService {

    /**
     * 功能描述: <br>
     * 获取在使用的luminati账号信息
     *
     * @author zyw
     * @version [版本号, 2018年3月19日]
     */
    public Luminati selectByStatus(Integer userId);

    /**
     * 功能描述: <br>
     * 根据页码获取luminati信息
     *
     * @param pageSize 页面大小
     * @param skips    从哪条数据开始
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public List<Luminati> selectLuminatiByPageIndex(Integer userId, Integer skips, Integer pageSize);

    /**
     * 功能描述: <br>
     * 查看单个luminati信息
     *
     * @param id luminati id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public Luminati selectLuminatiById(Integer id);

    /**
     * 功能描述: <br>
     * 更新luminati信息
     *
     * @param map luminati相关信息
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateLuminatiContent(Luminati luminati);

    /**
     * 功能描述: <br>
     * 更换使用的luminati
     *
     * @param id luminati id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int updateLuminatiStatus(Luminati luminati);

    /**
     * 功能描述: <br>
     * 删除单个luminati信息
     *
     * @param id 要删除的luminati id
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteById(Integer id);

    /**
     * 功能描述: <br>
     * 批量删除luminati信息
     *
     * @param list 要删除的luminati id集合
     * @author zyw
     * @version [版本号, 2018年4月9日]
     */
    public int deleteBatchById(List<Integer> list);

    /**
     * 功能描述: <br>
     * 创建新的luminati信息
     *
     * @param map luminati相关信息
     * @author zyw
     * @version [版本号, 2018年4月10日]
     */
    public int insertLuminati(Luminati luminati);

    public Integer selectCount(Integer userId);
}
