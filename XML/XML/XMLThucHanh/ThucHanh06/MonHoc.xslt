<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/DanhSachMonHoc">
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
        <h1>Danh sách môn học > 40 số giờ</h1>
          <table>
            <tr>
              <th>Mã môn</th>
              <th>Tên môn học</th>
              <th>Số giờ</th>
            </tr>
            <xsl:for-each select="MonHoc">
              <xsl:if test="SoGio >= 40">
                <tr>
                  <td>
                    <xsl:value-of select="@MaMonHoc"/>
                  </td>
                  <td>
                    <xsl:value-of select="TenMonHoc"/>
                  </td>
                  <td>
                    <xsl:value-of select="SoGio"/>
                  </td>
                </tr>
            </xsl:if>
            </xsl:for-each>
          </table>
      </body>
    </xsl:template>
</xsl:stylesheet>
