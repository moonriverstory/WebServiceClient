package pojo;

public class ImportVendersResponse {
    private String returnFlag;
    private String returnMessage;
    private String boeHeaderId;
    private String boeNum;

    public String getReturnFlag() {
        return returnFlag;
    }

    public void setReturnFlag(String returnFlag) {
        this.returnFlag = returnFlag;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getBoeHeaderId() {
        return boeHeaderId;
    }

    public void setBoeHeaderId(String boeHeaderId) {
        this.boeHeaderId = boeHeaderId;
    }

    public String getBoeNum() {
        return boeNum;
    }

    public void setBoeNum(String boeNum) {
        this.boeNum = boeNum;
    }
}
