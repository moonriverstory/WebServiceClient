package call.cxfSpring;

import org.apache.log4j.Logger;
import pojo.FindVendorsRequest;
import pojo.FindVendorsResponse;


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
        //findReq.setVerdorName("");

        FindVendorsResponse findResPojo = call.find(findReq);
        logger.info("response - vendor id: "+findResPojo.getVendorList().get(0).getVendorId());
//        String updateRequest = "{\"employeeName\":\"孙斌\",\"employeeNumber\":\"sunbin\",\"systemSource\":\"MGJ\",\"vendorList\":[{\"address\":\"西溪\",\"bankAccountName\":\"杭州东硕信息技术有限公司\",\"bankAccountNum\":\"2\",\"bankNameAlias\":\"12\",\"bankNo\":\"105451000282\",\"contactAddress\":\"中国_浙江_杭州_西溪\",\"country\":\"中国\",\"importType\":\"NA1\",\"orgId\":\"393\",\"payGroup\":\"VENDOR_SUPPLIER\",\"paymentType\":\"ELECTRONIC_PAYMENT\",\"priKey\":\"20180115141234NA1mcpT06\",\"siteCity\":\"杭州\",\"siteProvince\":\"浙江\",\"vatFlag\":\"2\",\"vendorName\":\"mcpTest06\",\"vendorSiteCode\":\"0571\",\"vendorType\":\"VENDOR\"}]}";
//        call.update(updateRequest);
    }
}
