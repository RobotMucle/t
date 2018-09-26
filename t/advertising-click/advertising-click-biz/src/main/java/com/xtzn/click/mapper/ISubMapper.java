package com.xtzn.click.mapper;

import org.apache.ibatis.annotations.Param;

public interface ISubMapper {

    public int insertSub(@Param("subId") String subId);

    public String selectSubId(@Param("subId") String subId);
}
