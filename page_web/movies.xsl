<?xml version="1.0" encoding="UTF-8"?>
    <xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:template match="/">
            <html>
                <head>
                    <title>movieList</title>

                    <style>
                        h1
                        {
                            text-align: center;
                        }

                        table 
                        {
                            width: 100%;
                            border-collapse: collapse;
                        }

                        th, td 
                        {
                            border: 1px solid #ddd;
                            padding: 8px;
                            text-align: center;
                        }

                        th 
                        {
                            background-color: #9acd32;
                            color: white;
                        }

                        td 
                        {
                            vertical-align: top;
                        }
                    </style>

                </head>
                <body>
                    <h1>My Movie List</h1>

                    <table border="1">
                        <tr bgcolor="#9acd32">
                            <th>Identifier</th>
                            <th>Title</th>
                            <th>Original Title</th>
                            <th>Released Date</th>
                            <th>Status</th>
                            <th>Vote Average</th>
                            <th>Vote Count</th>
                            <th>Runtime</th>
                            <th>Certification</th>
                            <th>Poster Path</th>
                            <th>Budget</th>
                            <th>Tagline</th>
                            <th>Genres</th>
                            <th>Directors</th>
                            <th>Actors</th>
                        </tr>
                        <xsl:for-each select="//movie">
                            <tr>
                                <td><xsl:value-of select="@id"/></td>
                                <td><xsl:value-of select="title"/></td>
                                <td><xsl:value-of select="originalTitle"/></td>
                                <td><xsl:value-of select="releasedDate"/></td>
                                <td><xsl:value-of select="status"/></td>
                                <td><xsl:value-of select="voteAverage"/></td>
                                <td><xsl:value-of select="voteCount"/></td>
                                <td><xsl:value-of select="runtime"/></td>
                                <td><xsl:value-of select="certification"/></td>
                                <td><xsl:value-of select="posterPath"/></td>
                                <td><xsl:value-of select="budget"/></td>
                                <td><xsl:value-of select="tagline"/></td>

                                <td>
                                    <xsl:for-each select="genres/genre">
                                        <div>
                                            <b>Id: <xsl:value-of select="@idGenre"/></b> 
                                            <br/>Name :<xsl:value-of select="@nameGenre"/>
                                        </div>
                                        <xsl:if test="position() != last()">
                                            <hr/>
                                        </xsl:if>
                                    </xsl:for-each>
                                </td>

                                <td>
                                    <xsl:for-each select="directors/director">
                                        <div>
                                            <b>Id: <xsl:value-of select="@idDirector"/></b> 
                                            <br/>Name :<xsl:value-of select="@nameDirector"/>
                                        </div>
                                        <xsl:if test="position() != last()">
                                            <hr/>
                                        </xsl:if>
                                    </xsl:for-each>
                                </td>

                                <td>
                                    <xsl:for-each select="actors/actor">
                                        <div>
                                            <b>Id: <xsl:value-of select="@idActor"/></b> 
                                            <br/>Name :<xsl:value-of select="@nameActor"/>
                                            <br/>Character: <xsl:value-of select="@characterActor"/>
                                        </div>
                                        <xsl:if test="position() != last()">
                                            <hr/>
                                        </xsl:if>
                                    </xsl:for-each>
                                </td>
                            </tr>
                    </xsl:for-each>
                    </table>
                </body>
            </html>
        </xsl:template>
    </xsl:stylesheet>