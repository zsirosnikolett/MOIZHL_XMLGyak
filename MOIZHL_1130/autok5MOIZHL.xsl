<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/">
        <html>
            <body>
                <table>
                    <tr>
                        <th>Parasznyai rendszámok listája:</th>
                    </tr>
                    <xsl:for-each select="//tipus[not(preceding::tipus/. = .)]">

                            <tr>
                                <td> <xsl:value-of select="."/> </td>

                            </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
