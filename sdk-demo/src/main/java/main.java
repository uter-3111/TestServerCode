//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.doudian.open.api.order_orderDetail.OrderOrderDetailRequest;
import com.doudian.open.api.order_orderDetail.OrderOrderDetailResponse;
import com.doudian.open.core.AccessToken;
import com.doudian.open.core.AccessTokenBuilder;
import com.doudian.open.core.GlobalConfig;

class Example {

    public static void main(String[] args) {
        GlobalConfig.initAppKey("7101112602368968222");
        GlobalConfig.initAppSecret("344b674a-b869-4aba-b107-33835a6f1571");
        GlobalConfig.getGlobalConfig().setOpenRequestUrl("https://openapi-fxg.jinritemai.com");
        AccessToken accessToken = AccessTokenBuilder.build(77977L);

        OrderOrderDetailRequest req = new OrderOrderDetailRequest();
        req.getParam().setShopOrderId("4974764390215036063");

        OrderOrderDetailResponse resp = req.execute(accessToken);
        System.out.println(resp.getData().getShopOrderDetail());
    }
}
