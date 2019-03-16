<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
    <xsl:template match="/">
      <xsl:for-each select="DanhSachLop/Lop">
        <p>
          <xsl:value-of select="MaLop"/>
          <xsl:value-of select="TenLop"/>
        </p>
      </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
