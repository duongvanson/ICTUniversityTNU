<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/qldiem">
      <style>
        table{
        border-collapse: collapse;
        margin-left: 30px;
        }
        table,th, tr, td{
        border: 1px solid gray;
        padding: 5px;
        }
        div{
        padding: 10px;
        margin: 10px;
        }
      </style>
      <body>
        <h1>Danh sách sinh viên</h1>
        <xsl:for-each select="SinhVien">
          <div>
            <h3>
              <xsl:value-of select="@MaSV"/> |
              <xsl:value-of select="HoTen"/> |
              <xsl:value-of select="NamSinh"/> |
              <xsl:value-of select="Lop"/>
            </h3>
              <p>Danh sách môn học</p>
            <table>
              <tr>
                <th>Mã Môn</th>
                <th>Tên Môn</th>
                <th>Số TC</th>
                <th>Điểm</th>
              </tr>
              <xsl:for-each select="MonHoc">
                <tr>
                  <td>
                    <xsl:value-of select="@MaMon"/>
                  </td>
                  <td>
                    <xsl:value-of select="TenMon"/>
                  </td>
                  <td>
                    <xsl:value-of select="SoTC"/>
                  </td>
                  <td>
                    <xsl:value-of select="Diem"/>
                  </td>
                </tr>
              </xsl:for-each>
            </table>
          </div>
        </xsl:for-each>
      </body>
    </xsl:template>
</xsl:stylesheet>
