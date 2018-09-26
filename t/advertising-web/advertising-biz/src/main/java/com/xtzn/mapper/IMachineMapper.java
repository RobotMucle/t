package com.xtzn.mapper;

import com.xtzn.mapper.entity.Machine;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年7月10日]
 */
public interface IMachineMapper {

    public List<Machine> selectMachineByAndCondition(Machine machine);

    public List<Machine> selectMachineByOrCondition(Machine machine);

    public int insertMachine(Machine machine);

    public int updateMachine(Machine machine);

    public int deleteMachine(Machine machine);
}
