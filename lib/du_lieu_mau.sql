INSERT INTO HoaDon (maHoaDon, ngayLap, maNhanVien, maKhachHang) VALUES
('HD00001', '2023-01-10', 'NV00001', 'KH00001'),
('HD00002', '2023-01-11', 'NV00002', 'KH00002'),
('HD00003', '2023-01-12', 'NV00003', 'KH00003'),
('HD00004', '2023-01-13', 'NV00004', 'KH00004'),
('HD00005', '2023-01-14', 'NV00005', 'KH00005'),
('HD00006', '2023-01-15', 'NV00006', 'KH00006'),
('HD00007', '2023-01-16', 'NV00007', 'KH00007'),
('HD00008', '2023-01-17', 'NV00008', 'KH00008'),
('HD00009', '2023-01-18', 'NV00009', 'KH00009'),
('HD00010', '2023-01-19', 'NV00010', 'KH00010');

INSERT INTO CT_HoaDon (maHoaDon, maThuoc, donGia, soLuong) VALUES
('HD00001', 'TT00001', 50000, 2),
('HD00001', 'TT00002', 30000, 1),
('HD00002', 'TT00003', 15000, 5),
('HD00002', 'TT00004', 20000, 3),
('HD00003', 'TT00005', 25000, 4),
('HD00004', 'TT00006', 10000, 7),
('HD00005', 'TT00007', 50000, 2),
('HD00006', 'TT00008', 70000, 1),
('HD00007', 'TT00009', 45000, 5),
('HD00008', 'TT00010', 35000, 6);

INSERT INTO NhaCungCap (maNCC, tenNCC, DiaChi, email, soDienThoai) VALUES
('NCC00001', 'Công ty Dược A', '123 Đường ABC, TP.HCM', 'contact@duoca.com', '0912345678'),
('NCC00002', 'Công ty Dược B', '456 Đường DEF, Hà Nội', 'contact@duocb.com', '0987654321'),
('NCC00003', 'Công ty Dược C', '789 Đường GHI, Đà Nẵng', 'contact@duocc.com', '0911222333'),
('NCC00004', 'Công ty Dược D', '321 Đường JKL, TP.HCM', 'contact@duocd.com', '0923456789'),
('NCC00005', 'Công ty Dược E', '654 Đường MNO, Hà Nội', 'contact@duoce.com', '0934567890'),
('NCC00006', 'Công ty Dược F', '987 Đường PQR, Đà Nẵng', 'contact@duocf.com', '0945678901'),
('NCC00007', 'Công ty Dược G', '147 Đường STU, TP.HCM', 'contact@duocg.com', '0956789012'),
('NCC00008', 'Công ty Dược H', '258 Đường VWX, Hà Nội', 'contact@duoch.com', '0967890123'),
('NCC00009', 'Công ty Dược I', '369 Đường YZA, Đà Nẵng', 'contact@duoci.com', '0978901234'),
('NCC00010', 'Công ty Dược J', '159 Đường BCD, TP.HCM', 'contact@duocj.com', '0989012345');

INSERT INTO LoaiThuoc (maLoai, tenLoai) VALUES
('LT00001', 'Thuốc giảm đau'),
('LT00002', 'Thuốc kháng sinh'),
('LT00003', 'Thuốc kháng viêm'),
('LT00004', 'Thuốc tiêu hóa'),
('LT00005', 'Thuốc bổ'),
('LT00006', 'Thuốc hạ sốt'),
('LT00007', 'Thuốc chống dị ứng'),
('LT00008', 'Thuốc giảm ho'),
('LT00009', 'Thuốc bổ sung vitamin'),
('LT00010', 'Thuốc kháng nấm');

INSERT INTO Thuoc (maThuoc, tenThuoc, maLoai, ngaySX, ngayHH, ngayNhap, giaNhap, hienThi, soLuongTon, soLuongNhap, maNCC) VALUES
('TT00001', 'Panadol', 'LT00001', '2022-01-01', '2024-01-01', '2023-01-01', 10000, 1, 100, 200, 'NCC00001'),
('TT00002', 'Amoxicillin', 'LT00002', '2022-02-01', '2024-02-01', '2023-02-01', 20000, 1, 150, 300, 'NCC00002'),
('TT00003', 'Ibuprofen', 'LT00003', '2022-03-01', '2024-03-01', '2023-03-01', 15000, 1, 200, 400, 'NCC00003'),
('TT00004', 'Omeprazole', 'LT00004', '2022-04-01', '2024-04-01', '2023-04-01', 25000, 1, 120, 240, 'NCC00004'),
('TT00005', 'Vitamin C', 'LT00009', '2022-05-01', '2024-05-01', '2023-05-01', 5000, 1, 180, 360, 'NCC00005'),
('TT00006', 'Paracetamol', 'LT00001', '2022-06-01', '2024-06-01', '2023-06-01', 8000, 1, 170, 340, 'NCC00006'),
('TT00007', 'Cetirizine', 'LT00007', '2022-07-01', '2024-07-01', '2023-07-01', 12000, 1, 160, 320, 'NCC00007'),
('TT00008', 'Cough Syrup', 'LT00008', '2022-08-01', '2024-08-01', '2023-08-01', 14000, 1, 140, 280, 'NCC00008'),
('TT00009', 'Multivitamins', 'LT00009', '2022-09-01', '2024-09-01', '2023-09-01', 6000, 1, 130, 260, 'NCC00009'),
('TT00010', 'Antifungal Cream', 'LT00010', '2022-10-01', '2024-10-01', '2023-10-01', 30000, 1, 110, 220, 'NCC00010');

