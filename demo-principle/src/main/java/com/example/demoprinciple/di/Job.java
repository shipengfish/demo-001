package com.example.demoprinciple.di;

import com.dangdang.ddframe.job.lite.lifecycle.api.JobAPIFactory;
import com.dangdang.ddframe.job.lite.lifecycle.api.JobOperateAPI;
import com.google.common.base.Optional;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/10/10
 * @description
 * @since 1.0
 */
public class Job {

    public static void main(String[] args) {
        String cluster = "172.20.4.250:2181";
        String namespace = "ejob";
        JobOperateAPI jobOperateAPI = JobAPIFactory.createJobOperateAPI(cluster, namespace, Optional.absent());
//        jobOperateAPI.trigger(Optional.of("rd:com.wozaijia.product.admin.business.job.SendProductToWmsJob"), Optional.absent());
        jobOperateAPI.trigger(Optional.of("rd:com.wozaijia.pms.business.job.SendFactoryToWmsJob"), Optional.absent());
    }

}
