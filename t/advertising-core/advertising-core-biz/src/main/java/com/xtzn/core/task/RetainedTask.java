package com.xtzn.core.task;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;
import com.xtzn.core.service.IRetainedListService;
import com.xtzn.core.service.ITaskListService;
import com.xtzn.core.service.IUserService;
import com.xtzn.core.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 功能描述: <br>
 * 每日0点留存处理
 *
 * @author zyw
 * @version [版本号, 2018年3月20日]
 */
@Component
public class RetainedTask extends AbstractSimpleElasticJob {

    private static final Logger log = LoggerFactory.getLogger(RetainedTask.class);


    @Autowired
    private IRetainedListService retainedListService;
    @Autowired
    private ITaskListService taskListService;

    @Autowired
    private IUserService userService;

    /**
     * 功能描述: <br>
     * 每日0点清空昨日留存,重新生成今日留存
     *
     * @author zyw
     * @version [版本号, 2018年3月20日]
     */
    @Override
    public void process(JobExecutionMultipleShardingContext shardingContext) {

        try {
            log.info(">>>>>>开始计算今日留存");

            List<Integer> userList = userService.selectUserId();
            if (userList != null && !userList.isEmpty()) {
                Integer count = 0;
                for (int i = 0; i < userList.size(); i++) {
                    count = retainedListService.selectYestodayUndoByUserId(userList.get(i));
                    log.info("------查询昨日留存");
                    RedisUtil.hsetString("retained", String.valueOf(userList.get(i)), String.valueOf(count));
                    log.info("------昨日留存放入redis");
                }
            }

            // 清空昨日留存
            retainedListService.updateEmptyRetained();
            log.info("------数据库清空昨日留存");

            Integer taskId = null;
            String retainedPercent = null;
            Byte[] type = {0, 1, 2};

            //总公司留存模式1
            log.info(">>>>>>>>>>>>>>>>>>>>>总公司留存模式1");

            for (int i = 0; i < 3; i++) {
                //获得总公司对应任务类型的taskId的list
                List<Map<String, Object>> list = taskListService.selectByGenerateRetainedType1(type[i]);
                log.info("------获得总公司对应任务类型的taskId的列表，list.size:{}，type:{}", list.size(), type[i]);

                switch (i) {
                    //任务类型为普通类型
                    case (0):
                        log.info("-----任务类型为普通类型");

                        //遍历taskId
                        for (int j = 0; j < list.size(); j++) {
                            log.info("j:{}--{}", j, list.get(j).toString());

                            //获得本次任务的taskId
                            taskId = (Integer) list.get(j).get("id");
                            //获取任务的留存百分比方案
                            retainedPercent = (String) list.get(j).get("retainedPercent");
                            //根据taskId获取留存上传时间距离今日多少天及对应的完成任务数量的list
                            List<Map<String, Object>> countList = retainedListService.selectGroupByTaskId1(taskId);
                            //获取百分比方案的具体值
                            String[] rept = retainedPercent.split(",");
                            //遍历留存上传时间距离今日多少天及对应的完成任务数量的list
                            for (int k = 0; k < countList.size(); k++) {
                                log.info("-----{}", Arrays.toString(countList.toArray()));

                                //获取天数差
                                int daysCnt = (Integer) countList.get(k).get("daysCnt");
                                log.info("天数差daysCnt:{}", daysCnt);

                                //获取当天完成的任务数量
                                Long idCnt = (Long) countList.get(k).get("idCnt");
                                log.info("当天完成的任务数量idCnt:{}", idCnt);

                                //获得今日对应的百分比
                                double pert = Double.valueOf(rept[daysCnt]);
                                log.info("今日对应的百分比pert:{}", pert);

                                //获取今日需要完成的对应的留存任务数
                                int taskCnt = (int) Math.ceil(idCnt * pert / 100);
                                log.info("今日需要完成的对应的留存任务数taskCnt:{}", taskCnt);

                                //更新任务
                                retainedListService.updateRetainedStatusForUsual1(taskId, daysCnt, taskCnt);
                                log.info("---更新任务--taskId:{},daysCnt:{},taskCnt:{}", taskId, daysCnt, taskCnt);
                            }
                        }
                        break;
                    //任务类型为长时间类型
                    case (1):
                        log.info("-----任务类型为长时间类型");

                        //遍历taskId
                        for (int j = 0; j < list.size(); j++) {
                            log.info("j:{}--{}", j, list.get(j).toString());

                            //获得本次任务的taskId
                            taskId = (Integer) list.get(j).get("id");
                            //获取任务的留存百分比方案
                            retainedPercent = (String) list.get(j).get("retainedPercent");
                            //根据taskId获取留存上传时间距离今日多少天及对应的完成任务数量的list
                            List<Map<String, Object>> countList = retainedListService.selectGroupByTaskId1(taskId);
                            //获取百分比方案的具体值
                            String[] rept = retainedPercent.split(",");
                            //遍历留存上传时间距离今日多少天及对应的完成任务数量的list
                            for (int k = 0; k < countList.size(); k++) {
                                //获取天数差
                                int daysCnt = (Integer) countList.get(k).get("daysCnt");
                                //获取当天完成的任务数量
                                Long idCnt = (Long) countList.get(k).get("idCnt");
                                //获得今日对应的百分比
                                double pert = Double.valueOf(rept[daysCnt]);
                                //获取今日需要完成的对应的留存任务数
                                int taskCnt = (int) Math.ceil(idCnt * pert / 100);
                                //更新任务
                                retainedListService.updateRetainedStatusForSpecial1(taskId, daysCnt, taskCnt);
                                log.info("---更新任务--taskId:{},daysCnt:{},taskCnt:{}", taskId, daysCnt, taskCnt);
                            }
                        }
                        break;
                    //任务类型为关卡类型
                    case (2):
                        log.info("-----任务类型为关卡类型");

                        //遍历taskId
                        for (int j = 0; j < list.size(); j++) {
                            log.info("j:{}--{}", j, list.get(j).toString());

                            //获得本次任务的taskId
                            taskId = (Integer) list.get(j).get("id");
                            //获取任务的留存百分比方案
                            retainedPercent = (String) list.get(j).get("retainedPercent");
                            //获取关卡模式次日特定次数百分比
                            double morrowLevelPercent = (Double) list.get(j).get("morrowLevelPercent");
                            //获取关卡模式每日特定次数百分比
                            double everydayLevelPercent = (Double) list.get(j).get("everydayLevelPercent");
                            //根据taskId获取留存上传时间距离今日多少天及对应的完成任务数量的list
                            List<Map<String, Object>> countList = retainedListService.selectGroupByTaskId1(taskId);
                            //获取百分比方案的具体值
                            String[] rept = retainedPercent.split(",");
                            //遍历留存上传时间距离今日多少天及对应的完成任务数量的list
                            for (int k = 0; k < countList.size(); k++) {
                                //获取天数差
                                int daysCnt = (Integer) countList.get(k).get("daysCnt");
                                //获取当天完成的任务数量
                                Long idCnt = (Long) countList.get(k).get("idCnt");
                                //获得今日对应的百分比
                                double pert = Double.valueOf(rept[daysCnt]);
                                //获取今日需要完成的对应的留存任务数
                                int taskCnt = (int) Math.ceil(idCnt * pert / 100);
                                //次日关卡留存
                                if (daysCnt == 1) {
                                    //获得次日特定次数任务数
                                    int morrowCnt = (int) Math.ceil(idCnt * morrowLevelPercent);
                                    //获取每日特定次数任务数
                                    int everydayCnt = (int) Math.ceil(idCnt * everydayLevelPercent);
                                    //获取普通次数任务数
                                    int usualCnt = taskCnt - morrowCnt - everydayCnt;
                                    //修改关卡留存的type类型
                                    retainedListService.updateLevelType1(taskId, type[0], everydayCnt);
                                    retainedListService.updateLevelType1(taskId, type[1], morrowCnt);
                                    retainedListService.updateLevelRetained1(taskId, daysCnt, type[0], everydayCnt);
                                    retainedListService.updateLevelRetained1(taskId, daysCnt, type[1], morrowCnt);
                                    retainedListService.updateLevelRetained1(taskId, daysCnt, type[2], usualCnt);
                                }
                                if (daysCnt == 2) {
                                    //3日先将次日特殊type修改为正常
                                    retainedListService.updateMorrowLevelType1(taskId, daysCnt);
                                    int everydayCnt = retainedListService.updateEverydayLevelRetained1(taskId, daysCnt);
                                    retainedListService.updateLevelRetained1(taskId, daysCnt, type[2], taskCnt - everydayCnt);
                                } else {
                                    int everydayCnt = retainedListService.updateEverydayLevelRetained1(taskId, daysCnt);
                                    retainedListService.updateLevelRetained1(taskId, daysCnt, type[2], taskCnt - everydayCnt);
                                }

                                log.info("---更新任务--taskId:{},daysCnt:{}", taskId, daysCnt);

                            }
                        }
                }

            }


            log.info(">>>>>>>>>>>>>>>>>>>>>分公司留存模式2");

            //分公司留存模式2
            for (int i = 0; i < 3; i++) {
                //获得分公司对应任务类型的taskId的list
                List<Map<String, Object>> list = taskListService.selectByGenerateRetainedType2(type[i]);
                switch (i) {

                    //任务类型为普通类型
                    case (0):
                        log.info("-----任务类型为普通类型");


                        //遍历taskId
                        for (int j = 0; j < list.size(); j++) {
                            log.info("j:{}--{}", j, list.get(j).toString());

                            //获得本次任务的taskId
                            taskId = (Integer) list.get(j).get("id");
                            //获取任务的留存百分比方案
                            retainedPercent = (String) list.get(j).get("retainedPercent");
                            //根据taskId获取留存上传时间距离今日多少天及对应的完成任务数量的list
                            List<Map<String, Object>> countList = retainedListService.selectGroupByTaskId2(taskId);
                            //获取百分比方案的具体值
                            String[] rept = retainedPercent.split(",");

                            //遍历留存上传时间距离今日多少天及对应的完成任务数量的list
                            for (int k = 0; k < countList.size(); k++) {
                                log.info("-----{}", Arrays.toString(countList.toArray()));

                                //获取天数差
                                int daysCnt = (Integer) countList.get(k).get("daysCnt");
                                log.info("天数差daysCnt:{}", daysCnt);

                                //获取当天完成的任务数量
                                Long idCnt = (Long) countList.get(k).get("idCnt");
                                log.info("当天完成的任务数量idCnt:{}", idCnt);

                                //获得今日对应的百分比
                                double pert = Double.valueOf(rept[daysCnt]);
                                log.info("今日对应的百分比pert:{}", pert);

                                //获取今日需要完成的对应的留存任务数
                                int taskCnt = (int) Math.ceil(idCnt * pert / 100);
                                log.info("今日需要完成的对应的留存任务数taskCnt:{}", taskCnt);

                                //更新任务
                                retainedListService.updateRetainedStatusForUsual2(taskId, daysCnt, taskCnt);
                                log.info("---更新任务--taskId:{},daysCnt:{},taskCnt:{}", taskId, daysCnt, taskCnt);
                            }
                        }
                        break;


                    //任务类型为长时间类型
                    case (1):
                        log.info("-----任务类型为长时间类型");

                        //遍历taskId
                        for (int j = 0; j < list.size(); j++) {
                            log.info("j:{}--{}", j, list.get(j).toString());

                            //获得本次任务的taskId
                            taskId = (Integer) list.get(j).get("id");
                            //获取任务的留存百分比方案
                            retainedPercent = (String) list.get(j).get("retainedPercent");
                            //根据taskId获取留存上传时间距离今日多少天及对应的完成任务数量的list
                            List<Map<String, Object>> countList = retainedListService.selectGroupByTaskId2(taskId);
                            //获取百分比方案的具体值
                            String[] rept = retainedPercent.split(",");
                            //遍历留存上传时间距离今日多少天及对应的完成任务数量的list
                            for (int k = 0; k < countList.size(); k++) {
                                //获取天数差
                                int daysCnt = (Integer) countList.get(k).get("daysCnt");
                                //获取当天完成的任务数量
                                Long idCnt = (Long) countList.get(k).get("idCnt");
                                //获得今日对应的百分比
                                double pert = Double.valueOf(rept[daysCnt]);
                                //获取今日需要完成的对应的留存任务数
                                int taskCnt = (int) Math.ceil(idCnt * pert / 100);
                                //更新任务
                                retainedListService.updateRetainedStatusForSpecial2(taskId, daysCnt, taskCnt);
                                log.info("---更新任务--taskId:{},daysCnt:{},taskCnt:{}", taskId, daysCnt, taskCnt);
                            }
                        }
                        break;


                    //任务类型为关卡类型
                    case (2):
                        log.info("-----任务类型为关卡类型");

                        //遍历taskId
                        for (int j = 0; j < list.size(); j++) {
                            log.info("j:{}--{}", j, list.get(j).toString());

                            //获得本次任务的taskId
                            taskId = (Integer) list.get(j).get("id");
                            //获取任务的留存百分比方案
                            retainedPercent = (String) list.get(j).get("retainedPercent");
                            //获取关卡模式次日特定次数百分比
                            double morrowLevelPercent = (Double) list.get(j).get("morrowLevelPercent");
                            //获取关卡模式每日特定次数百分比
                            double everydayLevelPercent = (Double) list.get(j).get("everydayLevelPercent");
                            //根据taskId获取留存上传时间距离今日多少天及对应的完成任务数量的list
                            List<Map<String, Object>> countList = retainedListService.selectGroupByTaskId2(taskId);
                            //获取百分比方案的具体值
                            String[] rept = retainedPercent.split(",");
                            //遍历留存上传时间距离今日多少天及对应的完成任务数量的list
                            for (int k = 0; k < countList.size(); k++) {
                                //获取天数差
                                int daysCnt = (Integer) countList.get(k).get("daysCnt");
                                //获取当天完成的任务数量
                                Long idCnt = (Long) countList.get(k).get("idCnt");
                                //获得今日对应的百分比
                                double pert = Double.valueOf(rept[daysCnt]);
                                //获取今日需要完成的对应的留存任务数
                                int taskCnt = (int) Math.ceil(idCnt * pert / 100);
                                //次日关卡留存
                                if (daysCnt == 1) {
                                    //获得次日特定次数任务数
                                    int morrowCnt = (int) Math.ceil(idCnt * morrowLevelPercent);
                                    //获取每日特定次数任务数
                                    int everydayCnt = (int) Math.ceil(idCnt * everydayLevelPercent);
                                    //获取普通次数任务数
                                    int usualCnt = taskCnt - morrowCnt - everydayCnt;
                                    //修改关卡留存的type类型
                                    retainedListService.updateLevelType2(taskId, type[0], everydayCnt);
                                    retainedListService.updateLevelType2(taskId, type[1], morrowCnt);
                                    retainedListService.updateLevelRetained2(taskId, daysCnt, type[0], everydayCnt);
                                    retainedListService.updateLevelRetained2(taskId, daysCnt, type[1], morrowCnt);
                                    retainedListService.updateLevelRetained2(taskId, daysCnt, type[2], usualCnt);
                                }
                                if (daysCnt == 2) {
                                    //3日先将次日特殊type修改为正常
                                    retainedListService.updateMorrowLevelType2(taskId, daysCnt);
                                    int everydayCnt = retainedListService.updateEverydayLevelRetained2(taskId, daysCnt);
                                    retainedListService.updateLevelRetained2(taskId, daysCnt, type[2], taskCnt - everydayCnt);
                                } else {
                                    int everydayCnt = retainedListService.updateEverydayLevelRetained2(taskId, daysCnt);
                                    retainedListService.updateLevelRetained2(taskId, daysCnt, type[2], taskCnt - everydayCnt);
                                }
                                log.info("---更新任务--taskId:{},daysCnt:{}", taskId, daysCnt);
                            }
                        }
                }

            }


            //今日要做的留存总量
            List<Map<String, Object>> todayList = retainedListService.selectYestodayUndo();
            if (todayList != null && !todayList.isEmpty()) {
                log.info(">>>>>>今日要做的留存总量放入redis：{}", Arrays.toString(todayList.toArray()));
                for (int i = 0; i < todayList.size(); i++) {
                    RedisUtil.hsetString("todayRetained", String.valueOf(todayList.get(i).get("userId")), String.valueOf(todayList.get(i).get("undoNum")));
                }
            }

            log.info(">>>>>>今日留存计算完毕");

        } catch (Exception e) {
            log.error("今日留存计算失败，", e);
            throw e;
        }


    }


}
