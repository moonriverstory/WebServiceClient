package pojo;

import java.util.List;

public class VendorItemPojo {
    private String vendorId;
    private String vendorNumber;
    private String vendorName;
    private String vendorType;
    private String vendorEnabledFlag;
    private String vatFLAG;
    private String vatRegistrationNum;
    private String orgcertNumber;
    private List<VendorSiteInfoItemPojo> vendorSiteInfo;

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorNumber() {
        return vendorNumber;
    }

    public void setVendorNumber(String vendorNumber) {
        this.vendorNumber = vendorNumber;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorType() {
        return vendorType;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    public String getVendorEnabledFlag() {
        return vendorEnabledFlag;
    }

    public void setVendorEnabledFlag(String vendorEnabledFlag) {
        this.vendorEnabledFlag = vendorEnabledFlag;
    }

    public String getVatFLAG() {
        return vatFLAG;
    }

    public void setVatFLAG(String vatFLAG) {
        this.vatFLAG = vatFLAG;
    }

    public String getVatRegistrationNum() {
        return vatRegistrationNum;
    }

    public void setVatRegistrationNum(String vatRegistrationNum) {
        this.vatRegistrationNum = vatRegistrationNum;
    }

    public String getOrgcertNumber() {
        return orgcertNumber;
    }

    public void setOrgcertNumber(String orgcertNumber) {
        this.orgcertNumber = orgcertNumber;
    }

    public List<VendorSiteInfoItemPojo> getVendorSiteInfo() {
        return vendorSiteInfo;
    }

    public void setVendorSiteInfo(List<VendorSiteInfoItemPojo> vendorSiteInfo) {
        this.vendorSiteInfo = vendorSiteInfo;
    }
}
