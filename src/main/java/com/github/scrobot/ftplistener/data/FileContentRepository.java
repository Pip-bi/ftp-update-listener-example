package com.github.scrobot.ftplistener.data;

import com.github.scrobot.ftplistener.data.FileContent;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Aleksei Scrobot
 */
public interface FileContentRepository extends CrudRepository<FileContent, String> {
}
