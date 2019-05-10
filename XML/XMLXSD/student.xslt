<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	<xsl:template match="/">
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Sex</th>
			</tr>
		<xsl:for-each select="student">
			<td><xsl:value-of select="ID"/></td>
			<td><xsl:value-of select="Name"/></td>
			<td><xsl:value-of select="Sex"/></td>
		</xsl:for-each>
		</table>
	</xsl:template>
</xsl:stylesheet>