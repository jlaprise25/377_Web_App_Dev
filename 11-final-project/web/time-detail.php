<?php

$name = '';
$time = '';


if (isset($id))
{
    $connection = get_database_connection();

    $sql =<<<SQL
    SELECT tim_id, tim_name, tim_time 
      FROM times
      WHERE tim_id = $id
    SQL;

    $result = $connection->query($sql);
    $row = $result->fetch_assoc();

    $name = $row['tim_name'];
    $time = $row['tim_time'];

}

?>
<form action="save-time.php">
    <input type="hidden" class="form-control" id="id" name="id" value="<?php echo isset($id) ? $id : '' ?>" />

    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" name="name" value="<?php echo $name ?>" />
    </div>

    <div class="mb-3">
        <label for="Time" class="form-label">Time</label>
        <input type="text" class="form-control" id="time" name="time" value="<?php echo $time ?>" />
    </div>

    <button type="submit" class="btn btn-primary">Save</button>
    <a href="index.php?content=time-list" class="btn btn-secondary" role="button" aria-disabled="true">Cancel</a>
<?php if (isset($id)) { ?>
    <button type="button" class="btn btn-danger" onclick="deleteTime()">Delete</button>
    <script>

    function deleteTime() {
        if (confirm('Are you sure you want to delete this time?')) {
            location.href = 'delete-time.php?id=<?php echo isset($id) ? $id : '' ?>';
        }
    }

    </script>
<?php } ?>
</form>