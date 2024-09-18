<?php
    // Charger les fichiers XML et XSLT
    $xml = new DOMDocument;
    $xml->load('C:\Users\Utilisateur\Desktop\Files\movies.xml');

    $xsl = new DOMDocument;
    $xsl->load('movies.xsl');

    // Configurer le transformateur
    $proc = new XSLTProcessor;
    $proc->importStyleSheet($xsl);

    // Transformer le fichier XML en HTML
    echo $proc->transformToXML($xml);
?>