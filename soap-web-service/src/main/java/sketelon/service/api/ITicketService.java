package sketelon.service.api;

import sketelon.entity.Ticket;

import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface ITicketService {
    Ticket getTicket();

    List<Ticket> listTickets();
}
