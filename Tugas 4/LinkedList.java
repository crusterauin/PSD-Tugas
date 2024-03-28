import java.util.Scanner;
import java.util.InputMismatchException;

class Node {
    long nim;
    String nama;
    int umur;
    int jmlSaudara;
    Node next;

    Node(long nim, String nama, int umur, int jmlSaudara) {
        this.nim = nim;
        this.nama = nama;
        this.umur = umur;
        this.jmlSaudara = jmlSaudara;
        this.next = null;
    }
}

class LinkedList {

    Node head;

    public int getSize() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public static LinkedList insert(LinkedList list, long nim, String nama, int umur, int jmlSaudara) {
        final int maxSize = 10;

        Node new_node = new Node(nim, nama, umur, jmlSaudara);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            if (list.getSize() == maxSize) {
                System.out.println("Linked list telah mencapai batas maksimum.");
                return list;
            } else {
                last.next = new_node;
                System.out.println("Data berhasil dimasukkan!");
            }
        }

        return list;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println("NIM \t\t :" + current.nim);
            System.out.println("Nama \t\t :" + current.nama);
            System.out.println("Umur \t\t :" + current.umur);
            System.out.println("Jumlah Saudara \t :" + current.jmlSaudara);
            System.out.println("-------------------------------------------------");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner input = new Scanner(System.in);
        int pilihan;
        char ulang;

        do {
            System.out.println("# Selamat datang di Program Pendataan Mahasiswa #");
            System.out.println("# --------oleh Faturrohman Fairuz Zaki-------- #");
            System.out.println("=================================================");
            System.out.println("1. INPUT DATA");
            System.out.println("2. TAMPIL DATA");
            System.out.println("3. EXIT");
            System.out.println();

            System.out.print("Pilihan Anda : ");
            try {
                pilihan = input.nextInt();
                switch (pilihan) {
                    case 1:
                        System.out.println("Masukkan NIM Mahasiswa: ");
                        long nim = input.nextLong();
                        input.nextLine(); // Membersihkan buffer
                        System.out.println("Masukkan Nama Mahasiswa: ");
                        String nama = input.nextLine();
                        System.out.println("Masukkan Umur Mahasiswa: ");
                        int umur = input.nextInt();
                        System.out.println("Masukkan Jumlah Saudara Mahasiswa: ");
                        int jmlSaudara = input.nextInt();
                        list = insert(list, nim, nama, umur, jmlSaudara);
                        break;
                    case 2:
                        System.out.println("Data Mahasiswa:");
                        System.out.println("-------------------------------------------------");
                        list.display();
                        break;
                    case 3:
                        System.out.println("Terima kasih");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Menu tidak tersedia");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka untuk pilihan.");
                input.nextLine();
                pilihan = 0;
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