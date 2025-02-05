<br>

<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th>Name</th>
            <th>Artist</th>
            <th>Features</th>
            <th>Genre</th>
            <th>Album</th>
            <th>Length</th>
            <th>Year</th>
            <th>Spotify</th>
        </tr>
    </thead>
    <tbody>
<?php

$connection = get_database_connection();

$sql =<<<SQL
SELECT *
  FROM songs
 ORDER BY son_name, son_year
SQL;

$result = $connection->query($sql);
while ($row = $result->fetch_assoc())


{
    echo '<tr>';
    echo '<td>';
    if ($row['son_explicit'] == 'Explicit')
    { 
        echo '<a href="index.php?content=song-detail&id=' . $row['son_id'] . '">' . $row['son_name'] . '</a>&nbsp;<i class="bi bi-explicit-fill"></i>';
    } else
    {
        echo '<a href="index.php?content=song-detail&id=' . $row['son_id'] . '">' . $row['son_name'] . '</a>';
    }
    echo '</td>';
    echo '<td>' . $row['son_artist'] . '</td>';
    echo '<td>' . $row['son_features'] . '</td>';
    echo '<td>' . $row['son_genre'] . '</td>';
    echo '<td>' . $row['son_album'] . '</td>';
    echo '<td>' . $row['son_length'] . '</td>';
    echo '<td>' . $row['son_year'] . '</td>';
    echo '<td>';
    if ($row['son_spotlink'] != '')
    {
        echo '<a href="https://open.spotify.com/track/' . $row['son_spotlink'] . ' target="_blank" title="View on Spotify"><i class="bi bi-spotify green"></i></a>';
    }
    echo '</td>';
    echo '</tr>';
}

?>
    </tbody>
</table>

<a href="index.php?content=song-detail" class="btn btn-primary" role="button" aria-disabled="true">Add a Song</a>