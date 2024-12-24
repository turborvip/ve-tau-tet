package com.xxxx.ddd.domain.service.impl;

import com.xxxx.ddd.domain.model.entity.TicketDetail;
import com.xxxx.ddd.domain.repository.TicketDetailRepository;
import com.xxxx.ddd.domain.service.TicketDetailDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TicketDetailDomainServiceImpl implements TicketDetailDomainService {
    // Call repository in domain
    private static int count = 0;

    @Autowired
    private TicketDetailRepository ticketDetailRepository;

    @Override
    public TicketDetail getTicketDetailById(Long ticketId) {
        log.info("Implement Domain : {}", ticketId);
        return ticketDetailRepository.findById(ticketId).orElse(null);
    }

    @Override
    public String getTicketDetailByIdFake(Long id) {
        try{
            Thread.sleep(1000);
            count++;
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted",e);
        }
        return "Ticket: Ban Ve tet ngay 01/11/2021 - So luong: 1000 ve - src : DB - count: "+count+" TicketID: " + id;
    }
}
