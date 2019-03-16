<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
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
      <body>
        <h1>Khách sạn X</h1>
        <h3>
          Địa chỉ: <xsl:value-of select="/KhachSan/DiaChi"/>
        </h3>
        <h3>
          SĐT: <xsl:value-of select="/KhachSan/SDT"/>
        </h3>
        <table>
          <tr>
            <th>Loại phòng</th>
            <th>Giá phòng</th>
          </tr>
          <xsl:for-each select="/KhachSan/BangThuePhong/Phong">
            <tr>
              <td>
                <xsl:value-of select="@loai_phong"/>
              </td>
              <td>
                <xsl:value-of select="@don_gia"/>
              </td>
            </tr>
          </xsl:for-each>
        </table>
        <h3>
          Ghi chú: <xsl:value-of select="/KhachSan/GhiChu"/>
        </h3>
      </body>
    </xsl:template>
</xsl:stylesheet>
