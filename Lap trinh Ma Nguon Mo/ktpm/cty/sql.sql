-- Danh sach nhan vien
SELECT * FROM nhanvien
-- Nhan vien gioi tinh = 1
SELECT * FROM nhanvien WHERE gioitinh = 1
-- Nhan vien tham gia >= 1
SELECT *
FROM nhanvien nv
WHERE nv.manv IN (
    SELECT manv
    FROM thamgia
    GROUP BY(manv)
    HAVING COUNT(manv) >= 1)
--
SELECT nv.*, COUNT(tg.manv) as sl
FROM nhanvien nv, thamgia tg
WHERE nv.manv = tg.manv
GROUP BY tg.manv
HAVING COUNT(tg.manv) >= 1