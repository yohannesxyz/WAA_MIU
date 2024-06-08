package com.miu.waaLab.repository;

import com.miu.waaLab.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoggerRepo extends JpaRepository<Logger, Long> {
}