<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
    <xsl:output method="html" indent="yes"/>
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
        <h1>Danh sách điểm học môn THVP và điểm thi >= 5</h1>
        <table>
          <tr>
            <th>Mã sinh viên</th>
            <th>Mã môn học</th>
            <th>Điểm</th>
          </tr>
          <xsl:for-each select="MonThi/Mon">
            <xsl:if test="MaMH = 'THVP'">
              <xsl:if test="DiemThi >= '5'">
              <tr>
                <td>
                  <xsl:value-of select="MaSV"/>
                </td>
                <td>
                  <xsl:value-of select="MaMH"/>
                </td>
                <td>
                  <xsl:value-of select="DiemThi"/>
                </td>
              </tr>
              </xsl:if>
            </xsl:if>
          </xsl:for-each>
        </table>
      </body>
    </xsl:template>
</xsl:stylesheet>
