package com.example.demo;

import com.google.gson.annotations.SerializedName;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/5
 * @since 1.0
 */
public class BaseFluxWmsResponse {
    @SerializedName("Response")
    private ResponseBean response;

    public BaseFluxWmsResponse() {
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "BaseFluxWmsResponse{"
                + "response=" + response
                + '}';
    }

    public static class ResponseBean {
        @SerializedName("return")
        private ReturnBean baseResponse;

        public ResponseBean() {
        }

        @Override
        public String toString() {
            return "ResponseBean{"
                    + "baseResponse=" + baseResponse
                    + '}';
        }

        public ReturnBean getBaseResponse() {
            return baseResponse;
        }

        public void setBaseResponse(ReturnBean baseResponse) {
            this.baseResponse = baseResponse;
        }

        public static class ReturnBean {

            private String returnCode;
            private String returnDesc;
            private String returnFlag;
            private Object resultInfo;

            @Override
            public String toString() {
                return "ReturnBean{"
                        + "returnCode='" + returnCode + '\''
                        + ", returnDesc='" + returnDesc + '\''
                        + ", returnFlag='" + returnFlag + '\''
                        + ", resultInfo=" + resultInfo
                        + '}';
            }

            public Object getResultInfo() {
                return resultInfo;
            }

            public void setResultInfo(Object resultInfo) {
                this.resultInfo = resultInfo;
            }

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
        }
    }
}