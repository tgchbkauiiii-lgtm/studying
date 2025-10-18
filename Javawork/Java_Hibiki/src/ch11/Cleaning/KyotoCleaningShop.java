package ch11.Cleaning;

public class KyotoCleaningShop implements CleaningService {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	String ownerName;
	String address;
	String phone;
	
	public Shirt washShirt(Shirt s) {
		s(s.customerName + "様の" + s.color + "色の" + s.size + "サイズのシャツを大型洗濯機で15分洗った");
		return s;
	}
	public Towel washTowel(Towel t) {
		s(t.customerName + "様の" + t.color + "色の" + t.type + "タオルを大型洗濯機で10分洗った");
		return t;
	}
	public Coat washCoat(Coat c) {
		s(c.customerName + "様の" + c.color + "色の" + c.type + "コートを大型洗濯機で20分乾燥した");
		return c;
	}
}
