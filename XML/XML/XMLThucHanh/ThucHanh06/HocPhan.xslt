<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/HocPhan">
      <style>
        table{
        border-collapse: collapse;
        }
        table,th, tr, td{
        border: 1px solid green;
        padding: 5px;
        }
      </style>
      <body>
        <p>Lớp học phần: <xsl:value-of select="LopHocPhan"/></p>
        <p>
          Học kỳ: <xsl:value-of select="HocKy"/>
        </p>
        <p>
          Năm học: <xsl:value-of select="NamHoc"/>
        </p>
        <p>
          Số tín chỉ: <xsl:value-of select="SoTinChi"/>
        </p>
        <table>
          <tr>
            <th>STT</th>
            <th>Họ tên</th>
            <th>Ngày sinh</th>
            <th>Lớp</th>
            <th>Thường sinh</th>
            <th>Thi</th>
            <th>Tổng kết</th>
            <th>Điểm chữ</th>
          </tr>
          <xsl:for-each select="DanhSachSinhVien/SinhVien">
            <tr>
              <td>
                <xsl:value-of select="STT"/>
              </td>
              <td>
                <xsl:value-of select="HoTen"/>
              </td>
              <td>
                <xsl:value-of select="NgaySinh"/>
              </td>
              <td>
                <xsl:value-of select="Lop"/>
              </td>
              <td>
                <xsl:value-of select="ThuongXuyen"/>
              </td>
              <td>
                <xsl:value-of select="Thi"/>
              </td>
              <td>
                <xsl:value-of select="TKHocPhan"/>
              </td>
              <td>
                <xsl:value-of select="DiemChu"/>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </xsl:template>
</xsl:stylesheet>
