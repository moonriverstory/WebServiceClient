package call.jdkStaticPortCall;

import org.apache.log4j.Logger;
import pojo.*;

import java.util.ArrayList;
import java.util.List;

public class StaticPortCall {

    private static Logger logger = Logger.getLogger(StaticPortCall.class);

    public static void main(String[] args) {
        StaticPortService call = new StaticPortService();

        //查询
        FindVendorsRequest findReq = new FindVendorsRequest();
        findReq.setSystemSource("MGJ");
        findReq.setBeginDate("2017-01-01");
        findReq.setEndDate("2018-01-01");
        findReq.setCurrentPage("1");
        findReq.setPageSize("10");
        findReq.setDataType("VENDOR");

        FindVendorsResponse findResPojo = call.find(findReq);
        logger.info("resPojo: " + findResPojo.toString());
        logger.info("response - vendor id: "+findResPojo.getVendorList().get(0).getVendorId());

        //更新
        ImportVendersRequest updateReq = new ImportVendersRequest();
        updateReq.setSystemSource("MGJ");
        updateReq.setEmployeeName("kevin");//TODO TBD
        updateReq.setEmployeeNumber("666666");//TODO TBD
        List<VendorPojo> vendorList = new ArrayList<VendorPojo>();
        VendorPojo vendor1 = new VendorPojo();
        vendor1.setPriKey("123");
        vendor1.setImportType("EA");
        vendor1.setSiteCity("hz");
        vendorList.add(vendor1);
        updateReq.setVendorList(vendorList);

        ImportVendersResponse updateResPojo = call.update(updateReq);
        logger.info("resPojo: " + updateResPojo.toString());
        logger.info("response - Return Message: "+updateResPojo.getReturnMessage());
    }
}
