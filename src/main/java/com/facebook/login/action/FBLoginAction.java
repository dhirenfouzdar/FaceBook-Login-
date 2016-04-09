package com.facebook.login.action;
import java.util.HashMap;
import java.util.Map;

import com.facebook.login.action.FBConnection;
import com.facebook.login.action.FBGraph;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


@SuppressWarnings("unused")
public class FBLoginAction {
	public static final long serialVersionUID=1L;
	private String code="";
	Map<String, Object> map = new HashMap<String, Object>();
	public String execute(){
		
		try{
			
			ServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response= ServletActionContext.getResponse();
		
		code=request.getParameter("code");
				System.out.println("===code=" + code);
		if (code == null || code.equals("")) {
			throw new RuntimeException(
					"ERROR: Didn't get code parameter in callback.");
		}
		FBConnection fbCon = new FBConnection();
		String accessToken = fbCon.getAccessToken(code);
		FBGraph fbGraph = new FBGraph(accessToken);
	
		String graph = fbGraph.getFBGraph();
		ObjectMapper mapper = new ObjectMapper();
		//Map<String, Object> map = new HashMap<String, Object>();

	
		// convert JSON string to Map
		map = mapper.readValue(graph, new TypeReference<Map<String, String>>(){});
		System.out.println("==graph==="+ graph);
		System.out.println("==map==="+ map);
		System.out.println("name = "+map.get("name"));
		System.out.println("email==="+map.get("email"));
		System.out.println("id ==="+map.get("id"));
		map.put("name",map.get("name"));
		map.put("email",map.get("email"));
		map.put("id",map.get("id"));

		//request.setAttribute("mapdata",map);
		
		System.out.println("=====graph data = "+ graph);
		
		return "success";
		}catch(Exception e){
			return "error";
		}
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map=map;
	}
}
	

