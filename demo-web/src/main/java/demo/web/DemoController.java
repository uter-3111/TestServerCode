package demo.web;

import com.alibaba.fastjson.JSON;
import com.doudian.open.api.order_orderDetail.OrderOrderDetailRequest;
import com.doudian.open.api.order_orderDetail.OrderOrderDetailResponse;
import com.doudian.open.api.order_orderDetail.param.OrderOrderDetailParam;
import com.doudian.open.api.product_list.ProductListRequest;
import com.doudian.open.api.product_list.ProductListResponse;
import com.doudian.open.api.product_list.param.ProductListParam;
import com.doudian.open.core.GlobalConfig;
import com.jinritemai.cloud.base.api.TokenService;
import com.jinritemai.cloud.base.core.util.AuthThreadLocalUtil;
import com.jinritemai.cloud.base.core.util.LogUtils;
import demo.api.ItemDTO;
import demo.biz.ExceptionCheckPlanService;
import demo.biz.UserService;
import demo.dal.entity.ExceptionCheckPlan;
import demo.dal.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * author       hahafeng
 * created_at   2022/7/10 12:11 上午
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {
    private static final String LOG_ID_KEY = "x-tt-logid";

    @Autowired
    private UserService userService;

    @Resource
    private TokenService tokenService;

    @Autowired
    private ExceptionCheckPlanService exceptionCheckPlanService;


    @RequestMapping("/hello")
    public String hello() {
        final String word = "Hello New World!";
        log.info(word);
        return word;
    }

    @RequestMapping("/infolog")
    public String infolog() {
        long logstime = System.currentTimeMillis();
        MDC.put(LOG_ID_KEY, "20220" + logstime + "01");
        String podName = System.getenv("HOSTNAME");
        final String word = "info log! pod_name: " + podName+"To be, or not to be, that is a question: Whether it is nobler in the mind to suffer. The slings and arrows of outrageous fortune Or to take arms against a sea of troubles, And by opposing end them? To die: to sleep; No more; and by a sleep to say we end The heart-ache and the thousand natural shocks That flesh is heir to, 'tis a consummation Devoutly to be wish'd. To die, to sleep To sleep- perchance to dream: ay, there's the rub! For in that sleep of death what dreams may come When we have shuffled off this mortal coil, Must give us pause. There 's the respect That makes calamity of so long life--William Shakespeare 2：To be, or not to be, that is a question: Whether it is nobler in the mind to suffer. The slings and arrows of outrageous fortune Or to take arms against a sea of troubles, And by opposing end them? To die: to sleep; No more; and by a sleep to say we end The heart-ache and the thousand natural shocks That flesh is heir to, 'tis a consummation Devoutly to be wish'd. To die, to sleep To sleep- perchance to dream: ay, there's the rub! For in that sleep of death what dreams may come When we have shuffled off this mortal coil, Must give us pause. There 's the respect That makes calamity of so long life--William Shakespeare";
        log.info(word);
        return word;
    }

    @RequestMapping("/errlog")
    public String errlog() {
        long logstime = System.currentTimeMillis();
        MDC.put(LOG_ID_KEY, "20220" + logstime + "03");
        String podName = System.getenv("HOSTNAME");
        final String word = "error log! pod_name: " + podName;
        log.error(word);
        return word;
    }

    @RequestMapping("/wranlog")
    public String wranlog() {
        long logstime = System.currentTimeMillis();
        MDC.put(LOG_ID_KEY, "20220" + logstime + "02");
        String podName = System.getenv("HOSTNAME");
        final String word = "wran log!pod_name: " + podName;
        log.warn(word);
        return word;
    }


    @RequestMapping("/token")
    public String token() {
        try {
            final String token = tokenService.getToken("95250");
            log.info(token);
            return token;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/user")
    public List<User> queryUser() {
        return userService.find();
    }

    @GetMapping("/ext")
    public List<ExceptionCheckPlan> queryExt() {
        MDC.put(LOG_ID_KEY, "test-logId-333");
        return exceptionCheckPlanService.find();
    }

    @GetMapping("/api")
    public void itemApi() {
//        LogUtils.setLogId("20220721172502010174235038047A1000");
        AuthThreadLocalUtil.set("1111114035");
        OrderOrderDetailRequest request = new OrderOrderDetailRequest();
        OrderOrderDetailParam param = request.getParam();
        param.setShopOrderId("4949486364490458473");
        OrderOrderDetailResponse response = request.execute();

        log.info("response: {}", JSON.toJSONString(response));
    }

    @PostMapping("/post")
    public String testPost(@RequestBody ItemDTO itemDTO) {
        return itemDTO.getTitle();
    }

}
