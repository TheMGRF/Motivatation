<?php
include_once "partials/header.php";
?>

<div id="particles-js"></div>

<div class="mobile-seperator">
    <hr>
</div>

<div id="cta">
    <img class="logo" src="../public/assets/img/logo_header_white.png" alt="Motivatation Logo">

    <h2>Motivate yourself with an immersive RPG experience!</h2>
    <h3>
        It's time to have fun when you get things done!
        <br>
        Join over 4 million people and improve your life one task at a time.
    </h3>
    <img id="cta-icon" src="../public/assets/img/cta-icon.png" alt="Motivatation CTA Icon">

    <a href="#signup"><p id="signup" >Sign Up</p></a>
</div>

<script src="../public/assets/js/particles.js"></script>
<script>
    particlesJS.load('particles-js', '../public/assets/js/particles.json', function() {
        console.log('[INFO] Particles loaded successfully!');
    });
</script>

<?php
include_once "partials/footer.php";
?>