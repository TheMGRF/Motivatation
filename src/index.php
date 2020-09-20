<?php
include_once "partials/header.php";
?>

<div id="particles-js"></div>

<div id="cta">
    <img id="logo" src="../public/assets/img/logo_header_white.png">

    <h2>Motivate yourself with an immersive RPG experience!</h2>
    <h3>
        It's time to have fun when you get things done!
        <br>
        Join over 4 million people and improve your life one task at a time.
    </h3>
    <img height="256px" src="https://habitica.com/static/img/home-main@3x.23eeafe4.png">

    <a href="#"><p id="signup" >Sign Up</p></a>
</div>

<script src="../public/assets/js/particles.js"></script>
<script>
    particlesJS.load('particles-js', '../public/assets/js/particles.json', function() {
        console.log('callback - particles.js config loaded');
    });
</script>

<?php
include_once "partials/footer.php";
?>