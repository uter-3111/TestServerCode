package demo.biz;

import com.jinritemai.cloud.base.api.BaseRequest;
import com.jinritemai.cloud.base.api.BaseResponse;
import com.jinritemai.cloud.base.api.ExtensionService;
import com.jinritemai.cloud.base.api.ExtensionServiceHandler;
import demo.api.ItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@ExtensionService("GetWarnlog")
@Slf4j
public class GetWarnlog implements ExtensionServiceHandler<Integer, ItemDTO> {
    @Override
    public BaseResponse<ItemDTO> handle(BaseRequest<Integer> req) {
        long logstime = System.currentTimeMillis();
        String podName = System.getenv("HOSTNAME");
        log.warn("WARN~ LOG: GetItemService -23 {},To be, or not to be, that is a question: Whether it is nobler in the mind to suffer. The slings and arrows of outrageous fortune Or to take arms against a sea of troubles, And by opposing end them? To die: to sleep; No more; and by a sleep to say we end The heart-ache and the thousand natural shocks That flesh is heir to, 'tis a consummation Devoutly to be wish'd. To die, to sleep To sleep- perchance to dream: ay, there's the rub! For in that sleep of death what dreams may come When we have shuffled off this mortal coil, Must give us pause. There 's the respect That makes calamity of so long life--William Shakespeare", req.getData());
        return BaseResponse.<ItemDTO>builder().build();
    }
}
