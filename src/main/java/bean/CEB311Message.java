package bean;

import lombok.Data;

import javax.xml.bind.annotation.*;

import static bean.NameSpace.NAMESPACE_CEB_URI;


/**
 * Entity
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CEB311Message", namespace = NAMESPACE_CEB_URI)
public class CEB311Message {
    @XmlElement(name = "Order", namespace = NAMESPACE_CEB_URI)
    private Order order;

    @XmlAttribute(name = "guid")
    private String guid;

    @XmlAttribute(name = "version")
    private String version;

    @XmlElement(name = "BaseSubscribe", namespace = NAMESPACE_CEB_URI)
    private BaseSubscribe baseSubscribe;

    @XmlElement(name = "BaseTransfer", namespace = NAMESPACE_CEB_URI)
    private BaseTransfer baseTransfer;

    @XmlElement(name = "ExtendMessage", namespace = NAMESPACE_CEB_URI)
    private ExtendMessage extendMessage;

}
