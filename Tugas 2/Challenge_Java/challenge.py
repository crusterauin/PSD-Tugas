import os

student = []
index = 0

class Student:
    def __init__(self, nim, nama, umur, jmlSaudara):
        self.nim = nim
        self.name = nama
        self.umur = umur
        self.jmlSaudara = jmlSaudara
        
def main():
    print("# Selamat datang di Program Pendataan Mahasiswa #")
    print("========# oleh: Faturrohman Fairuz Zaki #========")
    print("=================================================")
    print("1. INPUT DATA")
    print("2. TAMPIL DATA")
    print("3. EXIT")
    choice = input("Pilihan Anda : ")
    return choice

while True:
    choice = main()
    if choice == "1":
        if index > 9:
            print("Kelas sudah penuh!")
        else:
            inputNim = input("Masukkan NIM : ")
            nim_exists = False
            for i in student:
                if inputNim == i.nim:
                    nim_exists = True
                    break
            if nim_exists:
                os.system('cls' if os.name == 'nt' else 'clear')
                print("NIM sudah ada!")
            else:
                inputNama = input("Masukkan Nama : ")
                inputUmur = input("Masukkan Umur : ")
                inputJmlSaudara = input("Masukkan Jumlah Saudara: ")
                s = Student(inputNim, inputNama, inputUmur, inputJmlSaudara)
                student.append(s)
                index += 1
                os.system('cls' if os.name == 'nt' else 'clear')
                print("Data berhasil tersimpan!")
    elif choice == "2":
        os.system('cls' if os.name == 'nt' else 'clear')
        print("Data Mahasiswa :")
        for i in student:
            print("NIM\t\t: ", i.nim)
            print("Nama\t\t: ", i.name)
            print("Umur\t\t: ", i.umur)
            print("Jumlah Saudara\t: ", i.jmlSaudara)
            print("==================================")
    elif choice == "3":
        os.system('cls' if os.name == 'nt' else 'clear')
        print("Terima Kasih")
        exit()
    else:
        os.system('cls' if os.name == 'nt' else 'clear')
        print("Input tidak valid!")