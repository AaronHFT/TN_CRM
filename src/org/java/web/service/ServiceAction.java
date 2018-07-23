package org.java.web.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.java.entity.Customerinfo;
import org.java.entity.Customerserve;
import org.java.entity.Datadictionary;
import org.java.entity.Manager;
import org.java.service.CustomerinfoService;
import org.java.service.CustomerserveService;
import org.java.service.DatadictionaryService;
import org.java.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

@SuppressWarnings("serial")
public class ServiceAction extends ActionSupport implements ServletRequestAware{
          private HttpServletRequest request;
          private HttpSession session;
          @Autowired
          private DatadictionaryService datadictionaryService;
          @Autowired
          private CustomerinfoService customerinfoService;
          @Autowired
          private ManagerService managerService;
          @Autowired
          private CustomerserveService customerserveService;
          private Customerserve cs;      
          /**
           * 初始化创建服务信息
           * @return
           */
          public String initCreate() {
        	  List<Datadictionary> types=datadictionaryService.findServiceType();
        	  request.setAttribute("serveTypes", types);
        	  List<Customerinfo> customerinfos=customerinfoService.findLiveCustomers();
        	  request.setAttribute("customerinfos", customerinfos);
        	  request.setAttribute("type", "create");
        	  cs=new Customerserve();
        	  cs.setStatu("新创建");
        	  cs.setCtime(new Date());
        	  request.setAttribute("cs", cs);
        	  session.setAttribute("tips", cs.getStatu());
        	  ///测试用
        	  Manager manager=managerService.findByLogin("cr", "123");
        	  session.setAttribute("loginer", manager);
        	  return "initCreate";
          }
          
          /**
           * 新建或更新服务信息
           * @return
           */
          public String addOrUpdate() {
        	  String tips= session.getAttribute("tips")+"";
        	  Customerserve newCS;
        	  Manager manager;
        	switch (tips) {
			case "新创建":
				cs.setCtime(new Date());
				customerserveService.addCS(cs);
				return "divid";
			case "已分配":
				newCS=customerserveService.findByCSId(cs.getId());
				newCS.setDeal(cs.getDeal());
				newCS.setDealtime(new Date());
				newCS.setStatu("已处理");
				manager=(Manager) session.getAttribute("loginer");
				newCS.setDealman(manager);
				customerserveService.updateCS(newCS);
				return "deal";
			case "已处理":
				newCS=customerserveService.findByCSId(cs.getId());
				if (cs.getCsi().getId()>=16) {
					newCS.setStatu("已归档");
					newCS.setResult(cs.getResult());
					newCS.setCsi(cs.getCsi());
				}else {
					newCS.setStatu("已分配");
				}			
				customerserveService.updateCS(newCS);
				return "result";
			}
			return null;
          }
          /**
           * 分配客户服务
           * @return
           */
          public String divid() {
        	  Customerserve newCS=customerserveService.findByCSId(cs.getId());
              Manager manager=managerService.findByDividId(cs.getManager().getId());
              newCS.setManager(manager);
              newCS.setDtime(new Date());
              newCS.setStatu("已分配");
              customerserveService.updateCS(newCS);
        	  return "divid";
          }
          
          /**
           * 显示待分配的服务
           * @return
           */
          public String showDivid() {
        	  List<Customerserve> csList=customerserveService.findDivids();
        	  request.setAttribute("csList", csList);
        	  List<Manager> mList=managerService.findAllManager();
        	  request.setAttribute("mList", mList);
        	  return "showDivid";
          }
          
          /**
           * 显示待处理的服务
           * @return
           */
          public String showDeal() {
        	  List<Customerserve> csList=customerserveService.findList("已分配");
        	  request.setAttribute("csList", csList);
        	  request.setAttribute("msg", "处理");
        	  return "List";
          }
          /**
           * 显示待反馈的服务
           * @return
           */
          public String showResult() {
        	  List<Customerserve> csList=customerserveService.findList("已处理");
        	  request.setAttribute("csList", csList);
        	  request.setAttribute("msg", "反馈");
        	  return "List";
          }
          
          /**
           * 显示已归档的服务
           * @return
           */
          public String showPerfact() {
        	  List<Customerserve> csList=customerserveService.findList("已归档");
        	  request.setAttribute("csList", csList);
        	  request.setAttribute("msg", "归档");
        	  return "List";
          }
          
          /**
           * 根据编号初始化相应服务数据
           * @return
           */
          public String initCS() {
        	  Customerserve customerserve=customerserveService.findByCSId(cs.getId());
        	  request.setAttribute("cs", customerserve);
        	  if (customerserve.getStatu().equals("已处理")) {
        		  List<Datadictionary> ddList=datadictionaryService.findByTypes("满意度");
            	  request.setAttribute("satisfactions", ddList);
			  }
        	  request.setAttribute("time", new Date().toString());
        	  session.setAttribute("tips", customerserve.getStatu());
        	///测试用
        	  Manager manager=managerService.findByLogin("cr", "123");
        	  session.setAttribute("loginer", manager);
        	  return "success";
          }
          
          
          
          
          
          
          
          
          
          
   
          
          
          
          
          
		@Override
		public void setServletRequest(HttpServletRequest request) {
			this.request=request;
			this.session=request.getSession();
		}
		public Customerserve getCs() {
			return cs;
		}
		public void setCs(Customerserve cs) {
			this.cs = cs;
		}

}
