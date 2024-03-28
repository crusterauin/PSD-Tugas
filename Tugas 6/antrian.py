class Queue:

	def __init__(self, capacity):
		self.front = self.size = 0
		self.rear = capacity - 1
		self.Q = [None]*capacity
		self.capacity = capacity

	def isFull(self):
		return self.size == self.capacity

	def isEmpty(self):
		return self.size == 0

	def EnQueue(self, item):
		self.rear = (self.rear + 1) % (self.capacity)
		self.Q[self.rear] = item
		self.size = self.size + 1

	def DeQueue(self):
		self.front = (self.front + 1) % (self.capacity)
		self.size = self.size - 1

	def que_front(self):
		return self.Q[self.front]

	def que_rear(self):
		return self.Q[self.rear]

def main():
    print("")
    print("1. Ambil antrian")
    print("2. Panggil antrian")
    print("3. Keluar program")
    return int(input("Masukkan pilihan anda: "))

if __name__ == '__main__':
    queue = Queue(10)
    nomorAntrian = 0
    pilihan = 0

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
                print("Antrian dengan nomor " + str(nomorAntrian) + " telah diambil.")
        elif choice == 2:
            if queue.isEmpty():
                print("Belum ada pengantre!")
            else:
                panggil = queue.que_front()
                queue.DeQueue()
                print("Antrian dengan nomor " + str(panggil) + " telah dipanggil.")
        elif choice == 3:
            print("Terima kasih telah menggunakan program ini!")
            break
        else:
            print("Input tidak valid!")
        
        antrian = queue.size
        print("Jumlah pengantre\t: " + str(antrian))
        if antrian > 0:
            print("Nasabah selanjuttnya\t: " + str(queue.que_front()))