//package com.topsec.spring.demo.test.Controller;
//
//
//import ch.qos.logback.classic.Level;
//import ch.qos.logback.classic.LoggerContext;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @Auther: hwm
// * @Date: 2019/6/14 09:48
// * @Description:
// */
//@Api(description = "改变日志等级")
//@RestController
//@RequestMapping"/changeLogLevel")
//@Slf4j
//public class ChangeLogLevelController {
//
//    @ApiOperation("修改日志等级为info级别")
//    @RequestMapping(value = "/logLevelToInfo", method = RequestMethod.GET)
//    @ResponseBody
//    public ResultPageVo logLevelToInfo() {
//
//        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
//        Logger logger = loggerContext.getLogger("root");
//        ((ch.qos.logback.classic.Logger) logger).setLevel(Level.INFO);
//        log.info("============================================修改日志等级为info级别");
//        log.info("============================================修改日志等级为info级别");
//        log.info("============================================修改日志等级为info级别");
//        log.info("============================================修改日志等级为info级别");
//
//        return ResultPageVo.success();
//    }
//
//    @ApiOperation("修改日志等级为debug级别")
//    @RequestMapping(value = "/logLevelToDebug", method = RequestMethod.GET)
//    @ResponseBody
//    public ResultPageVo logLevelToDebug() {
//
//        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
//        Logger logger = loggerContext.getLogger("root");
//        ((ch.qos.logback.classic.Logger) logger).setLevel(Level.DEBUG);
//        log.debug("============================================修改日志等级为debug级别");
//        log.debug("============================================修改日志等级为debug级别");
//        log.debug("============================================修改日志等级为debug级别");
//        log.debug("============================================修改日志等级为debug级别");
//
//        return ResultPageVo.success();
//    }
//
