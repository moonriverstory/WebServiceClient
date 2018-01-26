package call.cxfSpring;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.FindVendorsRequest;
import pojo.FindVendorsResponse;
import pojo.ImportVendersRequest;
import pojo.ImportVendersResponse;
import server.FindService;
import server.UpdateService;

public class CxfSpringService {

    private static Logger logger = Logger.getLogger(CxfSpringService.class);

    public FindVendorsResponse find(FindVendorsRequest request) {

        String reqJson = JSON.toJSONString(request);
        logger.info("send find request: " + reqJson);

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FindService findService = context.getBean("findService",
                FindService.class);
        String response = findService.find(reqJson);

        logger.info("get find response: " + response);

        FindVendorsResponse resPojo = JSON.parseObject(response, FindVendorsResponse.class);
        return resPojo;
    }

    public ImportVendersResponse update(ImportVendersRequest updateReq) {

        String reqJson = JSON.toJSONString(updateReq);
        logger.info("send update request: " + reqJson);

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UpdateService updateService = context.getBean("updateService",
                UpdateService.class);
        String response = updateService.update(reqJson);

        logger.info("get update response: " + response);
        ImportVendersResponse resPojo = JSON.parseObject(response, ImportVendersResponse.class);

        return resPojo;
    }


}
