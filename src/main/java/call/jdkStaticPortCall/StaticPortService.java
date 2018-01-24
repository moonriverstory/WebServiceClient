package call.jdkStaticPortCall;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import pojo.*;
import service.fastjsonversion.McpService;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class StaticPortService {

    private static Logger logger = Logger.getLogger(StaticPortService.class);

    private McpService getWSPort() {
        try {
            URL wsdl = new URL("http://localhost:7070/webservice/mcp?wsdl");
            QName serviceName = new QName("http://service/", "McpService");
            QName portName = new QName("http://service/", "McpServicePort");
            // 这里发现一个问题，就是命名空间的路径一定要对，但是jar包里面的port接口类的路径不一定要和提供服务的一样=。=
            // 你这个反序列化不科学严谨啊！不是说反序列化的class路径要和序列化的class路径一样才能成功吗，orz，试一试！
            Service service = Service.create(wsdl, serviceName);
            McpService mcpService = service.getPort(portName, McpService.class);
            logger.debug("get webservice port success!");
            return mcpService;
        } catch (Exception e) {
            logger.error("CxfSpringService get port error ! ", e);
            throw new RuntimeException("CxfSpringService get port fail !");
        }
    }

    public String find(FindVendorsRequest request) {
        String reqJson = JSON.toJSONString(request);
        logger.info("send find request: " + reqJson);
        McpService mcpService = this.getWSPort();
        String response = mcpService.find(reqJson);
        logger.info("get find response: " + response);
        return response;
    }

    public FindVendorsResponse parseFindVendorsResponse(String response) {
        logger.info("parse json: " + response);
        FindVendorsResponse resPojo = JSON.parseObject(response, FindVendorsResponse.class);
        return resPojo;
    }

    public String update(ImportVendersRequest request) {
        String reqJson = JSON.toJSONString(request);
        logger.info("send update request: " + reqJson);
        McpService mcpService = this.getWSPort();
        String response = mcpService.update(reqJson);
        logger.info("get update response: " + response);
        return response;
    }

    public ImportVendersResponse parseImportVendersResponse(String response) {
        ImportVendersResponse resPojo = JSON.parseObject(response, ImportVendersResponse.class);
        return resPojo;
    }
}
