package com.xtzn.click.mapper;

import com.xtzn.click.mapper.entity.Luminati;
import org.apache.ibatis.annotations.Param;

public interface ILuminatiMapper {

    public Luminati selectByStatus(@Param("userId") Integer userId);
}
