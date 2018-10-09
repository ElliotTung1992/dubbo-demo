package com.github.dge.mvc.test;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DOMTest {

    public static void main(String[] args) {
        //DOM解析
        DOM();
        //DOM4J解析
        DOM4J();
    }

    private static void DOM4J() {
        /*SAXReader reader = new SAXReader();
        try {
            org.dom4j.Document document = reader.read(new File("my/web/WEB-INF/web.xml"));
            Element webApp = document.getRootElement();
            Iterator iterator = webApp.elementIterator();
            while (iterator.hasNext()){
                Element element = (Element) iterator.next();
                System.out.println(element.getName());
                Iterator elementIterator = element.elementIterator();
                while (elementIterator.hasNext()){
                    Element element1 = (Element) elementIterator.next();
                    System.out.println(element1.getName());
                    System.out.println(element1.getStringValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private static void DOM() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("my/web/WEB-INF/web.xml");
            //获取特定节点集合
            NodeList servletMapping = document.getElementsByTagName("servlet-mapping");
            for (int i = 0; i < servletMapping.getLength(); i++) {
                Node item = servletMapping.item(i);
                //获取节点属性集合
                /*NamedNodeMap attributes = item.getAttributes();
                for (int j = 0; j < attributes.getLength(); j++) {
                    Node node = attributes.item(j);
                    //获取属性名
                    System.out.println(node.getNodeName());
                    //获取属性值
                    System.out.println(node.getNodeValue());
                }*/
                NodeList childNodes = item.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node node = childNodes.item(j);
                    String nodeName = node.getNodeName();
                    System.out.println(nodeName);
                    String nodeValue = node.getNodeValue();
                    System.out.println(nodeValue);
                    String localName = node.getTextContent();
                    System.out.println(localName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
