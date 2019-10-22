



import bean.*;
import org.junit.Test;
import until.JaxbUtil;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuc
 * @create 2013-3-29 下午2:50:00
 */
public class JaxbTest1 {
    /**
     * @throws JAXBException
     */
    @Test
    public void showMarshaller() {
        CEB311Message ceb311Message = new CEB311Message();
        ceb311Message.setGuid("556E1CFD-EDED-46B1-946C-B8022E42FC94");
        ceb311Message.setVersion("1.0");
        Order order = new Order();

        OrderHead orderHead = new OrderHead();
        orderHead.setGuid("556E1CFD-EDED-46B1-946C-B8022E42FC94");

        order.setOrderHead(orderHead);

        BaseTransfer baseTransfer = new BaseTransfer();
        baseTransfer.setNote("BaseTransfer");
        baseTransfer.setCopName("测试企业");
        ceb311Message.setBaseTransfer(baseTransfer);
        List<OrderList> orderList = new ArrayList<OrderList>();
        for (int i = 0; i < 10; i++) {
            OrderList orderItem = new OrderList();
            orderItem.setCurrency(i + "");
            orderItem.setCountry(i + "");
            orderList.add(orderItem);
        }


        order.setOrderList(orderList);

        ceb311Message.setOrder(order);

        String str = JaxbUtil.convertToXml(ceb311Message);
        System.out.println(str);
    }

}
