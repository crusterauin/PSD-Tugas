import java.util.Scanner;

class Challenge {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        int pilihan;
        char ulang;
        int i = 0;

        Student[] arr;
        arr = new Student[9];

        do {
            System.out.println("# Selamat datang di Program Pendataan Mahasiswa #");
            System.out.println("# --------oleh Faturrohman Fairuz Zaki-------- #");
            System.out.println("=================================================");
            System.out.println("1. INPUT DATA");
            System.out.println("2. TAMPIL DATA");
            System.out.println("3. EXIT");
            System.out.println();

            System.out.print("Pilihan Anda : ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    if (i == 9) {
                        System.out.println("Kelas sudah penuh!");
                    } else {
                        System.out.print("Masukkan NIM : ");
                        long nim = input.nextLong();
                        boolean nimExist = false;
                        for (int j = 0; j < i; j++) {
                            if (arr[j] != null && arr[j].nim == nim) {
                                nimExist = true;
                                break;
                            }
                        }
                        if (nimExist) {
                            System.out.println("NIM sudah ada dalam database.");
                        } else {
                            System.out.print("Masukkan Nama : ");
                            input.nextLine();
                            String nama = input.nextLine();
                            System.out.print("Masukkan Umur : ");
                            int umur = input.nextInt();
                            System.out.print("Masukkan Jumlah Saudara : ");
                            int jmlSaudara = input.nextInt();

                            arr[i] = new Student(nim, nama, umur, jmlSaudara);
                            i++;
                            System.out.println("Data berhasil tersimpan!");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Data Mahasiswa:");
                    System.out.println("-------------------------------------------------");
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] != null) {
                            System.out.println("NIM \t\t :" + arr[j].nim);
                            System.out.println("Nama \t\t :" + arr[j].nama);
                            System.out.println("Umur \t\t :" + arr[j].umur);
                            System.out.println("Jumlah Saudara \t :" + arr[j].jmlSaudara);
                            System.out.println("-------------------------------------------------");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu tidak tersedia");
            }

            System.out.println();

            System.out.print("Ingin memilih menu lain (y/t)");
            ulang = input.next().charAt(0);

            System.out.println();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } while (ulang != 't');

        System.out.println("Terima kasih");
        input.close();
    }
}

class Student {

    public long nim;
    public String nama;
    public int umur;
    public int jmlSaudara;

    Student(long nim, String nama, int umur, int jmlSaudara) {
        this.nim = nim;
        this.nama = nama;
        this.umur = umur;
        this.jmlSaudara = jmlSaudara;
    }
}