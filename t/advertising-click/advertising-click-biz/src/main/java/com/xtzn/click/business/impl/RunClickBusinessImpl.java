package com.xtzn.click.business.impl;

import com.xtzn.click.business.IRunClickBusiness;
import com.xtzn.click.common.StatusCommon;
import com.xtzn.click.enums.ResponseEnum;
import com.xtzn.click.mapper.entity.Header;
import com.xtzn.click.mapper.entity.Luminati;
import com.xtzn.click.mapper.entity.TaskList;
import com.xtzn.click.service.IHeaderService;
import com.xtzn.click.service.ILuminatiService;
import com.xtzn.click.service.ITaskListService;
import com.xtzn.click.utils.RunClickExcutorUtil;
import com.xtzn.click.vo.CSResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component("runClickBusiness")
public class RunClickBusinessImpl implements IRunClickBusiness {

    private static final Logger log = LoggerFactory.getLogger(RunClickBusinessImpl.class);
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1000, 2000, 5, TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable>());
    @Autowired
    private ITaskListService taskListService;
    @Autowired
    private ILuminatiService luminatiService;
    @Autowired
    private IHeaderService headerService;

    /**
     * 功能描述: <br>
     * 跑点击业务实现
     *
     * @param taskId 条件
     * @return 无返回值
     * @author zyw
     * @version [版本号, 2018年3月14日]
     */
    @Override
    public CSResponse runClick(Integer taskId, Integer userId) {

        TaskList taskList = taskListService.selectForRunClick(taskId);
        Byte status = taskList.getStatus();
        //任务状态非正常，直接结束
        if (status == 0 || status == 2) {
            return new CSResponse(ResponseEnum.TASK_STATUS_IS_ERROR.getCode(), ResponseEnum.TASK_STATUS_IS_ERROR.getDesc());
        }
        byte isRunClick = taskList.getIsRunClick();
        //任务状态正常，是否需要跑点击判断
        if (isRunClick == 0) {
            return new CSResponse(ResponseEnum.TASK_NOT_RUN_CLICK.getCode(), ResponseEnum.TASK_NOT_RUN_CLICK.getDesc());
        }
        double crValue = taskList.getCrValue();
        int clickCount = (int) Math.ceil(100 / crValue);
        //new ArrayBlockingQueue<Runnable>(5)LinkedBlockingDeque<Runnable>()
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50, 100, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        try {
            //threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
            Luminati luminati = luminatiService.selectByStatus(userId);
            String customer = luminati.getCustomer();
            String zone = luminati.getZone();
            String password = luminati.getPassword();
            Integer port = luminati.getPort();
            String country = taskList.getCountry();
            List<Header> header = headerService.selectHeader();
            String sessionUUid = null;
            //更新点击状态
            taskListService.updateIsUnlockClick(taskId, StatusCommon.successSatatusValue);
            //线程池去执行clickCnt个任务
            if (threadPoolExecutor.getQueue().size() > 10000 && userId != 3) {
                return new CSResponse(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getDesc());
            }
			/*String lpLink = taskList.getLandingPageLink();
			RunClickExcutorUtil rceu = new RunClickExcutorUtil(customer, zone, password, port, country, header, lpLink,taskId,sessionUUid,taskListService,clickCount);
            threadPoolExecutor.execute(rceu);
            System.out.println("线程池中现在的线程数目是："+threadPoolExecutor.getPoolSize()+",  队列中正在等待执行的任务数量为："+
                    threadPoolExecutor.getQueue().size()+"已完成数目:"+threadPoolExecutor.getCompletedTaskCount()+"任务总数:"+threadPoolExecutor.getTaskCount());*/

            for (int i = 0; i < clickCount; i++) {
                String lpLink = taskList.getLandingPageLink();
                //替换idfa和subid
                String subid = UUID.randomUUID().toString();
                String idfa = UUID.randomUUID().toString();
                idfa = idfa.replaceAll(String.valueOf(idfa.charAt(14)), "4");
                subid = subid.replaceAll("-", "");
                lpLink = lpLink.replace("[[subid]]", subid);
                lpLink = lpLink.replace("[[idfa]]", idfa.toUpperCase());
                sessionUUid = UUID.randomUUID().toString().replaceAll("-", "");
                RunClickExcutorUtil rceu = new RunClickExcutorUtil(customer, zone, password, port, country, header, lpLink, taskId, sessionUUid, taskListService);
                threadPoolExecutor.execute(rceu);
                System.out.println("线程池中现在的线程数目是：" + threadPoolExecutor.getPoolSize() + ",  队列中正在等待执行的任务数量为：" +
                        threadPoolExecutor.getQueue().size() + "已完成数目:" + threadPoolExecutor.getCompletedTaskCount() + "任务总数:" + threadPoolExecutor.getTaskCount());
	           /* try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}*/
            }
        }
        //关闭线程池
        finally {
            //threadPoolExecutor.shutdown();
        }
        //更新点击状态
        taskListService.updateIsUnlockClick(taskId, StatusCommon.failureStatusValue);
        return new CSResponse(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
    }


}
