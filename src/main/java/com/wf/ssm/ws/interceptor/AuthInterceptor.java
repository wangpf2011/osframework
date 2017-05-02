package com.wf.ssm.ws.interceptor;

import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.NodeList;

import com.wf.ssm.common.config.Global;
import com.wf.ssm.common.utils.StringUtils;

/**
 * <P>Webservice交互经常需要验证用户，用户名和密码的传递采用SOAPHeader传递不失为一种好办法</P>
 * 
 * @version 1.0
 * @author wangpf
 * @since JDK 1.6
 * 2016年1月6日 下午9:42:17
 */
public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private SAAJInInterceptor saa = new SAAJInInterceptor();

	public AuthInterceptor() {
		super(Phase.PRE_PROTOCOL);
		//super(Phase.PRE_STREAM); // 触发点在流关闭之前
		getAfter().add(SAAJInInterceptor.class.getName());
	}

	public void handleMessage(SoapMessage message) throws Fault {
		SOAPMessage mess = message.getContent(SOAPMessage.class);
		if(mess == null) {
			saa.handleMessage(message);
			mess = message.getContent(SOAPMessage.class);
		}
		SOAPHeader head = null;
		try {
			head = mess.getSOAPHeader();
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(head == null) {
			return;
		}
		NodeList nodes1 = head.getElementsByTagName("ns1:username");
		NodeList nodes2 = head.getElementsByTagName("ns2:password");
		String username = Global.getConfig("ws.username");
		String password = Global.getConfig("ws.password");

		if(nodes1 == null || nodes1.getLength() <= 0 
				|| nodes2 == null || nodes2.getLength() <= 0 
				|| StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			logger.error("认证错误!");
			WSUtils.errorType = 1;
			//SOAPException soapExc = new SOAPException("认证错误");
			//throw new Fault(soapExc);
		}else {
			if(username.equals(nodes1.item(0).getTextContent())
					&& password.equals(nodes2.item(0).getTextContent())) {
				System.out.println("认证成功");
			}else {
				logger.error("认证错误!");
				WSUtils.errorType = 1;
				//SOAPException soapExc = new SOAPException("认证错误");
				//throw new Fault(soapExc);
			}
		}
	}
}
