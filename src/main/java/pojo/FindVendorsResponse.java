package pojo;

import java.util.List;

public class FindVendorsResponse {
    private String errorFlag;
    private String errorMessage;
    private String page_SIZE;
    private String current_PAGE;
    private String total_RECORD;
    private String total_PAGE;
    private List<VendorItemPojo> vendorList;

    public String getErrorFlag() {
        return errorFlag;
    }

    public void setErrorFlag(String errorFlag) {
        this.errorFlag = errorFlag;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPage_SIZE() {
        return page_SIZE;
    }

    public void setPage_SIZE(String page_SIZE) {
        this.page_SIZE = page_SIZE;
    }

    public String getCurrent_PAGE() {
        return current_PAGE;
    }

    public void setCurrent_PAGE(String current_PAGE) {
        this.current_PAGE = current_PAGE;
    }

    public String getTotal_RECORD() {
        return total_RECORD;
    }

    public void setTotal_RECORD(String total_RECORD) {
        this.total_RECORD = total_RECORD;
    }

    public String getTotal_PAGE() {
        return total_PAGE;
    }

    public void setTotal_PAGE(String total_PAGE) {
        this.total_PAGE = total_PAGE;
    }

    public List<VendorItemPojo> getVendorList() {
        return vendorList;
    }

    public void setVendorList(List<VendorItemPojo> vendorList) {
        this.vendorList = vendorList;
    }
}
