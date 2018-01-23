package pojo;

public class FindVendorsRequest{
    private String systemSource;
    private String vendorCode;
    private String verdorName;
    private String orgcertNumber;
    private String beginDate;
    private String endDate;
    private String currentPage;
    private String pageSize;
    private String totalPage;
    private String totalRecord;
    private String dataType;

    public String getSystemSource() {
        return systemSource;
    }

    public void setSystemSource(String systemSource) {
        this.systemSource = systemSource;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVerdorName() {
        return verdorName;
    }

    public void setVerdorName(String verdorName) {
        this.verdorName = verdorName;
    }

    public String getOrgcertNumber() {
        return orgcertNumber;
    }

    public void setOrgcertNumber(String orgcertNumber) {
        this.orgcertNumber = orgcertNumber;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public String getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(String totalRecord) {
        this.totalRecord = totalRecord;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
