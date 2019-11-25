package com.example.democlient.controller;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2019-09-10
 * @description
 * @since 1.0
 */
@Data
public class CustomerGroupRequest {

    /**
     * 客户组 guid, 更新时必填.
     */
    private String groupGuid;

    /**
     * 组名，不可空
     */
    @NotBlank(message = "客户组名不能为空")
    private String groupName;

    /**
     * 组描述,可空
     */
    private String groupDescription;

    /**
     * 组员
     */
    @Valid
    @NotNull(message = "组员不能为空")
    @Size(min = 1, message = "组员不能为空")
    private List<GroupCustomer> groupCustomers;

    @Data
    public static class GroupCustomer {

        /**
         * 客户 id
         */
        @NotNull(message = "客户id不能为空")
        private Integer customerId;

        /**
         * 客户角色 guid
         */
        @NotBlank(message = "客户角色不能为空")
        private String groupRoleGuid;

        /**
         * 是否组管理员.
         */
        private Boolean groupAdmin = Boolean.FALSE;
    }

//    public static void main(String[] args) {
//        CustomerGroupRequest request = new CustomerGroupRequest();
//        request.setGroupGuid("abc");
//        request.setGroupName("wzj");
//        request.setGroupDescription("desc");
//
//        ValidList<GroupCustomer> groupCustomers = new ValidList<>();
//        GroupCustomer groupCustomer = new GroupCustomer();
//        groupCustomer.setCustomerId(123);
//        groupCustomer.setGroupRoleGuid("abc");
//        groupCustomer.setGroupAdmin(true);
//        groupCustomers.add(groupCustomer);
//
//        request.setGroupCustomers(groupCustomers);
//
//        System.out.println(JSON.toJSONString(request));
//    }


}
