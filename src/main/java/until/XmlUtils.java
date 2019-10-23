package until;

import org.apache.commons.lang.StringUtils;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import com.alibaba.fastjson.JSONObject;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alany on 2018/7/10.
 */
public class XmlUtils {
    public static JSONObject xml2Json(String xmlStr) throws JDOMException, IOException {
        if (StringUtils.isEmpty(xmlStr)) {
            return null;
        }
        xmlStr = xmlStr.replaceAll("\\\n", "");
        byte[] xml = xmlStr.getBytes("UTF-8");
        JSONObject json = new JSONObject();
        InputStream is = new ByteArrayInputStream(xml);
        SAXBuilder sb = new SAXBuilder();
        Document doc = sb.build(is);
        Element root = doc.getRootElement();
        json.put(root.getName(), iterateElement(root));

        return json;
    }

    private static JSONObject iterateElement(Element element) {
        List<Element> node = element.getChildren();
        JSONObject obj = new JSONObject();
        List list = null;
        for (Element child : node) {
            list = new LinkedList();
            String text = child.getTextTrim();
            if (StringUtils.isBlank(text)) {
                if (child.getChildren().size() == 0) {
                    continue;
                }
                if (obj.containsKey(child.getName())) {
                    list = (List) obj.get(child.getName());
                }
                list.add(iterateElement(child));
                //遍历child的子节点
                obj.put(child.getName(), list);
            } else {
                if (obj.containsKey(child.getName())) {
                    Object value = obj.get(child.getName());
                    try {
                        list = (List) value;
                    } catch (ClassCastException e) {
                        list.add(value);
                    }
                }
                if (child.getChildren().size() == 0) {
                    //child无子节点时直接设置text
                    obj.put(child.getName(), text);
                } else {
                    list.add(text);
                    obj.put(child.getName(), list);
                }
            }
        }
        return obj;
    }
}