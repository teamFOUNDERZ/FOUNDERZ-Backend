package com.founderz.presentation;

import com.founderz.common.vo.SecuredUserId;
import com.founderz.common.vo.UserId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class HealthController {
    @GetMapping("/test/health")
    String healthyCheck() {
        return "still alive.";
    }

    @GetMapping("/test/string/{userId}")
    String testStringConverterPathVariable(@PathVariable SecuredUserId userId) {
        return userId.userId() + userId.userId().getClass().getSimpleName();
    }

    @GetMapping("/test/long/{userId}")
    String testLongConverterPathVariable(@PathVariable UserId userId) {
        return userId.userId() + userId.userId().getClass().getSimpleName();
    }

    @GetMapping("/test/string")
    String testStringConverterRequestParam(@RequestParam(name = "id") SecuredUserId userId) {
        return userId.userId() + userId.userId().getClass().getSimpleName();
    }

    @GetMapping("/test/long")
    String testLongConverterRequestParam(@RequestParam(name = "id") UserId userId) {
        return userId.userId() + userId.userId().getClass().getSimpleName();
    }
}
