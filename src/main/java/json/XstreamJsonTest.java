package json;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import org.apache.log4j.Logger;

public class XstreamJsonTest {
    private static Logger logger = Logger.getLogger(XstreamJsonTest.class);

    public static void main(String[] args) {
        XStream xStream = new XStream(new JettisonMappedXmlDriver());

//        logger.info("send find request: " + reqJson);
    }
}
