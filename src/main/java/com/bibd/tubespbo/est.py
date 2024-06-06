# Fungsi untuk menampilkan menu
def menu():
    print("1. Input Data Mahasiswa")
    print("2. Lihat Data Mahasiswa")
    print("3. Keluar")

# Fungsi untuk menginput data mahasiswa
def input_data():
    nama = input("Nama: ")
    nim = input("NIM: ")
    tgl_lahir = input("Tgl. Lahir: ")
    prodi = input("Prodi: ")
    fakultas = input("Fakultas: ")
    
    mahasiswa = {
        "Nama": nama,
        "NIM": nim,
        "Tgl. Lahir": tgl_lahir,
        "Prodi": prodi,
        "Fakultas": fakultas
    }
    
    return mahasiswa

# Fungsi untuk melihat data mahasiswa
def lihat_data(mahasiswa):
    if mahasiswa:
        print("\n+------------------------------------------------------+")
        print("|                    Kartu Mahasiswa UNS               |")
        print("+------------------------------------------------------+")
        print("| Nama      :  |".format(mahasiswa["Nama"]))
        print("| NIM       : {:<44} |".format(mahasiswa["NIM"]))
        print("| Tgl. Lahir: {:<44} |".format(mahasiswa["Tgl. Lahir"]))
        print("| Prodi     : {:<44} |".format(mahasiswa["Prodi"]))
        print("| Fakultas  : {:<44} |".format(mahasiswa["Fakultas"]))
        print("+------------------------------------------------------+\n")
    else:
        print("Belum ada data mahasiswa yang diinput.")

def main():
    mahasiswa = None
    while True:
        menu()
        pilihan = input("Pilih menu: ")
        
        if pilihan == '1':
            mahasiswa = input_data()
        elif pilihan == '2':
            lihat_data(mahasiswa)
        elif pilihan == '3':
            print("Terima kasih! Program selesai.")
            break
        else:
            print("Pilihan tidak valid. Silakan coba lagi.")

if __name__ == "__main__":
    main()
