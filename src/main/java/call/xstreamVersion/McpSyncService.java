package call.xstreamVersion;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import org.apache.log4j.Logger;
import pojo.*;
import service.McpService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class McpSyncService {

    private static Logger logger = Logger.getLogger(McpSyncService.class);

    private McpService getWSPort() {
        try {
            URL wsdl = new URL("http://localhost:7070/webservice/mcp?wsdl");
            QName serviceName = new QName("http://service/", "McpService");
            QName portName = new QName("http://service/", "McpServicePort");
            Service service = Service.create(wsdl, serviceName);
            McpService mcpService = service.getPort(portName, McpService.class);
            logger.debug("get webservice port success!");
            return mcpService;
        } catch (Exception e) {
            logger.error("McpSyncService get port error ! ", e);
            throw new RuntimeException("McpSyncService get port fail !");
        }
    }

    public String find(FindVendorsRequest request) {
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
//        XStream xStream = new XStream(new JsonHierarchicalStreamDriver()
//        {
//            public HierarchicalStreamWriter createWriter(Writer writer)
//            {
//                return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
//            }
//        });

        xStream.setMode(XStream.NO_REFERENCES);
        xStream.alias("request", request.getClass());//TODO 怎么忽略头名称字段呢？
        String reqJson = xStream.toXML(request);
        logger.info("send find request: " + reqJson);
        McpService mcpService = this.getWSPort();
        String response = mcpService.find(reqJson);
        logger.info("get find response: " + response);
        return response;
    }

    public FindVendorsResponse parseFindVendorsResponse(String response) {
        logger.info("parse json: " + response);
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.setMode(XStream.NO_REFERENCES);
        xStream.alias("response", FindVendorsResponse.class);
        xStream.alias("vendorItem", VendorItemPojo.class);
        xStream.alias("vendorSiteInfoItem",VendorSiteInfoItemPojo.class);
        FindVendorsResponse resPojo = (FindVendorsResponse) xStream.fromXML(response);
        return resPojo;
    }

    public String update(ImportVendersRequest request){
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.setMode(XStream.NO_REFERENCES);
        xStream.alias("request", request.getClass());//TODO 怎么忽略头名称字段呢？
        xStream.alias("vendorItem", VendorPojo.class);
        String reqJson = xStream.toXML(request);
        logger.info("send update request: " + reqJson);
        McpService mcpService = this.getWSPort();
        String response = mcpService.update(reqJson);
        logger.info("get update response: " + response);
        return response;
    }

    public ImportVendersResponse parseImportVendersResponse(String response) {
        XStream xStream = new XStream(new JettisonMappedXmlDriver());
        xStream.setMode(XStream.NO_REFERENCES);
        xStream.alias("response", ImportVendersResponse.class);
        ImportVendersResponse resPojo = (ImportVendersResponse) xStream.fromXML(response);
        return resPojo;
    }
}
