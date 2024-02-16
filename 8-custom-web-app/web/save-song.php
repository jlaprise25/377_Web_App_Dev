<?php

include('library.php');

$connection = get_database_connection();

$sql = '';

if (isset($id) && $id != '')
{
    $sql =<<<SQL
    UPDATE songs
    SET son_name = '$name',
        son_artist = '$artist',
        son_genre = '$genre',
        son_album = '$album',
        son_year = $year,
        son_spotlink = '$spot_id',
        son_length = '$length',   
        son_explicit = '$explicit',
        son_features = '$features'
    WHERE son_id = $id
    SQL;
}
else
{
    $sql =<<<SQL
    INSERT INTO songs (son_name, son_artist, son_genre, son_album, son_year, son_spotlink, son_length, son_explicit, son_features)
    VALUES ('$name', '$artist', '$genre', '$album', '$year', '$spot_id', '$length', '$explicit', '$features')
    SQL;
}
echo $sql;
$connection->query($sql);

header('Location: index.php');

    