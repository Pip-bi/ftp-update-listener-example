package com.github.scrobot.ftplistener.handler;

import com.github.scrobot.ftplistener.data.FileContent;
import com.github.scrobot.ftplistener.data.FileContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Service;

/**
 * @author Aleksei Scrobot
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class FileHandleService implements FileHandler {

  private final FileContentRepository repository;

  @Override
  public void handle(String content) {
    var result = repository.save(new FileContent(content));

    log.info("inserted into redis -> {}", result);
  }
}
