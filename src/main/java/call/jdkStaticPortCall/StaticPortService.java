package call.jdkStaticPortCall;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import pojo.*;
import server.FindService;
import server.UpdateService;
import service.fastjsonversion.McpService;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class StaticPortService {

    private static Logger logger = Logger.getLogger(StaticPortService.class);

    private FindService getFindWSPort() {
        try {
            URL wsdl = new URL("http://106.14.5.254:7070/webservice/FindService?wsdl");
            QName serviceName = new QName("http://server/", "FindService");
            QName portName = new QName("http://server/", "FindServicePort");
            Service service = Service.create(wsdl, serviceName);
            FindService mcpService = service.getPort(portName, FindService.class);
            logger.debug("get webservice port success!");
            return mcpService;
        } catch (Exception e) {
            logger.error("CxfSpringService get port error ! ", e);
            throw new RuntimeException("CxfSpringService get port fail !");
        }
    }

    private UpdateService getUpdateWSPort() {
        try {
            URL wsdl = new URL("http://106.14.5.254:7070/webservice/UpdateService?wsdl");
            QName serviceName = new QName("http://server/", "UpdateService");
            QName portName = new QName("http://server/", "UpdateServicePort");
            // 这里发现一个问题，就是命名空间的路径一定要对，但是jar包里面的port接口类的路径不一定要和提供服务的一样=。=
            // 你这个反序列化不科学严谨啊！不是说反序列化的class路径要和序列化的class路径一样才能成功吗，orz，试一试！
            Service service = Service.create(wsdl, serviceName);
            UpdateService mcpService = service.getPort(portName, UpdateService.class);
            logger.debug("get webservice port success!");
            return mcpService;
        } catch (Exception e) {
            logger.error("CxfSpringService get port error ! ", e);
            throw new RuntimeException("CxfSpringService get port fail !");
        }
    }

    public FindVendorsResponse find(FindVendorsRequest request) {
        String reqJson = JSON.toJSONString(request);
        logger.info("send find request: " + reqJson);
        FindService mcpService = this.getFindWSPort();
        String response = mcpService.find(reqJson);
        logger.info("get find response: " + response);
        FindVendorsResponse resPojo = JSON.parseObject(response, FindVendorsResponse.class);
        return resPojo;
    }

    public ImportVendersResponse update(ImportVendersRequest request) {
        String reqJson = JSON.toJSONString(request);
        logger.info("send update request: " + reqJson);
        UpdateService mcpService = this.getUpdateWSPort();
        String response = mcpService.update(reqJson);
        logger.info("get update response: " + response);
        ImportVendersResponse resPojo = JSON.parseObject(response, ImportVendersResponse.class);
        return resPojo;
    }

}
