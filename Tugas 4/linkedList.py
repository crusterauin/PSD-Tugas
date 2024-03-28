import os

class Student:
    def __init__(self, nim, nama, umur, jmlSaudara):
        self.nim = nim
        self.nama = nama
        self.umur = umur
        self.jmlSaudara = jmlSaudara
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def insertLinkedList(self, nim, nama, umur, jmlSaudara):
        new_node = Student(nim, nama, umur, jmlSaudara)
        if self.head is None:
            self.head = new_node
        else:
            new_node.next = self.head
            self.head = new_node

    def sizeOfLL(self):
        size = 0
        current_node = self.head
        while current_node:
            size += 1
            current_node = current_node.next
        return size

        
def main():
    print("# Selamat datang di Program Pendataan Mahasiswa #")
    print("========# oleh: Faturrohman Fairuz Zaki #========")
    print("=================================================")
    print("1. INPUT DATA")
    print("2. TAMPIL DATA")
    print("3. EXIT")
    choice = input("Pilihan Anda : ")
    return choice

student = LinkedList()

while True:
    choice = main()
    if choice == "1":
        if student.sizeOfLL() == 10:
            print("Kelas sudah penuh!")
        else:
            inputNim = input("Masukkan NIM : ")
            inputNama = input("Masukkan Nama : ")
            inputUmur = int(input("Masukkan Umur : "))
            inputJmlSaudara = int(input("Masukkan Jumlah Saudara: "))
            student.insertLinkedList(inputNim, inputNama, inputUmur, inputJmlSaudara)
            os.system('cls' if os.name == 'nt' else 'clear')
            print("Data berhasil tersimpan!")
    elif choice == "2":
        os.system('cls' if os.name == 'nt' else 'clear')
        print("Data Mahasiswa :")
        if student.sizeOfLL() == 0:
            print("Linked list kosong.")
        else:
            current_node = student.head
            while current_node:
                print("NIM\t\t: ", current_node.nim)
                print("Nama\t\t: ", current_node.nama)
                print("Umur\t\t: ", current_node.umur)
                print("Jumlah Saudara\t: ", current_node.jmlSaudara)
                print("==================================")
                current_node = current_node.next
    elif choice == "3":
        os.system('cls' if os.name == 'nt' else 'clear')
        print("Terima Kasih")
        exit()
    else:
        os.system('cls' if os.name == 'nt' else 'clear')
        print("Input tidak valid!")
