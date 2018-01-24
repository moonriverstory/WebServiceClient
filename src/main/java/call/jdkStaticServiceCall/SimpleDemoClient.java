package call.jdkStaticServiceCall;

import org.apache.log4j.Logger;
import service.McpService;
import service.McpService_Service;

/**
 * 通过wsdl生成的jar，静态代理，调用webservice接口
 */
public class SimpleDemoClient {
    private static Logger logger = Logger.getLogger(SimpleDemoClient.class);

    public static void main(String[] args) {
        //ws接口工厂
        McpService_Service service = new McpService_Service();
        //获得ws接口
        McpService mcpService = service.getMcpServicePort();
        //调用接口的方法
        String findResult = mcpService.find("");
        String updateResult = mcpService.update("");
        logger.info("findResult: "+ findResult);
        logger.info("updateResult: "+ updateResult);
    }
}
