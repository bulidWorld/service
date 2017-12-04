package org.zwx.audit.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
@EnableScheduling
public class ScheduleService {

    @Scheduled(fixedDelay = 180000)
    public void bakDataTask() {

    }
}
