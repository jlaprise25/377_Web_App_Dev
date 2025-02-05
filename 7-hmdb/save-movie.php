<?php

include('library.php');

$connection = get_database_connection();

$sql = '';

if (isset($id) && $id != '')
{
    $sql =<<<SQL
    UPDATE movies
       SET mov_title = '$title',
           mov_year = $year,
           mov_genre = '$genre',
           mov_imdb_id = '$imdb_id',
           mov_duration = $duration,
           mov_director = '$director'
           mov_budget = $budget
           mov_earnings = $earnings
     WHERE mov_id = $id
    SQL;
}
else
{
    $sql =<<<SQL
    INSERT INTO movies (mov_title, mov_year, mov_genre, mov_duration, mov_director, mov_budget, mov_earnings, mov_imdb_id)
    VALUES ('$title', $year, '$genre', $duration, '$director', $budget, $earnings, '$imdb_id')
    SQL;
}
$connection->query($sql);

header('Location: index.php');