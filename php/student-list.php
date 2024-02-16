<!DOCTYPE html>
<html>
    <head>

    </head>

    <body>
        <h1>Welcome to Sample School District</h1>

        <h2>Studnet Enrollment</h2>

        <p>Filter by last name starting with
            <a href="student-list.php?">All</a>

<?php
for ($i = 0; $i < 26; $i ++){
    $letter = chr($i + ord("A"));
    echo "<a href='student-list.php?last_name=$letter'>$letter</a> ";
}
?>
            <br>
            Filter by first name contains
            <form action="student-list.php">
                <input type="text" name="first_name">
                <input type="submit" value="Filter">
            </form>
            <br>

            Year of Graduation

            
        </p>

        <table border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>YOG</th>
                <th>Guidance Counselor</th>
                <th>Homeroom</th>
            </tr>
<?php
$servername = "localhost";
$username = "root";
$password = "123-4304";
$dbname = "sis";

$connection = new mysqli($servername, $username, $password, $dbname);
if ($connection->connect_error)
{
    die("Connection failed: " . $connection->connect_error);
}

extract($_REQUEST);

$sql = "SELECT stu_first_name, stu_last_name, stu_yog FROM students ";

if(isset($first_name))
{
    $sql .= "WHERE stu_first_name LIKE '%$first_name%' ";
}

if (isset($last_name))  
{
    $sql .= "WHERE stu_last_name LIKE '$last_name%' ";
}

$sql .= " ORDER BY stu_last_name, stu_first_name ";

$result = $connection->query($sql);
while($row = $result->fetch_assoc())
{
    echo "<tr>";
    echo "<td>" . $row['stu_first_name'] . "</td>";
    echo "<td>" . $row['stu_last_name'] . "</td>";
    echo "<td>" . $row['stu_yog'] . "</td>";
    echo "<td>" . $row['stu_counselor'] . "</td>";
    echo "<td>" . $row['stu_homeroom'] . "</td>";
    echo "</tr>";
}

?>
        </table>
    </body>
</html>