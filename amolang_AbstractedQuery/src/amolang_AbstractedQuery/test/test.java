package amolang_AbstractedQuery.test;
	
	import java.sql.Timestamp;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	
public class test {
	 
	    /**
	     * 자바에서 타임스템프 사용방법
	     * @param args
	     */
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	         
	        Calendar oCalendar = Calendar.getInstance( );  // 현재 날짜/시간 등의 각종 정보 얻기
	        System.out.println("현재 년: " +  oCalendar.get(Calendar.YEAR));
	        System.out.println("현재 월: " + (oCalendar.get(Calendar.MONTH) + 1));
	        System.out.println("현재 일: " +  oCalendar.get(Calendar.DAY_OF_MONTH));
	        System.out.println(); // 다음줄로 행갈이 하기
	 
	        System.out.println("현재 시: " +  oCalendar.get(Calendar.HOUR_OF_DAY)); // 24시간제
	        System.out.println("현재 분: " +  oCalendar.get(Calendar.MINUTE));
	        System.out.println("현재 초: " +  oCalendar.get(Calendar.SECOND));
	        System.out.println();
	 
	        // 12시간제로 현재 시
	        System.out.print("현재 시: " +  oCalendar.get(Calendar.HOUR));
	        if (oCalendar.get(Calendar.AM_PM) == 0) System.out.println("am");
	        else System.out.println("pm");
	 
	        System.out.println("현재 초의 1000분의1초: " +  oCalendar.get(Calendar.MILLISECOND));
	        System.out.println("현재 요일: " +  oCalendar.get(Calendar.DAY_OF_WEEK)); // 일요일 = 1
	        System.out.println("올해 몇 번째 날: " + oCalendar.get(Calendar.DAY_OF_YEAR)); // 1월 1일 = 1
	        System.out.println("올해 몇 번째 주: " + oCalendar.get(Calendar.WEEK_OF_YEAR)); // 1월 1일은 = 1
	        System.out.println("이번 달의 몇 번째 주: " + oCalendar.get(Calendar.WEEK_OF_MONTH)); // 첫째 주 = 1
	        String tempStr = String.format("%04d%02d%02d%02d%02d%02d",                  
	                    oCalendar.get(Calendar.YEAR),
	                    (oCalendar.get(Calendar.MONTH) + 1),
	                    oCalendar.get(Calendar.DAY_OF_MONTH),
	                    oCalendar.get(Calendar.HOUR_OF_DAY),
	                    oCalendar.get(Calendar.MINUTE),
	                    oCalendar.get(Calendar.SECOND)
	        );      
	         
	        System.out.println(tempStr);
	 
	        Calendar cal;       
	        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");       
	        String date = new String("20061225130115");
	        try {
	            sd.parse(date);
	            cal = sd.getCalendar();
	             
	            Timestamp time = new Timestamp( cal.getTime().getTime() );
	            System.out.println(time.getTime() / 1000);          
	            System.out.println(time);
	             
	        } catch (ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	 
	    }
	 
	}


