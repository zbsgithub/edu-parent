package com.gzdata.core.dto;

import java.io.Serializable;

public class Quarter implements Serializable{

	    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5276142477259753773L;
		private String name;
	    private String value;
	    private String year;
	    private String remark;
	 
	    public Quarter(String name, String value,String year,String remark) {
	        this.name = name;
	        this.value = value;
	        this.year = year;
	        this.remark= remark;
	    }
	 
	    @Override
		public String toString() {
			return "Quarter [name=" + name + ", value=" + value + ", year="
					+ year + ", remark=" + remark + "]";
		}

		/**
	     * 如果对象类型是User,先比较hashcode，一致的场合再比较每个属性的值
	     */
	    @Override
	    public boolean equals(Object obj) {
	        if (obj == null)
	            return false;
	        if (this == obj)
	            return true;
	        if (obj instanceof Quarter) {
	        	Quarter vo = (Quarter) obj;
	 
	            // 比较每个属性的值一致时才返回true
	            if (vo.name.equals(this.name) && vo.value.equals(this.value) 
	            		&& vo.year.equals(this.year) && vo.remark.equals(this.remark))
	                return true;
	        }
	        return false;
	    }
	 
	    /**
	     * 重写hashcode方法，返回的hashCode一样才再去比较每个属性的值
	     */
	    @Override
	    public int hashCode() {
	        return name.hashCode() * value.hashCode() * year.hashCode() * remark.hashCode();
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}
	    
}
