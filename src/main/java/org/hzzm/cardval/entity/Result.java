/**
 * 
 */
package org.hzzm.cardval.entity;

/** 
 * @Description: 返回结果集对象
 * @author Renne66
 * @email 465119455@qq.com
 * @date 2016年4月23日 
*/
public class Result {
	private String code;
	private String desc;
	private int money;
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Result(String code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}
	public Result(String code, String desc,int money) {
		super();
		this.code = code;
		this.desc = desc;
		this.money = money;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
