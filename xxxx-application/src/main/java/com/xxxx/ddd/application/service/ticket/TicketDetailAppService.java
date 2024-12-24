package com.xxxx.ddd.application.service.ticket;

import com.xxxx.ddd.domain.model.entity.TicketDetail;

public interface TicketDetailAppService {
    TicketDetail getTicketDetailById(Long ticketId); // should convert to TickDetailDTO by Application Module

    String getTicketDetailByIdLevel1(Long ticketId);

    String getTicketDetailByIdLevel2(Long ticketId);

    TicketDetail getTicketDetailByIdCacheVip(Long ticketId);


}
