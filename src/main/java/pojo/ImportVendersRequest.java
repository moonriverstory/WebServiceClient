package pojo;

import java.util.List;

public class ImportVendersRequest {
    //header
    //系统来源
    private String systemSource;
    //员工编号
    private String employeeNumber;
    //员工姓名
    private String employeeName;

    private List<VendorPojo> vendorList;

    public String getSystemSource() {
        return systemSource;
    }

    public void setSystemSource(String systemSource) {
        this.systemSource = systemSource;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<VendorPojo> getVendorList() {
        return vendorList;
    }

    public void setVendorList(List<VendorPojo> vendorList) {
        this.vendorList = vendorList;
    }
}
