CREATE TABLE Sach(
    ID INT NOT NULL AUTO_INCREMENT,
    MaSach VARCHAR(32) NOT NULL,
    TenSach VARCHAR(32) NOT NULL,
    NhaXuatBan VARCHAR(32) NOT NULL,
    NamXuatBan VARCHAR(32) NOT NULL,
    CONSTRAINT PRIMARY KEY(ID)
);
CREATE TABLE DocGia(
    ID INT NOT NULL AUTO_INCREMENT,
    MaDocGia VARCHAR(32) NOT NULL,
    TenDocGia VARCHAR(32) NOT NULL,
    NgaySinh DATE NOT NULL,
    GioiTinh VARCHAR(32) NOT NULL,
    CONSTRAINT PRIMARY KEY(ID)
);
CREATE TABLE MuonTra(
    MaDocGia VARCHAR(32) NOT NULL,
    MaSach VARCHAR(32) NOT NULL,
    NgayMuon DATE NOT NULL,
    CONSTRAINT PRIMARY KEY(MaDocGia,MaSach,NgayMuon),
    CONSTRAINT FOREIGN KEY fk_docgia (MaDocGia) REFERENCES DocGia (MaDocGia),
    CONSTRAINT FOREIGN KEY fk_sach (MaSach) REFERENCES Sach (MaSach)
);