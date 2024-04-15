<!--实现ftp协议常用的框架-->
        <dependency>
            <groupId>commons-net</groupId>
            <artifactId>commons-net</artifactId>
            <version>3.8.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.integration</groupId>
            <artifactId>spring-integration-ftp</artifactId>
        </dependency>



        @Bean
//    public IntegrationFlow ftpInboundFlow(SessionFactory<FTPFile> ftpSessionFactory, FtpConfiguration configuration) {
//        System.out.println("ftp-serverUrl=" + serverUrl);
//        return IntegrationFlows
//                .from(Ftp.inboundAdapter(ftpSessionFactory)
//                                .preserveTimestamp(true)
//                                //.remoteDirectory("subject3") 不设置此就是默认根目录
//                                //.regexFilter(".*\\.txt$") 不设置此就是全过滤
//                                //监听路径
//                                //.localDirectory(new File("temp")),
//                        e -> e.id("ftpInboundAdapter")
//                                .autoStartup(true)
//                                .poller(Pollers.fixedDelay(1000)))
//                .handle(m -> fileHandler.handle(String.valueOf(m.getPayload())))
//                .get();
//    }



https://spring.io/blog/2020/03/18/spring-tips-remote-file-system-integrations-ftp-with-spring-integration
