package com.GetForkedNerd.2bGroup.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Logging {
  Logger LOGGER = LogManager.getLogger();

  static Logger getLogger() {
    return LOGGER;
  }
}
