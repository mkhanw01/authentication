package com.waseem.auth.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by khan on 12/14/17.
 */
@RestController
public class IndexController implements ErrorController {
  private static final String PATH = "/error";

  @RequestMapping(value = PATH)
  public String error() {
    return "Error handling page";
  }

  @Override
  public String getErrorPath() {
    return PATH;
  }
}
