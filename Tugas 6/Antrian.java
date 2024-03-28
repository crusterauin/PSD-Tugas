import java.util.Scanner;

public class Antrian {

    int front, rear, size;
    int capacity;
    int array[];

    public Antrian(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    boolean isFull(Antrian antrian) {
        return (antrian.size == antrian.capacity);
    }

    boolean isEmpty(Antrian antrian) {
        return (antrian.size == 0);
    }

    void enqueue(int item) {
        if (isFull(this))
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
    }

    int dequeue() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return item;
    }

    int front() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.front];
    }

    int rear() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }

    public static void main(String[] args) {
        Antrian antrianBank = new Antrian(10);

        int nomorAntrian = 0;
        int pilihan = 0;
        Scanner input = new Scanner(System.in);

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
                    if (antrianBank.isFull(antrianBank)) {
                        System.out.println("Antian sedang penuh!");
                        break;
                    } else {
                        nomorAntrian++;
                        antrianBank.enqueue(nomorAntrian);
                        System.out.println("Antrian dengan nomor " + nomorAntrian + " telah diambil");
                    }
                    break;
                case 2:
                    if (antrianBank.isEmpty(antrianBank)) {
                        System.out.println("Belum ada pengantre!");
                    } else {
                        int panggil = antrianBank.dequeue();
                        System.out.println("Antrian dengan nomor " + panggil + " telah dipanggil");
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    System.exit(0);
                default:
                    System.out.println("Input tidak valid!");
                    break;
            }
            System.out.println("Jumlah pengantre\t: " + antrianBank.size);
            if (antrianBank.size > 0){
                System.out.println("Nasabah selanjutnya\t: " + antrianBank.front());
            }
            System.out.println();
        } while (pilihan != 3);
        input.close();
    }
}