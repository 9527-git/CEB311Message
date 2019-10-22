package bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import static bean.NameSpace.NAMESPACE_CEB_URI;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Order ", namespace = NAMESPACE_CEB_URI)
public class Order {

    @XmlElement(name = "OrderHead", namespace = NAMESPACE_CEB_URI)
    private OrderHead orderHead;

    @XmlElement(name = "OrderList", namespace = NAMESPACE_CEB_URI)
    private List<OrderList> orderList;

}
