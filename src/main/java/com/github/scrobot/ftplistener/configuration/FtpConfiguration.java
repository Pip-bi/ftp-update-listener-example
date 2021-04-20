package com.github.scrobot.ftplistener.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Aleksei Scrobot
 */
@ConfigurationProperties(prefix = "spring.ftp")
@Accessors(chain = true)
@Setter
@Getter
public class FtpConfiguration {

  private String username;
  private String password;
  private String host;
  private Integer port;

}
