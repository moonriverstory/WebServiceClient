package call.cxfDynamic;

import com.alibaba.fastjson.JSON;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.log4j.Logger;
import pojo.FindVendorsRequest;
import pojo.FindVendorsResponse;
import pojo.ImportVendersRequest;
import pojo.ImportVendersResponse;

public class CxfDynamicService {

    private static Logger logger = Logger.getLogger(CxfDynamicService.class);

    //private static final String FIND_WSDL = "http://106.14.5.254:7070/webservice/FindService?wsdl";
    private static final String FIND_WSDL = "http://0.0.0.0:7070/webservice/FindService?wsdl";
    private static final String FIND_METHOD = "find";
    //private static final String SYNC_WSDL = "http://106.14.5.254:7070/webservice/UpdateService?wsdl";
    private static final String SYNC_WSDL = "http://0.0.0.0:7070/webservice/UpdateService?wsdl";
    private static final String SYNC_METHOD = "update";


    public FindVendorsResponse find(FindVendorsRequest request) {

        DynamicClientFactory factory = DynamicClientFactory.newInstance();
        Client client = factory.createClient(FIND_WSDL);

        String reqJson = JSON.toJSONString(request);
        logger.info("send find request: " + reqJson);

        Object[] results = null;
        try {
            results = client.invoke(FIND_METHOD, reqJson);
        } catch (Exception e) {
            logger.error("findVendorFromWS invoke error ! ", e);
            throw new RuntimeException("findVendorFromWS invoke fail !");
        }
        String response = "";
        if (results == null || results.length < 1) {
            logger.error("findVendorFromWS error: webservice response is null !");
            return null;
        } else {
            response = String.valueOf(results[0]);
        }

        logger.info("get find response: " + response);
        FindVendorsResponse resPojo = JSON.parseObject(response, FindVendorsResponse.class);
        return resPojo;
    }


    public ImportVendersResponse update(ImportVendersRequest request) {
        DynamicClientFactory factory = DynamicClientFactory.newInstance();
        Client client = factory.createClient(SYNC_WSDL);

        String reqJson = JSON.toJSONString(request);
        logger.info("send update request: " + reqJson);

        Object[] results = null;
        try {
            results = client.invoke(SYNC_METHOD, reqJson);
        } catch (Exception e) {
            logger.error("updateVendorOnWS invoke error ! ", e);
            throw new RuntimeException("updateVendorOnWS invoke fail !");
        }
        String response = "";
        if (results == null || results.length < 1) {
            logger.error("updateVendorOnWS error: webservice response is null !");
            return null;
        } else {
            response = String.valueOf(results[0]);
        }

        logger.info("get update response: " + response);
        ImportVendersResponse resPojo = JSON.parseObject(response, ImportVendersResponse.class);
        return resPojo;
    }


}
