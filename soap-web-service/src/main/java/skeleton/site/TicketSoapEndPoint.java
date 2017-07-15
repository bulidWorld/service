package skeleton.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import sketelon.service.api.ITicketService;

/**
 * Created by Administrator on 2017/7/15.
 */
@Endpoint
public class TicketSoapEndPoint {
    /**
     * 命名空间，与xsd生命的命名空间一致
     */
    private static final String NAME_SPACE= "http://sketeton/spring-web-service/support";

    @Autowired
    private ITicketService ticketService;


}
