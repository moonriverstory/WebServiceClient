package json;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import pojo.FindVendorsRequest;

public class FastJsonTest {
    private static Logger logger = Logger.getLogger(FastJsonTest.class);

    public static void main(String[] args) {
        FindVendorsRequest findReq = new FindVendorsRequest();
        findReq.setSystemSource("MGJ");
        findReq.setBeginDate("2017-01-01");
        findReq.setEndDate("2018-01-01");
        findReq.setCurrentPage("1");
        findReq.setPageSize("10");
        findReq.setDataType("VENDOR");

        String json = JSON.toJSONString(findReq);

        logger.info("json: " + json);
    }
}
