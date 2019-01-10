package cn.qlq.action;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.qlq.bean.Doctor;
import cn.qlq.bean.Register;
import cn.qlq.blog.result.Result;
import cn.qlq.blog.result.ResultFactory;
import cn.qlq.service.impl.UserServiceImpl;

@RestController
public class RegisterController {
	@Autowired
	private UserServiceImpl userServiceImpl;//依赖注入
	
@RequestMapping(value="/register",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	
	@ResponseBody
	public Result register(@Valid@RequestBody Register res,BindingResult bindingResult)
	{
	    System.out.println("3");
	    System.out.println(res.toString());
		if(bindingResult.hasErrors()) {
			String message = String.format("挂号失败,详细信息[%s]", bindingResult.getFieldError().getDefaultMessage());
			System.out.println("1");
			System.out.println(res.toString());
			return ResultFactory.buildFailResult(message);
		}
		else
		{
			System.out.println("2");
			System.out.println(res.toString());
			userServiceImpl.insertRegisterS(res);
			return ResultFactory.buildSuccessResult("挂号成功");
		}
	}

    @RequestMapping(value="/findDoctor",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public List<Doctor> findDoctor(@RequestBody Doctor res)
    {	
    	System.out.println("===================================");
    	System.out.println(res.getType());
    	String str = res.getType();
    	System.out.println(str);
    	List<Doctor> list = userServiceImpl.finddoctor(str);
		return list;
    	
    }
}
