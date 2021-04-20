package com.github.scrobot.ftplistener.configuration;

import com.github.scrobot.ftplistener.handler.FileHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.ftp.dsl.Ftp;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;

import java.io.File;

/**
 * @author Aleksei Scrobot
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class InboundConfiguration {

  private final FileHandler fileHandler;

  @Bean
  public SessionFactory<FTPFile> ftpSessionFactory(FtpConfiguration configuration) {
    DefaultFtpSessionFactory sf = new DefaultFtpSessionFactory();
    sf.setHost(configuration.getHost());
    sf.setPort(configuration.getPort());
    sf.setUsername(configuration.getUsername());
    sf.setPassword(configuration.getPassword());

    return new CachingSessionFactory<>(sf);
  }

  @Bean
  public IntegrationFlow ftpInboundFlow(SessionFactory<FTPFile> ftpSessionFactory, FtpConfiguration configuration) {
    return IntegrationFlows
        .from(Ftp.inboundAdapter(ftpSessionFactory)
                .preserveTimestamp(true)
                .remoteDirectory("~/" + configuration.getUsername() + "/")
                .regexFilter(".*\\.txt$")
                .localFilename(f -> f.toUpperCase() + ".a")
                .localDirectory(new File("tmp")),
            e -> e.id("ftpInboundAdapter")
                .autoStartup(true)
                .poller(Pollers.fixedDelay(5000)))
        .handle(m -> fileHandler.handle(String.valueOf(m.getPayload())))
        .get();
  }


}
