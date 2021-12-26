package main.program;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Task {
	public static void main(String[] args) {
		//FP4
		Set<String> s = new TreeSet<>(Arrays.asList("axis2-adb-codegen-1.5.2.jar","axis2-adb-1.5.2.jar","axis2-codegen-1.5.2.jar","axis2-jaxbri-1.5.2.jar","axis2-java2wsdl-1.5.2.jar","axis2-jaxws-1.5.2.jar","axis2-json-1.5.2.jar","axis2-jibx-1.5.2.jar","axis2-saaj-1.5.2.jar","axis2-mtompolicy-1.5.2.jar","axis2-metadata-1.5.2.jar","axis2-xmlbeans-1.5.2.jar","axis2-transport-local-1.5.2.jar","axis2-transport-http-1.5.2.jar","axis2-spring-1.5.2.jar","commons-collections-3.2.2.jar","geronimo-annotation_1.0_spec-1.1.jar","neethi-2.0.4.jar","wsdl4j-1.6.2.jar","XmlSchema-1.4.3.jar","ibatis-dao.jar","ibatis-sqlmap.jar","swagger-annotations-1.3.12.jar","swagger-core_2.11-1.3.12.jar","swagger-jaxrs_2.11-1.3.12.jar","xbean-spring.jar","xbean_unica.jar","gson-2.3.1.jar","jwt-common-1.0.0.jar","xlxpScanner.jar","xlxpWASParsers.jar","xlxpScannerUtils.jar","commons-cli.jar","commons-digester.jar","commons-lang3-3.3.2.jar","commons-logging.jar","commons-pool.jar","commons-validator.jar","ibatis-common-ibm-cleanroom.jar","JSON4J_Apache.jar","activation.jar","mail.jar","jmxremote_optional.jar","jcifs.jar","jdom.jar","jersey-client-1.17.jar","jersey-core-1.17.jar","jersey-json-1.17.jar","jersey-multipart-1.17.jar","jersey-server-1.17.jar","jersey-servlet-1.17.jar","json-smart-1.3.1.jar","joda-time.jar","opencsv.jar","aopalliance.jar","spring-security-cas-client.jar","commons-discovery.jar","commons-httpclient-3.1.jar","csrfguard-3.0.0.jar","json4s-ast_2.11-3.2.11.jar","json4s-core_2.11-3.2.11.jar","json4s-jackson_2.11-3.2.11.jar","json4s-native_2.11-3.2.11.jar","scala-library-2.11.1.jar","scala-xml-2.11.0-M4.jar","axiom-api-1.2.15.jar","axiom-impl-1.2.15.jar","axiom-dom-1.2.15.jar","woden-impl-dom-1.0M8.jar","woden-api-1.0M8.jar","commons-io-1.4.jar","xml-resolver-1.2.jar","JSON4J.jar","commons-chain.jar","commons-net.jar","quartz.jar","gwt-servlet.jar","EspressAPI.jar","EspressAPI_2D.jar","EspressAPI_3D.jar","ExportLib.jar","joda-time-1.5.2.jar","rampart-core-1.5.2.jar","rampart-trust-1.5.2.jar","rampart-policy-1.5.2.jar","velocity-1.5.jar","antlr.jar","jaxen-1.1-beta-5.jar","asm.jar","cglib.jar","javassist.jar","taglibs-standard-impl-1.2.5.jar","taglibs-standard-spec-1.2.5.jar","xalan.jar","serializer.jar","commons-csv-1.4.jar","cognosClient.jar","cognos-axis.jar","CAM_AAA_CustomIF.jar","poi-3.17.jar","axiom-compat-1.2.15.jar","validation-api-2.0.1.Final.jar","jose4j-0.5.5.jar","spring-data-commons-2.1.9.RELEASE.jar","spring-security-oauth2-2.3.6.RELEASE.jar","axis2-kernel-1.5.6.jar","commons-dbcp-1.4.jar","hibernate-jpa-2.1-api-1.0.2.jar","javax.persistence-api-2.2.jar","commons-beanutils-1.9.4.jar","nimbus-jose-jwt-7.9.jar","aspectjrt-1.8.6.jar","aspectjweaver-1.8.6.jar","mapstruct-1.0.0.Beta4.jar","springfox-spi-2.1.2.jar","springfox-schema-2.1.2.jar","springfox-core-2.1.2.jar","springfox-swagger2-2.1.2.jar","springfox-swagger-common-2.1.2.jar","springfox-spring-web-2.1.2.jar","springfox-swagger-ui-2.1.2.jar","spring-plugin-metadata-1.2.0.RELEASE.jar","spring-plugin-core-1.2.0.RELEASE.jar","spring-hateoas-0.17.0.RELEASE.jar","swagger-annotations-1.5.0.jar","swagger-models-1.5.0.jar","commons-fileupload-1.4.jar","tiles-jsp.jar","tiles-core.jar","tiles-api.jar","tiles-template.jar","tiles-servlet.jar","tiles-request-servlet.jar","tiles-request-jsp.jar","tiles-request-api.jar","tiles-autotag-core-runtime.jar","tiles-extras.jar","dom4j-2.1.3.jar","spring-aop.jar","spring-beans.jar","spring-context.jar","spring-context-support.jar","spring-core.jar","spring-expression.jar","spring-jdbc.jar","spring-orm.jar","spring-test.jar","spring-tx.jar","spring-web.jar","spring-webmvc.jar","icu4j.jar","hibernate-core-5.4.24.Final.jar","jsch-0.1.55.jar","log4j-api-2.13.2.jar","log4j-core-2.13.2.jar","spring-security-acl-5.1.12.RELEASE.jar","spring-security-core-5.1.12.RELEASE.jar","spring-security-config-5.1.12.RELEASE.jar","spring-security-web-5.1.12.RELEASE.jar","spring-security-taglibs-5.1.12.RELEASE.jar","spring-security-openid-5.1.12.RELEASE.jar","spring-security-ldap-5.1.12.RELEASE.jar","bcprov-jdk15on-1.68.jar","byte-buddy-1.10.17.jar","classmate-1.5.1.jar","commons-lang.jar","guava.jar","openid-connect-common-1.3.3.jar","opensaml.jar","openws.jar","xmltooling.jar","hibernate-commons-annotations.jar","hibernate-ehcache.jar","spring-ldap-core.jar","hibernate-validator-6.0.20.Final.jar","commons-codec.jar","log4j-1.2-api-2.13.2.jar","jackson-annotations-2.12.1.jar","jackson-core-2.12.1.jar","jackson-databind-2.12.1.jar","jackson-module-jaxb-annotations-2.12.1.jar","jackson-jaxrs-json-provider-2.12.1.jar","jackson-jaxrs-base-2.12.1.jar","slf4j-log4j12.jar","httpclient-4.5.13.jar","httpcore-4.4.13.jar","wss4j-1.6.17.jar","activemq-client-5.16.1.jar","geronimo-j2ee-management_1.1_spec-1.0.1.jar","geronimo-jms_1.1_spec-1.1.1.jar","hawtbuf-1.11.jar","openid-connect-client-1.3.3.jar","failureaccess-1.0.1.jar","jsr305-3.0.2.jar","error_prone_annotations-2.3.4.jar","listenablefuture-guava.jar","j2objc-annotations-1.3.jar","checker-qual-3.5.0.jar","taglibs-standard-jstlel-1.2.5.jar","jboss-logging-3.4.1.Final.jar","slf4j-api.jar","ehcache-core-2.6.11.jar","xmlsec.jar","jasypt-1.9.3.jar","jasypt-spring4-1.9.3.jar","xstream-1.4.15.jar","mex-1.5.2.jar","unica-helper.jar","uar_cognos10_impl.jar","om-common-2.0.jar","manager_client.jar","campaigncore.jar","affiniumreports.jar","InteractClient.jar","monitor.jar","codeGenerator.jar","tableMappingDefinition.jar","ACO.jar","unica-common.jar","jta-1.1.jar","jaxrpc-api-1.1.jar","Campaign.jar"));
		System.out.println(s.size());
//		for (String string : s) {
//			System.out.println(string);
//		}
//		Map<String, Integer> mm = new HashMap<>();
//		for (int i = 0; i < s.size(); i++) {
//			int d = mm.getOrDefault(s.get(i), 0);
//			if(d>0) System.out.println(s.get(i));
//			else mm.put(s.get(i), 1);
//		}
		//12.1.1
		Set<String> s1 = new TreeSet<>(Arrays.asList("ACO.jar","CAM_AAA_CustomIF.jar","Campaign.jar","EspressAPI.jar","EspressAPI_2D.jar","EspressAPI_3D.jar","ExportLib.jar","InteractClient.jar","InteractDT.jar","JSON4J.jar","JSON4J_Apache.jar","XmlSchema-1.4.3.jar","activation.jar","activemq-client-5.16.1.jar","affiniumreports.jar","antlr.jar","aopalliance.jar","asm.jar","aspectjrt-1.8.6.jar","aspectjweaver-1.8.6.jar","axiom-api-1.2.15.jar","axiom-compat-1.2.15.jar","axiom-dom-1.2.15.jar","axiom-impl-1.2.15.jar","axis2-adb-1.5.2.jar","axis2-adb-codegen-1.5.2.jar","axis2-codegen-1.5.2.jar","axis2-java2wsdl-1.5.2.jar","axis2-jaxbri-1.5.2.jar","axis2-jaxws-1.5.2.jar","axis2-jibx-1.5.2.jar","axis2-json-1.5.2.jar","axis2-kernel-1.5.6.jar","axis2-metadata-1.5.2.jar","axis2-mtompolicy-1.5.2.jar","axis2-saaj-1.5.2.jar","axis2-spring-1.5.2.jar","axis2-transport-http-1.5.2.jar","axis2-transport-local-1.5.2.jar","axis2-xmlbeans-1.5.2.jar","bcprov-jdk15on-1.68.jar","byte-buddy-1.10.17.jar","campaigncore.jar","cglib.jar","checker-qual-3.5.0.jar","classmate-1.5.1.jar","codeGenerator.jar","cognos-axis.jar","cognosClient.jar","commons-beanutils-1.9.4.jar","commons-chain.jar","commons-cli.jar","commons-codec.jar","commons-collections-3.2.2.jar","commons-csv-1.4.jar","commons-dbcp-1.4.jar","commons-digester.jar","commons-discovery.jar","commons-fileupload-1.4.jar","commons-httpclient-3.1.jar","commons-io-2.8.0.jar","commons-lang.jar","commons-lang3-3.3.2.jar","commons-logging.jar","commons-net.jar","commons-pool.jar","commons-validator.jar","csrfguard-3.0.0.jar","disruptor-3.4.2.jar","dom4j-2.1.3.jar","ehcache-core-2.6.11.jar","error_prone_annotations-2.3.4.jar","failureaccess-1.0.1.jar","geronimo-annotation_1.0_spec-1.1.jar","geronimo-j2ee-management_1.1_spec-1.0.1.jar","geronimo-jms_1.1_spec-1.1.1.jar","gson-2.3.1.jar","guava.jar","gwt-servlet.jar","hawtbuf-1.11.jar","hibernate-commons-annotations.jar","hibernate-core-5.4.24.Final.jar","hibernate-ehcache.jar","hibernate-jpa-2.1-api-1.0.2.jar","hibernate-validator-6.0.20.Final.jar","httpclient-4.5.13.jar","httpcore-4.4.13.jar","ibatis-common-ibm-cleanroom.jar","ibatis-dao.jar","ibatis-sqlmap.jar","icu4j.jar","j2objc-annotations-1.3.jar","jackson-annotations-2.12.1.jar","jackson-core-2.12.1.jar","jackson-databind-2.12.1.jar","jackson-jaxrs-base-2.12.1.jar","jackson-jaxrs-json-provider-2.12.1.jar","jackson-module-jaxb-annotations-2.12.1.jar","jasypt-1.9.3.jar","jasypt-spring4-1.9.3.jar","javassist.jar","javax.persistence-api-2.2.jar","jaxen-1.1-beta-5.jar","jaxrpc-api-1.1.jar","jboss-logging-3.4.1.Final.jar","jcifs.jar","jdom.jar","jersey-client-1.17.jar","jersey-core-1.17.jar","jersey-json-1.17.jar","jersey-multipart-1.17.jar","jersey-server-1.17.jar","jersey-servlet-1.17.jar","jmxremote_optional.jar","joda-time-1.5.2.jar","joda-time.jar","jose4j-0.5.5.jar","jsch-0.1.55.jar","json-smart-2.4.7.jar","json4s-ast_2.11-3.2.11.jar","json4s-core_2.11-3.2.11.jar","json4s-jackson_2.11-3.2.11.jar","json4s-native_2.11-3.2.11.jar","jsr305-3.0.2.jar","jta-1.1.jar","jwt-common-1.0.0.jar","listenablefuture-guava.jar","log4j-1.2-api-2.13.2.jar","log4j-api-2.13.2.jar","log4j-core-2.13.2.jar","mail.jar","manager_client.jar","mapstruct-1.0.0.Beta4.jar","mex-1.5.2.jar","monitor.jar","neethi-2.0.4.jar","nimbus-jose-jwt-7.9.jar","om-common-2.0.jar","opencsv.jar","openid-connect-client-1.3.3.jar","openid-connect-common-1.3.3.jar","opensaml.jar","openws.jar","poi-3.17.jar","quartz.jar","rampart-core-1.5.2.jar","rampart-policy-1.5.2.jar","rampart-trust-1.5.2.jar","scala-library-2.11.1.jar","scala-xml-2.11.0-M4.jar","serializer.jar","slf4j-api.jar","slf4j-log4j12.jar","spring-aop.jar","spring-beans.jar","spring-context-support.jar","spring-context.jar","spring-core.jar","spring-data-commons-2.1.9.RELEASE.jar","spring-expression.jar","spring-hateoas-0.17.0.RELEASE.jar","spring-jdbc.jar","spring-ldap-core.jar","spring-orm.jar","spring-plugin-core-1.2.0.RELEASE.jar","spring-plugin-metadata-1.2.0.RELEASE.jar","spring-security-acl.jar","spring-security-cas-client.jar","spring-security-config.jar","spring-security-core.jar","spring-security-ldap.jar","spring-security-oauth2-2.3.6.RELEASE.jar","spring-security-openid.jar","spring-security-taglibs.jar","spring-security-web.jar","spring-test.jar","spring-tx.jar","spring-web.jar","spring-webmvc.jar","springfox-core-2.1.2.jar","springfox-schema-2.1.2.jar","springfox-spi-2.1.2.jar","springfox-spring-web-2.1.2.jar","springfox-swagger-common-2.1.2.jar","springfox-swagger-ui-2.1.2.jar","springfox-swagger2-2.1.2.jar","swagger-annotations-1.3.12.jar","swagger-annotations-1.5.0.jar","swagger-core_2.11-1.3.12.jar","swagger-jaxrs_2.11-1.3.12.jar","swagger-models-1.5.0.jar","tableMappingDefinition.jar","taglibs-standard-impl-1.2.5.jar","taglibs-standard-jstlel-1.2.5.jar","taglibs-standard-spec-1.2.5.jar","tiles-api.jar","tiles-autotag-core-runtime.jar","tiles-core.jar","tiles-extras.jar","tiles-jsp.jar","tiles-request-api.jar","tiles-request-jsp.jar","tiles-request-servlet.jar","tiles-servlet.jar","tiles-template.jar","uar_cognos10_impl.jar","unica-common.jar","unica-helper.jar","validation-api-2.0.1.Final.jar","velocity-1.5.jar","woden-api-1.0M8.jar","woden-impl-dom-1.0M8.jar","wsdl4j-1.6.2.jar","wss4j-1.6.17.jar","xalan.jar","xbean-spring.jar","xbean_unica.jar","xlxpScanner.jar","xlxpScannerUtils.jar","xlxpWASParsers.jar","xml-resolver-1.2.jar","xmlsec.jar","xmltooling.jar","xstream.jar"));
//		s1.removeAll(s);
//		for (String string : s1) {
//			System.out.println(string);
//		}
		
		s.removeAll(s1);
		for (String string : s) {
			System.out.println(string);
		}
	}

}