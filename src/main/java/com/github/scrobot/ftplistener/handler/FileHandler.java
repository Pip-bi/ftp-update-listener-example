package com.github.scrobot.ftplistener.handler;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;

/**
 * @author Aleksei Scrobot
 */
public interface FileHandler {

  void handle(String content);

}
