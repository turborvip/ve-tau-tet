package com.xxxx.ddd.controller.http;

import com.xxxx.ddd.application.service.ticket.TicketDetailAppService;
import com.xxxx.ddd.controller.model.enums.ResultUtil;
import com.xxxx.ddd.controller.model.vo.ResultMessage;
import com.xxxx.ddd.domain.model.entity.TicketDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
@Slf4j
public class TicketDetailController {

    // CALL Service Application
    @Autowired
    private TicketDetailAppService ticketDetailAppService;

    @GetMapping("/{ticketId}/detail/{detailId}")
    public ResultMessage<TicketDetail> getTicketDetail(
            @PathVariable("ticketId") Long ticketId,
            @PathVariable("detailId") Long detailId
    ) {
//        log.info(" ticketId:{}, detailId:{}", ticketId, detailId);
        return ResultUtil.data(ticketDetailAppService.getTicketDetailById(detailId));
    }

    @GetMapping("/level1/{ticketId}/detail/{detailId}")
    public ResultMessage<String> getTicketDetaiLevel1(
            @PathVariable("ticketId") Long ticketId,
            @PathVariable("detailId") Long detailId
    ) {
        return ResultUtil.data(ticketDetailAppService.getTicketDetailByIdLevel1(detailId));
    }

    @GetMapping("/level2/{ticketId}/detail/{detailId}")
    public ResultMessage<String> getTicketDetaiLevel2(
            @PathVariable("ticketId") Long ticketId,
            @PathVariable("detailId") Long detailId
    ) {
        return ResultUtil.data(ticketDetailAppService.getTicketDetailByIdLevel2(detailId));
    }

    @GetMapping("/cache-vip/{ticketId}/detail/{detailId}")
    public ResultMessage<TicketDetail> getTicketDetailCacheVip(
            @PathVariable("ticketId") Long ticketId,
            @PathVariable("detailId") Long detailId
    ) {
        return ResultUtil.data(ticketDetailAppService.getTicketDetailByIdCacheVip(detailId));
    }
}
