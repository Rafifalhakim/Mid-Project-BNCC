import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Vector<PTMusang> vMusang = new Vector<>();	
	
	public Main() {
		menu();
	}
	
	int choice=0;
	void menu() {
		do {
			System.out.println("       PT Musang       ");
			System.out.println("=======================");
			System.out.println("1. Insert data Karyawan");
			System.out.println("2. View data Karyawan");
			System.out.println("3. Update data Karyawan");
			System.out.println("4. Delete data Karyawan");
			System.out.println("5. Keluar");
			
			do {
				System.out.print("Choose [1-5]: ");
					try {
						choice = scan.nextInt();
					} catch (Exception e) {
						System.out.println("Input must be number!");
					}
				scan.nextLine();
				System.out.println();
			} while (choice<1||choice>5);

			switch (choice) {
			case 1:
				menu1();
				break;
			case 2:
				menu2();
				break;
			case 3:
				menu3();
				break;
			case 4:
				menu4();
				break;
			case 5:
				System.out.println("Thanks for using the program! :D");
				System.exit(0);
				break;
			}
			
		} while (choice!=5);
	}
	
	int inputgaji;
	String inputnama,inputjeniskelamin,inputjabatan;
	void menu1() {
		//kode random karyawan
		koderandom();
		//input nama karyawan
		do {
			System.out.println("Input nama karyawan [>= 3]: ");
			inputnama=scan.nextLine();
		} while (inputnama.length()<3);
		//input jenis kelamin
		do {
			System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			inputjeniskelamin = scan.nextLine();
		} while (inputjeniskelamin.equals("Laki-laki")==false&&inputjeniskelamin.equals("Perempuan")==false);
		
		do {
			System.out.println("Input Jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			inputjabatan = scan.nextLine();
		} while (inputjabatan.equals("Manager")==false&&inputjabatan.equals("Supervisor")==false&&inputjabatan.equals("Admin")==false);
		
		System.out.println("Berhasil menambahkan karyawan dengan id "+finalcode);
		
		if (inputjabatan.equals("Manager")) {
			inputgaji=8000000;
		}
		else if (inputjabatan.equals("Supervisor")) {
			inputgaji=6000000;
		}
		else if (inputjabatan.equals("Admin")) {
			inputgaji=4000000;
		}
		
		PTMusang vnewMusang = new PTMusang();
		vnewMusang.setKodeKaryawan(finalcode);
		vnewMusang.setNamaKaryawan(inputnama);
		vnewMusang.setJenisKelamin(inputjeniskelamin);
		vnewMusang.setJabatan(inputjabatan);
		vnewMusang.setGajiKaryawan(inputgaji);
		vMusang.add(vnewMusang);
		
		String temp1,temp1check="Supervisor";
		int val_i=0,temp2,tempmulti;
		for (int k = 0; k < vMusang.size(); k++) {
			temp1 = vMusang.get(k).getJabatan();
			if (temp1check.equals(temp1)) {
				val_i++;
			}
		}
		
		if (val_i>=2) {
			if (val_i%3==1) {
				for (int l = 0; l < vMusang.size(); l++) {
					temp2 = vMusang.get(l).getGajiKaryawan();
					temp1 = vMusang.get(l).getJabatan();
					if (temp1check.equals(temp1)) {
						vnewMusang.setGajiKaryawan(temp2+temp2/40*3);
						vMusang.set(l, vnewMusang);
					}
				}
				tempmulti= val_i/3;
				System.out.print("Bonus sebesar 7,5% telah diberikan kepada karyawan dengan id ");
				for (int m = 0; m < 3*tempmulti; m++) {
					System.out.print(vMusang.get(m).getKodeKaryawan()+", ");
				}
				System.out.println();
				System.out.println("ENTER to return");
				scan.nextLine();
			}
		}
		
		String temp3,temp2check="Manager";
		int temp4,val_o=0;
		for (int k = 0; k < vMusang.size(); k++) {
			temp3 = vMusang.get(k).getJabatan();
			if (temp2check.equals(temp3)) {
				val_o++;
			}
		}
		if (val_o>=2) {
			if (val_o%3==1) {
				for (int l = 0; l < vMusang.size(); l++) {
					temp4 = vMusang.get(l).getGajiKaryawan();
					temp3 = vMusang.get(l).getJabatan();
					if (temp2check.equals(temp3)) {
						vnewMusang.setGajiKaryawan(temp4+temp4/10);
						vMusang.set(l, vnewMusang);
					}
				}
				tempmulti= val_o/3;
				System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id ");
				for (int m = 0; m < 3*tempmulti; m++) {
					System.out.print(vMusang.get(m).getKodeKaryawan()+", ");
				}
				System.out.println();
				System.out.println("ENTER to return");
				scan.nextLine();
			}
		}
		
		String temp5,temp3check="Admin";
		int temp6,val_p=0;
		for (int k = 0; k < vMusang.size(); k++) {
			temp5 = vMusang.get(k).getJabatan();
			if (temp3check.equals(temp5)) {
				val_p++;
			}
		}
		if (val_p>=2) {
			if (val_p%3==1) {
				for (int l = 0; l < vMusang.size(); l++) {
					temp6 = vMusang.get(l).getGajiKaryawan();
					temp5 = vMusang.get(l).getJabatan();
					if (temp3check.equals(temp5)) {
						vnewMusang.setGajiKaryawan(temp6+temp6/20);
						vMusang.set(l, vnewMusang);
					}
				}
			}
		}
	
		val_i=0;
		val_p=0;
		val_o=0;
		
	}
	
	int tempx,tempy;
	char tempxchar;
	String tempcode,tempcode2,tempychar,finalcode;
	void koderandom() {
		tempx = rand.nextInt(25)+65;
		tempxchar = (char)tempx;
		tempcode = Character.toString(tempxchar);
		tempx = rand.nextInt(25)+65;
		tempxchar = (char)tempx;
		tempcode = tempcode.concat(Character.toString(tempxchar));
		
		tempy = rand.nextInt(9);
		tempychar = Integer.toString(tempy);
		tempcode2 = tempychar;
		for (int j = 0; j < 3; j++) {
			tempy = rand.nextInt(9);
			tempychar = Integer.toString(tempy);
			tempcode2 = tempcode2.concat(tempychar);
		}
		finalcode = tempcode +"-"+ tempcode2;
		tempcode = "";
		tempcode2 = "";
	}
	
	void menu2() {
		if (vMusang.isEmpty()) {
			System.out.println("No data to be shown!");
		}
		else {
			datalist();
		}
	}
	
	String formatheader = "|%-4s|%-17s|%-30s|%-15s|%-14s|%-13s|%n";
	String formatisi = "|%4d|%17s|%30s|%15s|%14s|%13d|%n";
	void datalist() {
		
		System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|%n");
		System.out.printf(formatheader, "No","Kode Karyawan","Nama Karyawan","Jenis Kelamin","Jabatan","Gaji Karyawan");
		System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|%n");

		for (int pp = 0;pp < vMusang.size()-1; pp++) {
			for (int ppp = 0; ppp < vMusang.size()-pp-1; ppp++) {
				int pp1 = Character.getNumericValue(vMusang.get(ppp).getNamaKaryawan().charAt(0));
				int pp2 = Character.getNumericValue(vMusang.get(ppp+1).getNamaKaryawan().charAt(0));
				if (pp1 > pp2) {
					//CODE UTK SWAP
					PTMusang xor = vMusang.get(ppp);
					vMusang.set(ppp, vMusang.get(ppp+1));
					vMusang.set(ppp+1, xor);
				}
			}
		}
		
		for (int n = 0; n < vMusang.size(); n++) {
			System.out.printf(formatisi,(n+1),vMusang.get(n).getKodeKaryawan(), vMusang.get(n).getNamaKaryawan(),vMusang.get(n).getJenisKelamin(),vMusang.get(n).getJabatan(),vMusang.get(n).getGajiKaryawan());
		}
		
		System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|%n");

	}
	
	int inputupdate;
	String inputnamaedit,inputjeniskelaminedit,inputjabatanedit;
	void menu3() {
		datalist();
		do {
			System.out.println("Input nomor urutan karyawan yang ingin diupdate: ");
			try {
				inputupdate =scan.nextInt();
			} catch (Exception e) {
				System.out.println("Input must be number!");
			}
			scan.nextLine();
		} while (inputupdate<1||inputupdate>vMusang.size());
		
		do {
			System.out.println("Input nama karyawan [>= 3]: ");
			inputnamaedit=scan.nextLine();
		} while (inputnamaedit.length()<3);
		
		do {
			System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			inputjeniskelaminedit=scan.nextLine();
		} while (inputjeniskelaminedit.equals("Laki-laki")==false&&inputjeniskelaminedit.equals("Perempuan")==false);
		
		do {
			System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			inputjabatanedit=scan.nextLine();
		} while (inputjabatanedit.equals("Manager")==false&&inputjabatanedit.equals("Supervisor")==false&&inputjabatanedit.equals("Admin")==false);
		
		System.out.println("Berhasil mengupdate karyawan dengan id "+vMusang.get(inputupdate-1).getKodeKaryawan());
		
		int halogaji=0;
		if (inputjabatanedit.equals("Manager")) {
			halogaji = 8000000;
		}
		else if (inputjabatanedit.equals("Supervisor")) {
			halogaji = 6000000;
		}
		else if (inputjabatanedit.equals("Admin")) {
			halogaji = 4000000;
		}
		PTMusang vnewMusang2 = new PTMusang();
		vnewMusang2.setNamaKaryawan(inputnamaedit);
		vnewMusang2.setJabatan(inputjabatanedit);
		vnewMusang2.setJenisKelamin(inputjeniskelaminedit);
		vnewMusang2.setKodeKaryawan(vMusang.get(inputupdate-1).getKodeKaryawan());
		vnewMusang2.setGajiKaryawan(halogaji);
		
		vMusang.set(inputupdate-1, vnewMusang2);
	}
	
	int inputdelete;
	void menu4() {
		datalist();
		do {
			System.out.println("Input nomor urutan karyawan yang ingin dihapus: ");
			try {
				inputdelete = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Input must be number!");
			}
			scan.nextLine();
		} while (inputdelete<1||inputdelete>vMusang.size());
		System.out.println("Karyawan dengan kode "+vMusang.get(inputdelete-1).getKodeKaryawan()+" berhasil dihapus");
		vMusang.remove(inputdelete-1);
		System.out.println("ENTER to return");
		scan.nextLine();
	}
	
	public static void main(String[] args) {
		new Main();
		
	}

}

