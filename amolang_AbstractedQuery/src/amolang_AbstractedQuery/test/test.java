package amolang_AbstractedQuery.test;
	
	import java.sql.Timestamp;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	
public class test {
	 
	    /**
	     * �ڹٿ��� Ÿ�ӽ����� �����
	     * @param args
	     */
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	         
	        Calendar oCalendar = Calendar.getInstance( );  // ���� ��¥/�ð� ���� ���� ���� ���
	        System.out.println("���� ��: " +  oCalendar.get(Calendar.YEAR));
	        System.out.println("���� ��: " + (oCalendar.get(Calendar.MONTH) + 1));
	        System.out.println("���� ��: " +  oCalendar.get(Calendar.DAY_OF_MONTH));
	        System.out.println(); // �����ٷ� �థ�� �ϱ�
	 
	        System.out.println("���� ��: " +  oCalendar.get(Calendar.HOUR_OF_DAY)); // 24�ð���
	        System.out.println("���� ��: " +  oCalendar.get(Calendar.MINUTE));
	        System.out.println("���� ��: " +  oCalendar.get(Calendar.SECOND));
	        System.out.println();
	 
	        // 12�ð����� ���� ��
	        System.out.print("���� ��: " +  oCalendar.get(Calendar.HOUR));
	        if (oCalendar.get(Calendar.AM_PM) == 0) System.out.println("am");
	        else System.out.println("pm");
	 
	        System.out.println("���� ���� 1000����1��: " +  oCalendar.get(Calendar.MILLISECOND));
	        System.out.println("���� ����: " +  oCalendar.get(Calendar.DAY_OF_WEEK)); // �Ͽ��� = 1
	        System.out.println("���� �� ��° ��: " + oCalendar.get(Calendar.DAY_OF_YEAR)); // 1�� 1�� = 1
	        System.out.println("���� �� ��° ��: " + oCalendar.get(Calendar.WEEK_OF_YEAR)); // 1�� 1���� = 1
	        System.out.println("�̹� ���� �� ��° ��: " + oCalendar.get(Calendar.WEEK_OF_MONTH)); // ù° �� = 1
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


