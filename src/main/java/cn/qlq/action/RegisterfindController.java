package cn.qlq.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.qlq.bean.Register;
import cn.qlq.blog.result.Result;
import cn.qlq.blog.result.ResultFactory;
import cn.qlq.service.impl.UserServiceImpl;

@RestController
public class RegisterfindController {
	@Autowired
	private UserServiceImpl userServiceImpl;//依赖注入
	
	@RequestMapping(value="/registerfind",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public List<Register> register()
	{
		List<Register> list = userServiceImpl.findAllregister();
		return list;
	}
	
	@RequestMapping(value="/registerdelete",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Result delete(@RequestBody Register res,BindingResult bindingResult)
	{
		int id = res.getId();
		System.out.println(id);
		userServiceImpl.deleteRegisterS(id);
		if(bindingResult.hasErrors()) {
			String message = String.format("删除失败,详细信息[%s]", bindingResult.getFieldError().getDefaultMessage());
			return ResultFactory.buildFailResult(message);
		}
		return ResultFactory.buildSuccessResult("删除成功");
	}
	
	@RequestMapping(value="/registerupdate",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Result update(@RequestBody Register res,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) {
			String message = String.format("修改失败,详细信息[%s]", bindingResult.getFieldError().getDefaultMessage());
			return ResultFactory.buildFailResult(message);
		}
		userServiceImpl.updateRegisterS(res);
		System.out.print("===========================================================");
		System.out.print(res.getId());
		return ResultFactory.buildSuccessResult("修改成功");
	}
}
