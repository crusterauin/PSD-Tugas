import java.util.Scanner;

class QNode {
    int key;
    QNode next;

    public QNode(int key) {
        this.key = key;
        this.next = null;
    }
}

class Queue {
    QNode front, rear;
    int size;

    public Queue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    void enqueue(int key) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        QNode temp = new QNode(key);
        
        if(this.size >= 10) {
            System.out.println("Antrian sudah mencapai batas maksimum.");
            return;
        }

        if (this.rear == null) {
            this.front = this.rear = temp;
            this.size++;
            System.out.println("Antrian dengan nomor " + temp.key + " telah diambil");
            return;
        }
 
        this.rear.next = temp;
        this.rear = temp;
        this.size++;
        System.out.println("Antrian dengan nomor " + temp.key + " telah diambil");
        return;
    }

    void dequeue() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        QNode temp = this.front;if (this.front == null || front() == 0) {
            System.out.println("Belum ada pengantre!");
            return;
        }
        this.front = this.front.next;
    
        if (this.front == null)
            this.rear = null;
            System.out.println("Antrian dengan nomor " + temp.key + " telah dipanggil");

        this.size--;
        return;
    }

    int front() {
        if (this.front != null) {
            return this.front.key;
        }
        return -1;
    }
    
}

public class Antrian {

    public static void main(String[] args) {

        Queue antrianBank = new Queue();
        int nomorAntrian = 0;
        int pilihan = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Selamat datang di program Antrian Bank");
        System.out.println("oleh Faturrohman Fairuz Zaki");
        do {
            System.out.println("1. Ambil Antrian");
            System.out.println("2. Panggil Antrian");
            System.out.println("3. Keluar program");
            System.out.print("Masukkan pilihan anda : ");
            pilihan = input.nextInt();
            input.nextLine();
            System.out.println();
            switch (pilihan) {
                case 1:    
                    nomorAntrian++;
                    antrianBank.enqueue(nomorAntrian);
                    break;
                case 2:
                    antrianBank.dequeue();
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    System.exit(0);
                default:
                    System.out.println("Input tidak valid!");
                    break;
            }
            System.out.println("Jumlah pengantre\t: " + antrianBank.size);
            if (antrianBank.size > 0) {
                System.out.println("Nasabah selanjutnya\t: " + antrianBank.front());
            }
            System.out.println();
        } while (pilihan != 3);
        input.close();
    }
}