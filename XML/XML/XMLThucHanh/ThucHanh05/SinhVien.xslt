<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
          <style>
        table{
            border-collapse: collapse;
        }
        table,th, tr, td{
            border: 1px solid green;
            padding: 5px;
        }
          </style>
          <table>
            <tr>
              <th>STT</th>
              <th>Mã Sinh Viên</th>
              <th>Tên sinh viên</th>
              <th>Giới tính</th>
              <th>Ngày sinh</th>
              <th>Mã lớp</th>
            </tr>
            <xsl:for-each select="DanhSachSinhVien/SinhVien">
              <xsl:sort select="HoTen"/>
              <tr>
                <td>
                  <xsl:value-of select="STT"/>
                </td>
                <td>
                  <xsl:value-of select="@MaSV"/>
                </td>
                <td>
                  <xsl:value-of select="HoTen"/>
                </td>
                <td>
                  <xsl:value-of select="GioiTinh"/>
                </td>
                <td>
                  <xsl:value-of select="NgaySinh"/>
                </td>
                <td>
                  <xsl:value-of select="MaLop"/>
                </td>
              </tr>
            </xsl:for-each>
          </table>
    </xsl:template>
</xsl:stylesheet>
