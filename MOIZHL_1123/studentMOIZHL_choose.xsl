<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>

            <body>
                <table>
                    <tr>
                        <td>Vezetéknév</td>
                        <td>Keresztnév</td>
                        <td>Becenév</td>
                        <td>Kor</td>
                        <td>Fizetés</td>
                    </tr>
                    <xsl:for-each select="class/student">
                        <tr>
                            <td><xsl:value-of select="vezeteknev"/></td>
                            <td><xsl:value-of select="keresztnev"/></td>
                            <td><xsl:value-of select="becenev"/></td>
                            <td><xsl:value-of select="kor"/></td>
                            <td><xsl:value-of select="fizetes"/></td>
                            <xsl:choose>
                                <xsl:when test="fizetes &gt; 12000">
                                    <td bgcolor="#ff00ff">Magas<xsl:value-of select="artist"/></td>
                                </xsl:when>
                                <xsl:when test="fizetes &lt; 100000">
                                    <td bgcolor="#0000ff">Alacsony<xsl:value-of select="artist"/></td>
                                </xsl:when>
                                <xsl:otherwise>
                                    <td>Közepes</td>
                                </xsl:otherwise>
                            </xsl:choose>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
