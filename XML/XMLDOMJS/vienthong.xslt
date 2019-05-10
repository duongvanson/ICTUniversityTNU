<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	<xsl:template match="/Quyen">
		<h1>Thông tin hóa đơn số 1</h1>
		<p>Mã khách:
			<xsl:value-of select="HoaDon[1]/@makhach"/>
		</p>
		<p>
			Họ tên: <xsl:value-of select="HoaDon[1]/HoTen"/>
		</p>
		<p>
			SĐT: <xsl:value-of select="HoaDon[1]/SDT"/>
		</p>
		<p>Danh sach dich vu</p>
		<xsl:for-each select="HoaDon[1]/DSDichVu/DichVu">
			<p>
				Mã: <xsl:value-of select="@madv" /> |
				Tên: <xsl:value-of select="TenDV"/> |
				Giá: <xsl:value-of select="Gia"/>
			</p>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>