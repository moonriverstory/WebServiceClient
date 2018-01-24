package call.cxfSpring;

import com.alibaba.fastjson.JSON;
import com.zte.eas.ws.interfaceserver.syncvendorsservice.SyncVendorsServicePortType;
import com.zte.eas.ws.interfaceserver.syncvendorsservice.xsd.Request;
import com.zte.eas.ws.pop.SynPopVendorSrvPortType;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.FindVendorsRequest;
import pojo.FindVendorsResponse;
import pojo.ImportVendersResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class CxfSpringService {

    private static Logger logger = Logger.getLogger(CxfSpringService.class);

    private static String REQUEST_NAMESPACE = "http://syncvendorsservice.interfaceserver.ws.eas.zte.com/xsd";


    public FindVendorsResponse find(FindVendorsRequest request) {

        logger.info("send find request: " + request.toString());
        Request findReq = new Request();
        if (request.getSystemSource() != null) {
            JAXBElement<String> systemSource = new JAXBElement<String>(new QName(REQUEST_NAMESPACE, "systemSource"),
                    String.class, request.getSystemSource());
            findReq.setSystemSource(systemSource);
        }
        if (request.getBeginDate() != null) {
            JAXBElement<String> beginDate = new JAXBElement<String>(new QName(REQUEST_NAMESPACE, "beginDate"),
                    String.class, request.getBeginDate());
            findReq.setBeginDate(beginDate);
        }
        if (request.getEndDate() != null) {
            JAXBElement<String> endDate = new JAXBElement<String>(new QName(REQUEST_NAMESPACE, "endDate"), String.class,
                    request.getEndDate());
            findReq.setEndDate(endDate);
        }
        if (request.getCurrentPage() != null) {
            JAXBElement<String> currentPage = new JAXBElement<String>(new QName(REQUEST_NAMESPACE, "currentPage"),
                    String.class, request.getCurrentPage());
            findReq.setCurrentPage(currentPage);
        }
        if (request.getPageSize() != null) {
            JAXBElement<String> pageSize = new JAXBElement<String>(new QName(REQUEST_NAMESPACE, "pageSize"),
                    String.class, request.getPageSize());
            findReq.setPageSize(pageSize);
        }
        if (request.getDataType() != null) {
            JAXBElement<String> dataType = new JAXBElement<String>(new QName(REQUEST_NAMESPACE, "dataType"),
                    String.class, request.getDataType());
            findReq.setDataType(dataType);
        }
        if (request.getVendorCode() != null) {
            JAXBElement<String> vendorCode = new JAXBElement<String>(new QName(REQUEST_NAMESPACE, "vendorCode"),
                    String.class, request.getVendorCode());
            findReq.setBeginDate(vendorCode);
        }
        if (request.getVerdorName() != null) {
            JAXBElement<String> verdorName = new JAXBElement<String>(new QName(REQUEST_NAMESPACE, "verdorName"), String.class,
                    request.getVerdorName());
            findReq.setEndDate(verdorName);
        }
        if (request.getOrgcertNumber() != null) {
            JAXBElement<String> orgcertNumber = new JAXBElement<String>(new QName(REQUEST_NAMESPACE, "orgcertNumber"),
                    String.class, request.getOrgcertNumber());
            findReq.setCurrentPage(orgcertNumber);
        }
        if (request.getTotalPage() != null) {
            JAXBElement<String> totalPage = new JAXBElement<String>(new QName(REQUEST_NAMESPACE, "totalPage"),
                    String.class, request.getTotalPage());
            findReq.setPageSize(totalPage);
        }
        if (request.getTotalRecord() != null) {
            JAXBElement<String> totalRecord = new JAXBElement<String>(new QName(REQUEST_NAMESPACE, "totalRecord"),
                    String.class, request.getTotalRecord());
            findReq.setDataType(totalRecord);
        }

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SyncVendorsServicePortType findService = context.getBean("syncVendorsService",
                SyncVendorsServicePortType.class);
        String response = findService.findVendors(findReq);

        logger.info("get find response: " + response);

        FindVendorsResponse resPojo = JSON.parseObject(response, FindVendorsResponse.class);
        return resPojo;
    }

    public ImportVendersResponse update(String request) {

        logger.info("send update request: " + request.toString());

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SynPopVendorSrvPortType updateService = context.getBean("synPopVendorSrv",
                SynPopVendorSrvPortType.class);
        String response = updateService.importVenders(request);

        logger.info("get update response: " + response);

        ImportVendersResponse resPojo = JSON.parseObject(response, ImportVendersResponse.class);
        return resPojo;
    }


}
