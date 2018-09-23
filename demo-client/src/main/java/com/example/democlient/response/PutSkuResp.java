package com.example.democlient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/9/21
 * @description
 * @since 1.0
 */
public class PutSkuResp {

    /**
     * Response : {"return":{"returnCode":"0001","returnDesc":"错误原因","returnFlag":"2","resultInfo":[{"CustomerID":"","SKU":"","errorcode":"","errordescr":""},{"CustomerID":"","SKU":"","errorcode":"","errordescr":""}]}}
     */

    @JsonProperty("Response")
    private ResponseBean Response;

    public ResponseBean getResponse() {
        return Response;
    }

    public void setResponse(ResponseBean Response) {
        this.Response = Response;
    }

    public static class ResponseBean {
        /**
         * return : {"returnCode":"0001","returnDesc":"错误原因","returnFlag":"2","resultInfo":[{"CustomerID":"","SKU":"","errorcode":"","errordescr":""},{"CustomerID":"","SKU":"","errorcode":"","errordescr":""}]}
         */

        @JsonProperty("return")
        private ReturnBean returnX;

        public ReturnBean getReturnX() {
            return returnX;
        }

        public void setReturnX(ReturnBean returnX) {
            this.returnX = returnX;
        }

        public static class ReturnBean {
            /**
             * returnCode : 0001
             * returnDesc : 错误原因
             * returnFlag : 2
             * resultInfo : [{"CustomerID":"","SKU":"","errorcode":"","errordescr":""},{"CustomerID":"","SKU":"","errorcode":"","errordescr":""}]
             */

            private String returnCode;
            private String returnDesc;
            private String returnFlag;
            private List<ResultInfoBean> resultInfo;

            public String getReturnCode() {
                return returnCode;
            }

            public void setReturnCode(String returnCode) {
                this.returnCode = returnCode;
            }

            public String getReturnDesc() {
                return returnDesc;
            }

            public void setReturnDesc(String returnDesc) {
                this.returnDesc = returnDesc;
            }

            public String getReturnFlag() {
                return returnFlag;
            }

            public void setReturnFlag(String returnFlag) {
                this.returnFlag = returnFlag;
            }

            public List<ResultInfoBean> getResultInfo() {
                return resultInfo;
            }

            public void setResultInfo(List<ResultInfoBean> resultInfo) {
                this.resultInfo = resultInfo;
            }

            public static class ResultInfoBean {
                /**
                 * CustomerID :
                 * SKU :
                 * errorcode :
                 * errordescr :
                 */

                private String CustomerID;
                private String SKU;
                private String errorcode;
                private String errordescr;

                public String getCustomerID() {
                    return CustomerID;
                }

                public void setCustomerID(String CustomerID) {
                    this.CustomerID = CustomerID;
                }

                public String getSKU() {
                    return SKU;
                }

                public void setSKU(String SKU) {
                    this.SKU = SKU;
                }

                public String getErrorcode() {
                    return errorcode;
                }

                public void setErrorcode(String errorcode) {
                    this.errorcode = errorcode;
                }

                public String getErrordescr() {
                    return errordescr;
                }

                public void setErrordescr(String errordescr) {
                    this.errordescr = errordescr;
                }
            }
        }
    }
}
