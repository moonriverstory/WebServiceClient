package call.jdkStaticServiceCall;

import org.apache.log4j.Logger;
import server.FindService;
import server.FindService_Service;

/**
 * 通过wsdl生成的jar，静态代理，调用webservice接口
 */
public class SimpleDemoClient {
    private static Logger logger = Logger.getLogger(SimpleDemoClient.class);

    public static void main(String[] args) {
        //ws接口工厂
        FindService_Service service = new FindService_Service();
        //获得ws接口
        FindService mcpService = service.getFindServicePort();
        //调用接口的方法
        String findResult = mcpService.find("");
        logger.info("findResult: "+ findResult);
    }
}
