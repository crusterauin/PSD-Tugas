import os

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Queue:
    def __init__(self):
        self.front = self.rear = None
        self.capacity = 10
        self.size = 0
    
    def isEmpty(self):
        os.system('cls' if os.name == 'nt' else 'clear')
        return self.front == None

    def isFull(self):
        os.system('cls' if os.name == 'nt' else 'clear')
        return self.size == self.capacity
 
    def EnQueue(self, item):
        os.system('cls' if os.name == 'nt' else 'clear')
        temp = Node(item)
 
        if self.rear == None:
            self.front = self.rear = temp
            return
        self.rear.next = temp
        self.rear = temp
 
    def DeQueue(self):
        os.system('cls' if os.name == 'nt' else 'clear')
        
        if self.isEmpty():
            return
        temp = self.front
        self.front = temp.next
 
        if(self.front == None):
            self.rear = None

def main():
    print("")
    print("1. Ambil antrian")
    print("2. Panggil antrian")
    print("3. Keluar program")
    return int(input("Masukkan pilihan anda: "))

if __name__ == '__main__':
    queue = Queue()
    nomorAntrian = 0
    pilihan = 0

    os.system('cls' if os.name == 'nt' else 'clear')
    print("Selamat datang di program Antrian Bank")
    print("========# oleh: Faturrohman Fairuz Zaki #========")
    
    while True:
        choice = main()
        print("")
        if choice == 1:
            if queue.isFull():
                print("Antrian sedang penuh!")
            else:
                nomorAntrian += 1
                queue.EnQueue(nomorAntrian)
                queue.size += 1
                print("Antrian dengan nomor " + str(nomorAntrian) + " telah diambil.")
        elif choice == 2:
            if queue.isEmpty():
                print("Belum ada pengantre!")
            else:
                panggil = queue.front.data
                queue.DeQueue()
                queue.size -= 1
                print("Antrian dengan nomor " + str(panggil) + " telah dipanggil.")
        elif choice == 3:
            os.system('cls' if os.name == 'nt' else 'clear')
            print("Terima kasih telah menggunakan program ini!")
            break
        else:
            print("Input tidak valid!")
        
        antrian = queue.size
        print("Jumlah pengantre\t: " + str(antrian))
        if antrian > 0:
            print("Nasabah selanjutnya\t: " + str(queue.front.data))