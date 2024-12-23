package com.xxxx.ddd.domain.repository;

import com.xxxx.ddd.domain.model.entity.TicketDetail;

import java.util.Optional;

public interface TicketDetailRepository {

    Optional<TicketDetail> findById(Long id);
}
