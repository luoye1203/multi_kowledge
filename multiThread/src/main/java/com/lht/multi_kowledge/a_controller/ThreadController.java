package com.lht.multi_kowledge.a_controller;

import com.lht.multi_kowledge.b_service.ThreadTestService;
import com.lht.multi_kowledge.d_model.base.BaseResponse;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by LHT on 2018/7/4.
 */
@RestController
@Api("线程测试")
@RequestMapping("/thread/")
public class ThreadController {
	private final Logger logger = Logger.getLogger(this.getClass());


	@Autowired
	private ThreadTestService threadTestService;


	@RequestMapping(value = "/join", method = RequestMethod.GET)
	@ApiOperation(value = "jion方法测试 ",notes = "")
	@ApiParam(required = true)
	@ApiImplicitParams(
			{
//					@ApiImplicitParam(name = "message",paramType = "query",value = "消息内容",dataType = "string",defaultValue = "测试消息...........")
			}
	)
	public BaseResponse jionTest() {
		try {
			threadTestService.jionMethodTest();
		} catch (Exception e) {
			logger.error("jion方法测试出现bug", e);
			return BaseResponse.buildResponse().setCode(201).setMessage("测试失败").build();
		}
		BaseResponse response=BaseResponse.buildResponse().setCode(200).setMessage("测试成功").build();
		return response;
	}


	@RequestMapping(value = "/join2", method = RequestMethod.GET)
	@ApiOperation(value = "jion方法测试 2 ",notes = "")
	@ApiParam(required = true)
	@ApiImplicitParams(
			{
//					@ApiImplicitParam(name = "message",paramType = "query",value = "消息内容",dataType = "string",defaultValue = "测试消息...........")
			}
	)
	public BaseResponse jionTest2() {
		try {
			threadTestService.jionMethodTest2();
		} catch (Exception e) {
			logger.error("jion方法测试出现bug", e);
			return BaseResponse.buildResponse().setCode(201).setMessage("测试失败").build();
		}
		BaseResponse response=BaseResponse.buildResponse().setCode(200).setMessage("测试成功").build();
		return response;
	}



	@RequestMapping(value = "/threadPool", method = RequestMethod.GET)
	@ApiOperation(value = "线程池测试 ",notes = "")
	@ApiParam(required = true)
	@ApiImplicitParams(
			{
//					@ApiImplicitParam(name = "message",paramType = "query",value = "消息内容",dataType = "string",defaultValue = "测试消息...........")
			}
	)
	public BaseResponse threadPoolTest() {
		try {
			threadTestService.threadPoolTest();
		} catch (Exception e) {
			logger.error("线程池测试出现bug", e);
			return BaseResponse.buildResponse().setCode(201).setMessage("测试失败").build();
		}
		BaseResponse response=BaseResponse.buildResponse().setCode(200).setMessage("测试成功").build();
		return response;
	}



	@RequestMapping(value = "/threadPoolWait", method = RequestMethod.GET)
	@ApiOperation(value = "线程池等待中断测试 ",notes = "")
	@ApiParam(required = true)
	@ApiImplicitParams(
			{
//					@ApiImplicitParam(name = "message",paramType = "query",value = "消息内容",dataType = "string",defaultValue = "测试消息...........")
			}
	)
	public BaseResponse threadPoolWaitTest() {
		try {
			threadTestService.threadPoolWaitTest();
		} catch (Exception e) {
			logger.error("线程池等待中断测试出现bug", e);
			return BaseResponse.buildResponse().setCode(201).setMessage("测试失败").build();
		}
		BaseResponse response=BaseResponse.buildResponse().setCode(200).setMessage("测试成功").build();
		return response;
	}
}