INSERT INTO NhanVien (maNhanVien, Ho, Ten, SoDienThoai, email, CCCD, diaChi, maChucVu, gioiTinh, ngaySinh, hienThi) VALUES
('NV00001', 'Nguyen', 'An', '0912345678', 'an.nguyen@gmail.com', '012345678', '123 Đường ABC, TP.HCM', 'CV001', 'Nam', '1990-01-01', 1),
('NV00002', 'Tran', 'Binh', '0987654321', 'binh.tran@gmail.com', '123456789', '456 Đường DEF, Hà Nội', 'CV002', 'Nữ', '1991-02-01', 1),
('NV00003', 'Le', 'Cuong', '0911222333', 'cuong.le@gmail.com', '234567890', '789 Đường GHI, Đà Nẵng', 'CV001', 'Nam', '1992-03-01', 1),
('NV00004', 'Pham', 'Duong', '0923456789', 'duong.pham@gmail.com', '345678901', '321 Đường JKL, TP.HCM', 'CV001', 'Nữ', '1993-04-01', 1),
('NV00005', 'Hoang', 'An', '0934567890', 'an.hoang@gmail.com', '456789012', '654 Đường MNO, Hà Nội', 'CV001', 'Nam', '1994-05-01', 1),
('NV00006', 'Vo', 'Hanh', '0945678901', 'hanh.vo@gmail.com', '567890123', '987 Đường PQR, Đà Nẵng', 'CV001', 'Nữ', '1995-06-01', 1),
('NV00007', 'Vu', 'Hung', '0956789012', 'hung.vu@gmail.com', '678901234', '147 Đường STU, TP.HCM', 'CV001', 'Nam', '1996-07-01', 1),
('NV00008', 'Bui', 'Hien', '0967890123', 'hien.bui@gmail.com', '789012345', '258 Đường VWX, Hà Nội', 'CV002', 'Nữ', '1997-08-01', 1),
('NV00009', 'Ngo', 'Khanh', '0978901234', 'khanh.ngo@gmail.com', '890123456', '369 Đường YZA, Đà Nẵng', 'CV001', 'Nam', '1998-09-01', 1),
('NV00010', 'Dinh', 'Lam', '0989012345', 'lam.dinh@gmail.com', '901234567', '159 Đường BCD, TP.HCM', 'CV001', 'Nữ', '1999-10-01', 1);



INSERT INTO KhachHang (maKhachHang, tenKH, soDienThoai, diaChi, email) VALUES
('KH00001', 'Nguyen Van A', '0912345678', '123 Đường ABC, TP.HCM', 'kh01@gmail.com'),
('KH00002', 'Tran Thi B', '0987654321', '456 Đường DEF, Hà Nội', 'kh02@gmail.com'),
('KH00003', 'Le Van C', '0911222333', '789 Đường GHI, Đà Nẵng', 'kh03@gmail.com'),
('KH00004', 'Pham Thi D', '0923456789', '321 Đường JKL, TP.HCM', 'kh04@gmail.com'),
('KH00005', 'Hoang Van E', '0934567890', '654 Đường MNO, Hà Nội', 'kh05@gmail.com'),
('KH00006', 'Vo Thi F', '0945678901', '987 Đường PQR, Đà Nẵng', 'kh06@gmail.com'),
('KH00007', 'Vu Van G', '0956789012', '147 Đường STU, TP.HCM', 'kh07@gmail.com'),
('KH00008', 'Bui Van H', '0967890123', '258 Đường VWX, Hà Nội', 'kh08@gmail.com'),
('KH00009', 'Ngo Van I', '0978901234', '369 Đường YZA, Đà Nẵng', 'kh09@gmail.com'),
('KH00010', 'Dinh Thi J', '0989012345', '159 Đường BCD, TP.HCM', 'kh10@gmail.com');


INSERT INTO ChucVu (maChucVu, tenChucVu) VALUES
('CV001', 'Nhân viên bán hàng'),
('CV002', 'Người Quản lý');

INSERT INTO TaiKhoan (tenTK, matKhau, maNhanVien) VALUES
('kha123', '123456', 'NV00001'),
('user2', '123456', 'NV00002');

select * from dbo.ChucVu
select * from dbo.KhachHang
select * from dbo.NhanVien
select * from dbo.HoaDon
select * from dbo.CT_HoaDon
select * from dbo.Thuoc
select * from dbo.LoaiThuoc
select * from dbo.TaiKhoan
select * from dbo.NhaCungCap


