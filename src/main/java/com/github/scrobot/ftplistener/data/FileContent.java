package com.github.scrobot.ftplistener.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Aleksei Scrobot
 */
@Data
@RedisHash("file_contents")
@RequiredArgsConstructor
@Accessors(chain = true)
public class FileContent implements Serializable {

  public final String id = UUID.randomUUID().toString();
  public final String data;

}
