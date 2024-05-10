<?php

include('library.php');

$connection = get_database_connection();

$sql = '';

if (isset($id) && $id != '')
{
    $sql =<<<SQL
    UPDATE times
       SET tim_name = '$title',
           tim_time = '$year',
           
     WHERE tim_id = $id
    SQL;
}
else
{
    $sql =<<<SQL
    INSERT INTO times (tim_name, tim_time)
    VALUES ('$name', '$time')
    SQL;
}
$connection->query($sql);

header('Location: index.php');