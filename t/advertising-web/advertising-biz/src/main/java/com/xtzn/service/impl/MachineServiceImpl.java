package com.xtzn.service.impl;

import com.xtzn.mapper.IMachineMapper;
import com.xtzn.mapper.entity.Machine;
import com.xtzn.service.IMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述: <br>
 * **
 *
 * @author zyw
 * @version [版本号, 2018年7月10日]
 */
@Service
public class MachineServiceImpl implements IMachineService {

    @Autowired
    private IMachineMapper machineDao;

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年7月10日]
     */
    @Override
    public List<Machine> selectMachineByAndCondition(Machine machine) {

        return machineDao.selectMachineByAndCondition(machine);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年7月10日]
     */
    @Override
    public List<Machine> selectMachineByOrCondition(Machine machine) {

        return machineDao.selectMachineByOrCondition(machine);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年7月10日]
     */
    @Override
    public int insertMachine(Machine machine) {

        return machineDao.insertMachine(machine);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年7月10日]
     */
    @Override
    public int updateMachine(Machine machine) {

        return machineDao.updateMachine(machine);
    }

    /**
     * 功能描述: <br>
     * **
     *
     * @author zyw
     * @version [版本号, 2018年7月10日]
     */
    @Override
    public int deleteMachine(Machine machine) {

        return machineDao.deleteMachine(machine);
    }

}
