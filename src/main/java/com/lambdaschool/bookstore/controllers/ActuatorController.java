package com.lambdaschool.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ActuatorController {
  @GetMapping("health")
  public RedirectView redirectHealth() {
    return new RedirectView("actuator/health");
  }

  @GetMapping("info")
  public RedirectView redirectInfo() {
    return new RedirectView("actuator/info");
  }

  @GetMapping("metrics")
  public RedirectView redirectMetrics() {
    return new RedirectView("actuator/metrics");
  }
}
