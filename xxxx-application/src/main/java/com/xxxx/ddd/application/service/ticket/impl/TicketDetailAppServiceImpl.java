package com.xxxx.ddd.application.service.ticket.impl;

import com.xxxx.ddd.application.service.ticket.TicketDetailAppService;
import com.xxxx.ddd.application.service.ticket.cache.TicketDetailCacheService;
import com.xxxx.ddd.domain.model.entity.TicketDetail;
import com.xxxx.ddd.domain.service.TicketDetailDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TicketDetailAppServiceImpl implements TicketDetailAppService {

    // CALL CACHE
    @Autowired
    private TicketDetailCacheService ticketDetailCacheService;

    @Override
    public TicketDetail getTicketDetailById(Long ticketId) {
        log.info("Implement Application : {}", ticketId);
        return ticketDetailCacheService.getTicketDefaultCacheLocal(ticketId, System.currentTimeMillis());
    }

    @Override
    public String getTicketDetailByIdLevel1(Long ticketId){
        return ticketDetailCacheService.getTicketItemFromDBByIdNormal(ticketId, System.currentTimeMillis());
    }

    @Override
    public String getTicketDetailByIdLevel2(Long ticketId) {
        return ticketDetailCacheService.getTicketDefaultCacheNormal(ticketId, System.currentTimeMillis());
    }

    @Override
    public TicketDetail getTicketDetailByIdCacheVip(Long ticketId) {
        return ticketDetailCacheService.getTicketDefaultCacheVip(ticketId, System.currentTimeMillis());

    }


}
