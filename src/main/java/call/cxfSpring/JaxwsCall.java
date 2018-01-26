package call.cxfSpring;

import org.apache.log4j.Logger;
import pojo.*;

import java.util.ArrayList;
import java.util.List;


public class JaxwsCall {

    private static Logger logger = Logger.getLogger(JaxwsCall.class);

    public static void main(String[] args) {
        CxfSpringService call = new CxfSpringService();

        FindVendorsRequest findReq = new FindVendorsRequest();
        findReq.setSystemSource("MGJ");
        findReq.setBeginDate("2018-01-15 00:00:00");
        findReq.setEndDate("2018-01-15 15:00:00");
        findReq.setCurrentPage("0");
        findReq.setPageSize("10");
        findReq.setDataType("VENDOR");

        FindVendorsResponse findResPojo = call.find(findReq);
        logger.info("response - vendor id: " + findResPojo.getVendorList().get(0).getVendorId());
        //更新
        ImportVendersRequest updateReq = new ImportVendersRequest();
        updateReq.setSystemSource("MGJ");
        updateReq.setEmployeeName("kevin");
        updateReq.setEmployeeNumber("666666");
        List<VendorPojo> vendorList = new ArrayList<VendorPojo>();
        VendorPojo vendor1 = new VendorPojo();
        vendor1.setPriKey("123");
        vendor1.setImportType("EA");
        vendor1.setSiteCity("hz");
        vendorList.add(vendor1);
        updateReq.setVendorList(vendorList);

        ImportVendersResponse updateRespJson = call.update(updateReq);
        logger.info("response - msg: " + updateRespJson.getReturnMessage());
    }
}
