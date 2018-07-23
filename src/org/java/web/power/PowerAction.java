package org.java.web.power;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.java.entity.Manager;
import org.java.entity.Post;
import org.java.service.ManagerService;
import org.java.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class PowerAction extends ActionSupport  implements ServletRequestAware{
	private HttpServletRequest request;
    private HttpSession session;
    private Manager m;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private PostService postService;
    
    
    public String initList() {
        List<Manager> mList=managerService.findAllManager();
        request.setAttribute("mList", mList);
    	return "initList";
    }
    
    
    public String initAdd() {
    	List<Post> posts=postService.findAllPost();
    	request.setAttribute("posts", posts);
    	return "initAdd";
    }
    
    public String initUpdate() {
    	List<Post> posts=postService.findAllPost();
    	request.setAttribute("posts", posts);
    	return "initAdd";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		this.session=request.getSession();
	}
	public Manager getM() {
		return m;
	}
	public void setM(Manager m) {
		this.m = m;
	}
    
}
