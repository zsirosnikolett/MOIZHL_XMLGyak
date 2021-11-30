<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >

    <xsl:template match="/">
        <html>
            <body>
                <h2>Hallgatok apply-template</h2>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="class/student">
        <div>
            <xsl:apply-templates select="@id"/>
            <xsl:apply-templates select="vezeteknev"/>
            <xsl:apply-templates select="keresztnev"/>
            <xsl:apply-templates select="becenev"/>
            <xsl:apply-templates select="kor"/>
            <xsl:apply-templates select="fizetes"/>
        </div>
    </xsl:template>

    <xsl:template match="@id">
        ID: <span style="color:#ffff00">
        <xsl:value-of select="."/></span>
        <br />
    </xsl:template>

    <xsl:template match="vezeteknev">
        Vezetéknév: <span style="color:#ff0000">
        <xsl:value-of select="."/></span>
        <br />
    </xsl:template>

    <xsl:template match="keresztnev">
        Keresztnév: <span style="color:#0000ff">
        <xsl:value-of select="."/></span>
        <br />
    </xsl:template>

    <xsl:template match="becenev">
        Becenév: <span style="color:#00f0f0">
        <xsl:value-of select="."/></span>
        <br />
    </xsl:template>

    <xsl:template match="kor">
        Kor: <span style="color:#0f0f00">
        <xsl:value-of select="."/></span>
        <br />
    </xsl:template>

    <xsl:template match="fizetes">
        Fizetés: <span style="color:#00ff00">
        <xsl:value-of select="."/></span>
        <br />
        <br />
    </xsl:template>
</xsl:stylesheet>
