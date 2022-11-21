//package com.souleaf.spring.Quartz.controller;
//
//import java.util.ArrayList;
//
//import javax.annotation.PostConstruct;
//
//import org.quartz.JobDetail;
//import org.quartz.Scheduler;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
//import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
//import org.springframework.stereotype.Component;
//
//import com.souleaf.spring.boast.domain.Boast;
//import com.souleaf.spring.boast.service.BoastService;
//
//@Component
//public class QuartzController{
//	
//	private BoastService bService;
//     
//    // tomcat 구동 시 메소드가 자동 실행 되도록 하는 어노테이션
//    @PostConstruct
//    public void schedulerSet() throws Exception {
//     
//        // jobDetail 설정
//        MethodInvokingJobDetailFactoryBean jobDetailBean = new MethodInvokingJobDetailFactoryBean();
//        jobDetailBean.setTargetObject(new QuartzController());
//        jobDetailBean.setTargetMethod("scheduledStart");
//        jobDetailBean.setGroup("test1");
//        jobDetailBean.setName("scheduledStart");
//        jobDetailBean.afterPropertiesSet();
//         
//        // cronTriger 설정
//        CronTriggerFactoryBean cronTrigger = new CronTriggerFactoryBean();
//        cronTrigger.setJobDetail((JobDetail)jobDetailBean.getObject());
//        // Cron 표현식
//        // 1초마다 실행
//        // cronTrigger.setCronExpression("0/1 * * * * ?");
//        // 1분마다 실행
//        // cronTrigger.setCronExpression("0 0/1 * 1/1 * ? *");
//        // 매월1일 오전5시에 실행
//        cronTrigger.setCronExpression("0 0 5 1 1/1 ? *");
//        cronTrigger.setName("scheduledStart");
//        Scheduler sch = new StdSchedulerFactory().getScheduler();
//        sch.scheduleJob((JobDetail)jobDetailBean.getObject(),cronTrigger);
//        sch.start();
//    }
// 
//    /**
//     * 좋아요 포인트 초기화
//     * @author ohwoocheol
//     * @since 2021.8.16
//     * @throws Exception
//     */
//    public void scheduledStart() throws Exception{ 
//    	
////    	System.out.println("test");
//    	
//    	// 게시글 번호 전부 취득
//    	ArrayList<Boast> bList = bService.printAllNo();
//    	// 게시글의 좋아요 포인트 초기화
//    	for(Boast boast : bList){
//    		int result = bService.pointReset(boast.getBoastNo());
//    	}
//    }
//    
//	/**
//	 * 3위 까지 출력
//	 * @author ohwoocheol
//	 * @param boastNo 
//	 * @since 2021.8.15
//	 */
////    @RequestMapping(value="boastrank.kh", method=RequestMethod.GET)
//    public void printrank() {
//    	ArrayList<Boast> bList = bService.printRank();
//    }
//}