package bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import static bean.NameSpace.NAMESPACE_CEB_URI;

/**
 * 传输报文实体节点
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)

public class BaseTransfer {

    private  String copCode;
    private  String copName;
    private String dxpMode;
    private  String dxpId;
    private  String note;
}
