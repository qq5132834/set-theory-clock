package com.paic.arch.interviews;

/**
* @author owenhuang
* @description TimeConverterImpl
* @version 创建时间：2018年2月27日 下午3:47:54
*/
public class MyTimeConverter implements TimeConverter{
	
	private final static String SUFFIX = "\r\n";
	
//	public static void main(String[] args) {
//		new TimeConverterImpl().convertTime("24:00:00");
//	}

	@Override
	public String convertTime(String aTime) {

		StringBuilder sb = new StringBuilder();
		
		//将时间拆分 小时，分钟，秒数，的数组，以便逐个转换
		String[] timeSplit = aTime.split(":"); 
		
		String sec = this.convertSec(timeSplit[2]);
		sb.append(sec);
		
		String hour = this.convertHour(timeSplit[0]);
		sb.append(hour);
		
		String min = this.convertMin(timeSplit[1]);
		sb.append(min);
		
		System.out.println(sb.toString());
		
		return sb.toString();
	}

	/**
	 * 小时转换
	 * */
	private String convertHour(String hour){
		
		String strHour = "";
		
		int iHour = Integer.parseInt(hour);
		int divi = iHour/5; //被5小时整除数
		int remainder = iHour%5; //取余数
		
		//处理小时第一排
		for (int i=0; i<divi ; i++) {
			strHour = strHour + "R";
		}
		for (int i = divi; i < 4; i++) {
			strHour = strHour + "O";
		}
		strHour = strHour + SUFFIX;
		
		//处理小时第二排
		for (int i=0; i<remainder ; i++) {
			strHour = strHour + "R";
		}
		for (int i = remainder; i < 4; i++) {
			strHour = strHour + "O";
		}
		strHour = strHour + SUFFIX;
		
		return strHour;
	}
	
	/**
	 * 分钟转换
	 * */
	private String convertMin(String min){
		
		int iMin = Integer.parseInt(min);
		int divi = iMin/5; //被5整除数
		int remainder = iMin%5; //取余数
		
		String strMin = "";
		
		//处理分钟第一排
		for (int i=0; i<divi ; i++) {
			if(i==2 || i==5 || i==8){
				strMin = strMin + "R";
			}
			else{
				strMin = strMin + "Y";
			}
		}
		for (int i = divi; i < 11; i++) {
			strMin = strMin + "O";
		}
		strMin = strMin + SUFFIX;
		
		//处理分钟第二排
		for (int i=0; i<remainder ; i++) {
			strMin = strMin + "Y";
		}
		for (int i = remainder; i < 4; i++) {
			strMin = strMin + "O";
		}
		
		return strMin;
	}
	
	/**
	 * 秒转换，偶数返回“Y”，奇数返回“O”
	 * */
	private String convertSec(String sec){
		
		int isec = Integer.parseInt(sec);
		if((isec%2)==0){
			return "Y"+SUFFIX;
		}else{
			return "O"+SUFFIX;
		}
		
	}
	
}
