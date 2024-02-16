<!DOCTYPE html>
<html>
    <head>

    </head>

    <body>
        
        <?php
        echo "<h1>Welcome to PHP</h1>";
        echo "<br>";
        echo "It's a great language to know";
        echo "<br><br>";
        echo "<h2>Hello World</h2>";

        // String concatenation
        $name = "Jeremy";
        echo "Hello " . $name . "! (with concatenation)";
        echo "<br>";

        // string interpolation (only works with double quotes)
        echo "Hello $name! (with interpolation)";
        echo "<br>";
        echo 'Hello $name!';
        echo "<br><br>";

        // math
        $x = 5;
        $y = 3;
        echo "$x * $y =" . ($x * $y);
        echo "<br>";

        function square($number){
            return $number * $number;
        }

        echo "4 squared is " . square(4);
        ?>

    </body>
</html>