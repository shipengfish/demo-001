package com.example.demoprinciple.di;

import com.dangdang.ddframe.job.lite.lifecycle.api.JobAPIFactory;
import com.dangdang.ddframe.job.lite.lifecycle.api.JobOperateAPI;
import com.google.common.base.Optional;

/**
 * @author shipengfish
 * @version * @date 2018/10/10
 * @description
 * @since 1.0
 */
public class Job {

    public static void main(String[] args) {

        String name = "com.wozaijia.finance.admin.business.job.FactorySkuMaintenanceNotifyJob";
        String cluster = "172.20.4.250:2181";
        String namespace = "ejob";
        JobOperateAPI jobOperateAPI = JobAPIFactory.createJobOperateAPI(cluster, namespace, com.google.common.base.Optional.absent());
        jobOperateAPI.trigger(Optional.of("rd:" + name), Optional.absent());

    }
}
