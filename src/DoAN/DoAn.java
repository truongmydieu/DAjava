package DoAN;

import java.util.Iterator;
import java.util.Scanner;

public class DoAn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = NhapSoLuong();
//		String[] tensanpham = new String[n];
//		String[] donvitinh = new String[n];
//		double[] soluong = new double[n];
//		double[] giaban = new double[n];
//		double[] thanhtien = new double[n];
//		NhapSanPham(tensanpham, donvitinh, soluong, giaban, thanhtien);
//		thanhtien = tinhThanhTien(soluong, giaban);
//		xuatsanpham(tensanpham, donvitinh, soluong, giaban, thanhtien);
//		sapxep1(tensanpham, donvitinh, soluong, giaban, thanhtien);
//		xuatsanpham(tensanpham, donvitinh, soluong, giaban, thanhtien);
//		sapxep2(tensanpham, donvitinh, soluong, giaban, thanhtien);
//		xuatsanpham(tensanpham, donvitinh, soluong, giaban, thanhtien);
//		timkiem(tensanpham, donvitinh, soluong, giaban, thanhtien);
		int n = NhapSoLuong();
		String[] tensanpham = new String[n];
		String[] donvitinh = new String[n];
		double[] soluong = new double[n];
		double[] giaban = new double[n];
		double[] thanhtien = new double[n];
		char key;
		do {
			inMenu();
			Scanner sc = new Scanner(System.in);
			System.out.print("Ban chon chuc nang nao: ");
			key = sc.next().charAt(0);
			switch(key) {
			case '1': 
				NhapSanPham(tensanpham, donvitinh, soluong, giaban, thanhtien);
				break;
			case '2':
				thanhtien = tinhThanhTien(soluong, giaban);
				xuatsanpham(tensanpham, donvitinh, soluong, giaban, thanhtien);
				break;
			case '3':
				sapxep1(tensanpham, donvitinh, soluong, giaban, thanhtien);
				xuatsanpham(tensanpham, donvitinh, soluong, giaban, thanhtien);
				break;
			case '4':
				sapxep2(tensanpham, donvitinh, soluong, giaban, thanhtien);
				xuatsanpham(tensanpham, donvitinh, soluong, giaban, thanhtien);
				break;
			case '5':
				timkiem(tensanpham, donvitinh, soluong, giaban, thanhtien);
				break;
			case 'Q':
				break;
			case 'q':
				break;
			}
		}while(key != 'Q' || key == 'q');
	}

	public static void inMenu() {
		System.out.println("*******************************");
		System.out.println("(1): Nhap du lieu san pham");
		System.out.println("(2): In danh sach san pham");
		System.out.println("(3): Sap xep danh sach san pham giam gian cua 'thanh tien'");
		System.out.println("(4): Sap xep danh sach san pham tang dan cua 'gia ban'");
		System.out.println("(5): Tim kiem theo ten san pham");
		System.out.println("(Q/q): Thoa khoi chuong trinh");
		System.out.println("********************************");
	}

	public static int NhapSoLuong() {
		try {
			int n;
			Scanner sc = new Scanner(System.in);
			do {
				System.out.print("Nhap so luong san pham n = ");
				n = sc.nextInt();
			} while (n <= 0);
			return n;
		} catch (Exception e) {
			System.out.println("DA XAY RA LOI TRONG QUA TRINH NHAP DU LIEU");
			return -1;
		}
	}

	public static void NhapSanPham(String[] tensanpham, String[] donvitinh, double[] soluong, double[] giaban,
			double[] thanhtien) {
		System.out.println("*************************************************************");
		try {
			for (int i = 0; i < tensanpham.length; i++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Nhap du lieu cho sinh vien thu " + (i + 1));
				System.out.print("Ten San Pham: ");
				tensanpham[i] = sc.nextLine();
				System.out.print("Don vi tinh: ");
				donvitinh[i] = sc.nextLine();
				System.out.print("So luong: ");
				soluong[i] = sc.nextDouble();
				System.out.print("Gia Ban: ");
				giaban[i] = sc.nextDouble();
			}
		} catch (Exception e) {
			System.out.println("DA XAY RA LOI TRONG QUA TRINH NHAP DU LIEU");
		}
		System.out.println("*************************************************************");
	}

	public static void xuatsanpham(String[] tensanpham, String[] donvitinh, double[] soluong, double[] giaban,
			double[] thanhtien) {
		System.out.println("*************************************************************");
		System.out.println("\t\t\t Danh Sach San Pham");
		for (int i = 0; i < tensanpham.length; i++) {
			System.out.println(tensanpham[i] + "; Don vi tinh: " + donvitinh[i] + "; So Luong: " + soluong[i]
					+ "; Gia Ban: " + giaban[i] + "; Thanh Tien: " + thanhtien[i]);
		}
		System.out.println("*************************************************************");
	}

	public static double[] tinhThanhTien(double[] soluong, double[] giaban) {
		double[] tinhthanhtien = new double[soluong.length];
		for (int i = 0; i < tinhthanhtien.length; i++) {
			tinhthanhtien[i] = giaban[i] * soluong[i];
		}
		return tinhthanhtien;
	}

	// Sap xep giam dan cua thanh tien
	public static void sapxep1(String[] tensanpham, String[] donvitinh, double[] soluong, double[] giaban,
			double[] thanhtien) {
		for (int i = 0; i < thanhtien.length - 1; i++) {
			for (int j = i + 1; j < thanhtien.length; j++) {
				if (thanhtien[i] < thanhtien[j]) {
					String tam = tensanpham[i];
					tensanpham[i] = tensanpham[j];
					tensanpham[j] = tam;
					String tam2 = donvitinh[i];
					donvitinh[i] = donvitinh[j];
					donvitinh[j] = tam2;
					double tam3 = soluong[i];
					soluong[i] = soluong[j];
					soluong[j] = tam3;
					double tam4 = giaban[i];
					giaban[i] = giaban[j];
					giaban[j] = tam4;
					double tam5 = thanhtien[i];
					thanhtien[i] = thanhtien[j];
					thanhtien[j] = tam5;
				}
			}
		}
	}

	// Sap xep giam dan cua gia ban
	public static void sapxep2(String[] tensanpham, String[] donvitinh, double[] soluong, double[] giaban,
			double[] thanhtien) {
		for (int i = 0; i < giaban.length - 1; i++) {
			for (int j = i + 1; j < giaban.length; j++) {
				if (giaban[i] > giaban[j]) {
					String tam = tensanpham[i];
					tensanpham[i] = tensanpham[j];
					tensanpham[j] = tam;
					String tam2 = donvitinh[i];
					donvitinh[i] = donvitinh[j];
					donvitinh[j] = tam2;
					double tam3 = soluong[i];
					soluong[i] = soluong[j];
					soluong[j] = tam3;
					double tam4 = giaban[i];
					giaban[i] = giaban[j];
					giaban[j] = tam4;
					double tam5 = thanhtien[i];
					thanhtien[i] = thanhtien[j];
					thanhtien[j] = tam5;
				}
			}
		}
	}

	public static void timkiem(String[] tensanpham, String[] donvitinh, double[] soluong, double[] giaban,
			double[] thanhtien) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		String tencantim;
		try {
			System.out.print("Ten can tim: ");
			tencantim = sc.next();
			for (int i = 0; i < tensanpham.length; i++) {
				if (tensanpham[i].equals(tencantim)) {
					System.out.println(tensanpham[i] + "; Don vi tinh: " + donvitinh[i] + "; So Luong: " + soluong[i]
							+ "; Gia Ban: " + giaban[i] + "; Thanh Tien: " + thanhtien[i]);
					count = count + 1;
				}
			}
			if (count == 0) {
				System.out.println("KHONG TIM THAY");
			}
		} catch (Exception e) {
			System.out.println("DA XAY RA LOI TRONG QUA TRINH NHAP DU LIEU");
		}
	}
}
