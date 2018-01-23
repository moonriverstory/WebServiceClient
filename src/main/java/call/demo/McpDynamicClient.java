package call.demo;

import org.apache.log4j.Logger;
import service.McpService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

/**
 * 通过wsdl动态代理，调用webservice接口
 */
public class McpDynamicClient {
    private static Logger logger = Logger.getLogger(McpDynamicClient.class);

    public static void main(String[] args) {
        try {
            URL wsdl = new URL("http://localhost:7070/webservice/mcp?wsdl");
            QName serviceName = new QName("http://service/", "McpService");
            QName portName = new QName("http://service/", "McpServicePort");
            Service service = Service.create(wsdl, serviceName);
            McpService mcpService = service.getPort(portName, McpService.class);
            //调用接口的方法
            String findResult = mcpService.find("");
            String updateResult = mcpService.update("");
            logger.info("findResult: "+ findResult);
            logger.info("updateResult: "+ updateResult);

        } catch (Exception e) {
            logger.error("McpDynamicClient call error ! ", e);
        }
    }
}
