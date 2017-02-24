/**
 * @author HoiNT
 *
 */
package JavaCore;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaCore{
	// Chương 3 : Viết code java 
	@Test // method này đặt trước method muốn thực hiện test
	public void twoAdd(){ // method void được định nghĩ khi không cần return kết quả 
		int answer = 2+2;
		assertEquals ("2+2=4",4,answer);
		
		/** giá trị kiểu int : -2,147,483,648 -> 2,147,483,647
		 * Các toán tử trong Java : +,-,*,/
		 * trong method @Test dùng assert để đảm bảo code failure đúng, assert chỉ định loại check sau 
		 * - nếu check fails thì assert sẽ throws ra assertion error và method sẽ fail
		 * - Nếu check pass thì không làm gì nữa 
		 * assertEquals(object,object) là method đa hình ( có nghĩa là có thể dùng với các loại paramter khác nhau)
		 */
	}
    
	// ------ CHƯƠNG 4: Làm việc với các Classes khác------------------
	@Test
	/** dùng primitive type ( gốc, nguyên bản) 
	 * vd: khai báo biến Integer có thể access vào các method sau
	 * - compareTo : so sánh với integer khác 
	 * - intValue : return về int primitive 
	 * - longValue : return về long primitive 
	 * - shortValue : return về short primitive
	 */
	public void intToInt(){ // So sánh/convert kiểu Integer với int 
		Integer four = new Integer(4);
		assertEquals(4,four.intValue()); // intValue sẽ return về đúng kiểu int	4
		/** Vì Integer là 1 class nên khởi tạo gọi đến 1 class và biến là 1 object variable 
		 * int : là 1 primitive type 
		 * Integer : là 1 class
		 * Sử dụng 1 class để khởi tạo new class -> khởi tạo new này refer tới 1 object hoặc 1 class khởi tạo
		 * Integer class có nhiều hơn 1 contructor
		 */
		/** 1 Constructor là gì ? ( hàm tạo, khối lệnh )
		 * Là 1 method trong 1 class cái mà được gọi khi khởi tạo 1 new của class
		 * 1 Constructor có thể chứa paramters nhưng không bao giờ return gía trị và khai báo ngoài kiểu return 
		 * eg : public Integer(int value){...}
		 * 1 Constructor có tên giống với tên class bắt đầu với chữ in hoa
		 */
	}
	@Test
	public void intToString(){	// So sánh/convert 1 Integer với 1 String
		Integer five = new Integer("5");
		assertEquals(5,five.intValue());
		/** Notes:
		 * - Integer class, String class đã build sẵn trong Language nên chỉ cần dùng nó không cần import vào nữa.
		 */
	}
	@Test
	public void autoBoxing(){//dùng để tự động convert 1 primitive type thành Class tự động liên kết:
		Integer six = 6;
		assertEquals(6,six.intValue());
		/**
		 * (Primitive type)	 (Wrapper class)
			boolean	          Boolean
			byte			  Byte
			char			  Character
			float			  Float
			int			 	  Integer
			long			  Long
			short		  	  Short
			double	          Double

		 */
	}
	@Test
	public void intStatic(){	// Static method trong Integer class
		/** 1 Static method hoạt động ở mức Class chứ không phải ở mức thực thể ( instance) hay đối tượng ( object)
		 * Điều đó có nghĩa là không cần khởi tạo 1 biến vào class để gọi 1 static method
		 * eg: Integer cung cấp static method :
		 *     - Integer.valueOf(String s): return 1 Integer with giá trị là String
		 *     - Integer.parseInt(String s): return 1 Integer with giá trị là String
		 */
		Integer eight = new Integer(9);
		String str = "9";
		assertEquals(eight,Integer.valueOf(str));
	}
	@Test
	public void intToHex(){ // Convert kiểu int sang Hex
		assertEquals("a",Integer.toHexString(10));
		/** check lại mã hexa
		 * that 11 becomes b 
		 * that 10 becomes a 
		 * that 3 becomes 3 
		 * that 21 becomes 15
		 */
	}
	@Test
	public void intConstants(){// Public Constants ( hằng số public) trong Integer class
		/** Có thể tạo 1 biến (field) static trong class. Các field này có sẵn mà không cần tạo đối tượng trong class.
		 * 1 Integer class sẽ show ra vài điểm quan trong như là MIN_VALUE, MAX_VALUE.
		 *Không thể thay đổi hằng số khi đã là static field. 
		 *Tên của hằng số chỉ bao gồm các chữ hoa và các từ cách nhau dấu "_"
		 *Để truy cập tới 1 constant, ko cần thêm dấu () bới vì đang access là 1 biến chứ không phải call 1 method
		 *ex: true--> "Integer.MAX_VALUE", false--> "Integer.MAX_VALUE()"
		 */
		Integer max = 2147483647;
		assertEquals(Integer.MAX_VALUE,max.intValue());
	}
    /**Các chú ý về Integer
     * - Khởi tạo new integer(0)
     * - Các so sánh giữa số Integer hoặc Objects sẽ không luôn bằng nhau 
     * eg : ví dụ so sánh sau đây thì như nhau trong @Test 
     *      assertEquals(4,4) ~ assertTrue(4==4) => kết quả pass 
     *      lý do: với giá trị nguyên bản thì không có sự khác nhau giữa object value và object identify (định danh)
     * Tuy nhiên nếu vd sau thì không thể bằng nhau
     *     Integer firstFour = new Integer (4);
     *     Integer secondFour = new Integer (4);
     *     assertEquals(firstFour,secondFour); => trả kết quả pass 
     *     assertTrue(firstFour == secondFour); => trả kết quả fail 
     *     Lý do : do dùng Object nên khi khởi tạo 2 object khác nhau thì sẽ refer sang 2 object khác nhau.
     *     vì thé không thể so sánh bằng 2 giá trị ( mặc dù giống nhau).
     *     Khi thực hiện assertEquals thì JUnit sử dụng method Equals trong Object để so sánh giá trị của Object.
     *     Nhưng khi thực hiện toán tử "==" thì Java sẽ kiểm tra 2 biến Object độc lập với nhau. 
     *     Để chạy được cần thực hiện*
     *     assertTrue(firstFour.Equals(secondFour)); => trả về két quả pass     
     */
	/** Tóm lại Chương 4
	 * - Có thể tạo 1 object trong class với từ khoá new
	 * - Có thể sử dụng method non-static trong class như : .intValue()..
	 * - Có thể truy cập method static trong class mà không khở tạo class như là 1 object , vd: Integer.equals() 
	 * 
	 */
	
	//-------------CHƯƠNG 5: Làm việc với chính Class -----------------
	// 23/02/2017, HoiNT
	@Test
	public void lichphim(){
		//System.setProperty("FirefoxDriver.firefox.driver", "/Applications/Firefox.app/Contents/MacOS/firefox");
		System.setProperty("webdriver.gecko.driver", "/Users/ait/Downloads/geckodriver");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://lichphim.vn");
		//assertEquals("Lịch Phim | Thế giới giải trí trong tầm tay | Lich phim, phim chieu rap, gia ve, phim chiếu rạp, giá vé",driver.getTitle());
		//driver.close();
		
		/** note call firefox từ version selenium 3.0 
		 * Phải dùng qua remote chứ ko call trực tiếp path của url firefox -> dùng gọi qua geckodriver
       */
		
	}
}