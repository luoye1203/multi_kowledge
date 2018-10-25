package com.lht.multi_kowledge.a_controller;

import com.lht.multi_kowledge.b_service.DateService;
import com.lht.multi_kowledge.b_service.ThreadTestService;
import com.lht.multi_kowledge.d_model.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by LHT on 2018/7/4.
 */
@RestController
@Api("日期测试")
@RequestMapping("/date/")
public class DateController {
	private final Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private DateService dateService;





	@RequestMapping(value = "/format", method = RequestMethod.GET)
	@ApiOperation(value = "日期格式测试 ",notes = "")
	@ApiParam(required = true)
	@ApiImplicitParams(
			{
			}
	)
	public BaseResponse jionTest() {
		try {

			dateService.formatTest();

		} catch (Exception e) {
			logger.error("日期格式测试出现bug", e);
			return BaseResponse.buildResponse().setCode(201).setMessage("测试失败").build();
		}
		BaseResponse response=BaseResponse.buildResponse().setCode(200).setMessage("测试成功").build();
		return response;
	}

	@RequestMapping(value = "/formatStandard", method = RequestMethod.GET)
	@ApiOperation(value = "通用日期格式测试 ",notes = "")
	@ApiParam(required = true)
	@ApiImplicitParams(
			{
			}
	)
	public BaseResponse formatStandardTest() {
		try {

			dateService.formatStandardTest();

		} catch (Exception e) {
			logger.error("日期格式测试出现bug", e);
			return BaseResponse.buildResponse().setCode(201).setMessage("测试失败").build();
		}
		BaseResponse response=BaseResponse.buildResponse().setCode(200).setMessage("测试成功").build();
		return response;
	}

}
