<?php

$name = '';
$artist = '';
$genre = '';
$album = '';
$year = '';
$spot_id = '';
$length = '';
$explicit = '';
$features = '';

if (isset($id))
{
    $connection = get_database_connection();

    $sql =<<<SQL
    SELECT *
      FROM songs
      WHERE son_id = $id
    SQL;

    $result = $connection->query($sql);
    $row = $result->fetch_assoc();

    $name = $row['son_name'];
    $artist = $row['son_artist'];
    $genre = $row['son_genre'];
    $album = $row['son_album'];
    $year = $row['son_year'];
    $spot_id = $row['son_spotlink'];
    $length = $row['son_length'];
    $explicit = $row['son_explicit'];
    $features = $row['son_features'];

}

?>
<form action="save-song.php" name="detailform" id="detailform">
    <input type="hidden" class="form-control" id="id" name="id" value="<?php echo isset($id) ? $id : '' ?>" />

    <div class="mb-3">
        <label for="name" class="form-label">Name*</label>
        <input type="text" class="form-control" id="name" name="name" value="<?php echo $name ?>" />
    </div>

    <div class="mb-3">
        <label for="artist" class="form-label">Artist*</label>
        <input type="artist" class="form-control" id="artist" name="artist" value="<?php echo $artist ?>" />
    </div>

    <div class="mb-3">
        <label for="features" class="form-label">Features</label>
        <input type="features" class="form-control" id="features" name="features" value="<?php echo $features ?>" />
    </div>

    <div class="mb-3">
        <label for="genre" class="form-label">Genre</label>
        <select class="form-select" name="genre">
            <option <?php echo $genre == 'Rock' ? 'selected' : '' ?>>Rock</option>
            <option <?php echo $genre == 'Metal' ? 'selected' : '' ?>>Metal</option>
            <option <?php echo $genre == 'Rap' ? 'selected' : '' ?>>Rap</option>
            <option <?php echo $genre == 'Pop' ? 'selected' : '' ?>>Pop</option>
            <option <?php echo $genre == 'Country' ? 'selected' : '' ?>>Country</option>
            <option <?php echo $genre == 'Hip Hop' ? 'selected' : '' ?>>Hip Hop</option>
        </select>
    </div>

    <div class="mb-3">
        <label for="album" class="form-label">Album</label>
        <input type="text" class="form-control" id="album" name="album" value="<?php echo $album ?>" />
    </div>

    <div class="mb-3">
        <label for="explicit" class="form-label">Explicit</label>
        <select class="form-select" name="explicit">
            <option <?php echo $explicit == 'Clean' ? 'selected' : '' ?>>Clean</option>
            <option <?php echo $explicit == 'Explicit' ? 'selected' : '' ?>>Explicit</option>
        </select>
    </div>

    <div class="mb-3">
        <label for="length" class="form-label">Length</label>
        <input type="text" class="form-control" id="length" name="length" value="<?php echo $length ?>" />
    </div>

    <div class="mb-3">
        <label for="year" class="form-label">Year</label>
        <input type="number" class="form-control" id="year" name="year" value="<?php echo $year ?>" />
    </div>

    <div class="mb-3">
        <label for="spot_id" class="form-label">Spotify</label>
        <input type="text" class="form-control" id="spot_id" name="spot_id" value="<?php echo $spot_id ?>" />
    </div>

    <button type="submit" class="btn btn-primary">Save</button>
    <script>
        function dataValidation(){
            name = document.getElementById("name").value;
            artist = document.getElementById("artist").value;
            if(name == ''|| artist == ''){
                alert("The name and artist fields must be completed")
            } else {
                alert("heres hopin")
                document.getElementById("detailForm").action = 'save-song.php';
            }
            }
    </script>
        
    <a href="index.php?content=movie-list" class="btn btn-secondary" role="button" aria-disabled="true">Cancel</a>
<?php if (isset($id)) { ?>
    <button type="button" class="btn btn-danger" onclick="deleteMovie()">Delete</button>
    <script>
    

    function deleteMovie() {
        if (confirm('Are you sure you want to delete this movie?')) {
            location.href = 'delete-song.php?id=<?php echo isset($id) ? $id : '' ?>';
        }
    }

    </script>
<?php } ?>
</form>