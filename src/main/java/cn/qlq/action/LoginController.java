package cn.qlq.action;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.qlq.bean.User;
import cn.qlq.bean.Usertype;
import cn.qlq.blog.result.Result;
import cn.qlq.blog.result.ResultFactory;
import cn.qlq.service.impl.UserServiceImpl;

@RestController
public class LoginController {
	@Autowired
	private UserServiceImpl userServiceImpl;//依赖注入
	//1./login
@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")

@ResponseBody

//2.post过来的数据a
public Result login(@RequestBody User loginUser,BindingResult bindingResult) {
	int flag = 0;
	List<User> list = userServiceImpl.findAllUser();
	List<Usertype> list2 = userServiceImpl.findAllUsertype();
	int usertype0 = list2.get(0).getType();
	int usertype1 = list2.get(1).getType();
	//3.返回
	if(bindingResult.hasErrors()) {
		String message = String.format("登录失败,详细信息[%s]", bindingResult.getFieldError().getDefaultMessage());
		return ResultFactory.buildFailResult(message);
	}
		for (int i = 0; i < list.size(); i++)
		{
			String username = list.get(i).getUsername();
			String password = list.get(i).getPassword();
			int type = list.get(i).getType();
			if(Objects.equals(username, loginUser.getUsername()) && Objects.equals(password, loginUser.getPassword()) 
					&& type==loginUser.getType())
			{
				if(usertype0==type){
					flag=1;
				}
				else if(usertype1==type) {
					flag=1;
				}else {
					System.out.println(loginUser.getUsername()+loginUser.getPassword()+loginUser.getType()+"==========");
				}
			}
			else
			{		
				System.out.println(loginUser.getUsername()+loginUser.getPassword()+loginUser.getType());
			}
		}
		if(flag==0) {
			System.out.println(loginUser.getUsername()+loginUser.getPassword()+loginUser.getType());
			return ResultFactory.buildFailResult("登陸失敗");
		}
		else {
			System.out.println("成功"+loginUser.getUsername()+loginUser.getPassword()+loginUser.getType());
		    return ResultFactory.buildSuccessResult("登陆成功");
		}
}
}
