<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th>Name</th>
            <th>Time</th>
        </tr>
    </thead>

    <tbody>
<?php

$connection = get_database_connection();

$sql =<<<SQL
SELECT tim_id, tim_name, tim_time
  FROM times
 ORDER BY tim_time, tim_name
SQL;

$result = $connection->query($sql);
while ($row = $result->fetch_assoc())
{
    echo '<tr>';
    echo '<td>';
    echo '<a href="index.php?content=time-detail&id=' . $row['tim_id'] . '">' . $row['tim_name'] . '</a>';
    echo '</td>';
    echo '<td>' . $row['tim_time'] . '</td>';
    echo '<td>';
    echo '</tr>';
}

?>
    </tbody>
</table>

<a href="index.php?content=time-detail" class="btn btn-primary" role="button" aria-disabled="true">Add a Time</a>
<a href="index.html" class="btn btn-primary" role="button" aria-disabled="true">Go to Game</a>