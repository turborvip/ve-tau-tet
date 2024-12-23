package com.xxxx.ddd.domain.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface HiDomainRepository {
    String sayHi(String who);
}
