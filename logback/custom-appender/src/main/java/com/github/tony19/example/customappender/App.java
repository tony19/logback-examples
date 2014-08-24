package com.github.tony19.example.customappender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(App.class);
    logger.info("hello world");
  }
}
