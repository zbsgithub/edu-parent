package com.gzdata.core.model;


                                                                



/**
 * 
 * 说明： 街道详细数据 值对象类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public class Street  {


 							private Integer id; //pk


 							private String streetName; //街道


 							private String region; //区域


 							private String city; //城市


 							private String province; //省份




/** 以下为get,set方法 */
   		 						
        	
        	 public Integer getId() {
		        return this.id;
	        }
	        public void setId(Integer id) {
	        	this.id = id;
	        }
	

   		 						
        	
        	 public String getStreetName() {
		        return this.streetName;
	        }
	        public void setStreetName(String streetName) {
	        	this.streetName = streetName;
	        }
	

   		 						
        	
        	 public String getRegion() {
		        return this.region;
	        }
	        public void setRegion(String region) {
	        	this.region = region;
	        }
	

   		 						
        	
        	 public String getCity() {
		        return this.city;
	        }
	        public void setCity(String city) {
	        	this.city = city;
	        }
	

   		 						
        	
        	 public String getProvince() {
		        return this.province;
	        }
	        public void setProvince(String province) {
	        	this.province = province;
	        }
	





}
