package demo.biz;

import com.jinritemai.cloud.base.api.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * author       hahafeng
 * created_at   2022/7/9 11:17 下午
 */
@Component
public class PrintService {
    private static final Logger logger = LoggerFactory.getLogger(PrintService.class);

    @Resource
    private TokenService tokenService;

    @PostConstruct
    public void testTokenService() {
        final String authId = "1111116018";
        try {
            final String token = tokenService.getToken(authId);
            logger.info("token value :: {}", token);
        } catch (Exception e) {
            // todo :: 异常处理
            logger.error("Failed to getToken!", e);
        }
    }

}
