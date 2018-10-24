package com.lht.multi_kowledge.a_controller;

import com.lht.multi_kowledge.b_service.DiGuiService;
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
@Api("递归测试")
@RequestMapping("/digui/")
public class DiGuiParamController {
	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private DiGuiService diGuiService;


	@RequestMapping(value = "/outsideParam", method = RequestMethod.GET)
	@ApiOperation(value = "外部参数测试 ",notes = "")
	@ApiParam(required = true)
	@ApiImplicitParams(
			{
			}
	)
	public BaseResponse jionTest() {
		try {
			diGuiService.diGuiParamTest();


		} catch (Exception e) {
			logger.error("测试出现bug", e);
			return BaseResponse.buildResponse().setCode(201).setMessage("测试失败").build();
		}
		BaseResponse response=BaseResponse.buildResponse().setCode(200).setMessage("测试成功").build();
		return response;
	}



}
