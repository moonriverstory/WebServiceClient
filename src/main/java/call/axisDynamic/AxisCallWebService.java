package call.axisDynamic;

import java.net.URL;
import javax.xml.namespace.QName;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.axis.encoding.XMLType;
import javax.xml.rpc.ParameterMode;

/**
 * 
 * java调用C#的WebService服务
 *
 */
public class AxisCallWebService {
	
	 private static final Logger logger = LoggerFactory.getLogger(AxisCallWebService.class);

	/**
	 * 
	 * @param serviceUrl 服务名
	 * @param nameSpace
	 * @param methodName 执行的方法名
	 * @param paremateArrs  参数数据数组
	 * @param qNameArrs 变量数组
	 * @return
	 */
	public static String CallSoapService(String serviceUrl, String nameSpace, String methodName, Object[] paremateArrs,
			Object[] qNameArrs) {
		String endPoint = serviceUrl;
		String actionUrl = nameSpace + methodName;
		String returnObj = null;
		try {
			Service service = new Service();
			Call call = null;
			call = (Call) service.createCall();

			QName qName = new QName(nameSpace, methodName);
			call.setOperationName(qName);
			call.setSOAPActionURI(actionUrl);

			if (qNameArrs != null && qNameArrs.length != 0) {
				for (int i = 0, len = qNameArrs.length; i < len; i++) {
					call.addParameter(new QName(nameSpace, qNameArrs[i].toString()),
							XMLType.XSD_STRING, ParameterMode.IN);
				}
			}
			call.setReturnType(XMLType.XSD_STRING);
			call.setTargetEndpointAddress(new URL(endPoint));
			returnObj = (String) call.invoke(paremateArrs);

		} catch (Exception e) {
			logger.error("call webservice error. e=" + e);
		}
		logger.info("exit webservice. resultObj=" + returnObj);
		return returnObj;
	}
}
