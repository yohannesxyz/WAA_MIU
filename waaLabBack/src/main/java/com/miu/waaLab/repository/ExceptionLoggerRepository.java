package com.miu.waaLab.repository;

import com.miu.waaLab.entity.ExceptionLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionLoggerRepository extends JpaRepository<ExceptionLogger, Long> {
}
