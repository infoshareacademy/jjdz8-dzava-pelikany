<footer class="bg-light py-5">
    <div class="container"><div class="small text-center text-muted">DzavaApp prod. DzavaPelikany - Copyright© ${.now?string('yyyy')}</div></div>
</footer>
<script
        src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"
></script>

<script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"
></script>

<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"
></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $('#myMenu').click(function() {
        window.location = "/owner-menu";
    });
    $('#myRooms').click(function() {
        window.location = "/owner-rooms";
    });
    $('#addRoom').click(function() {
        window.location = "/owner-add-room";
    });
    $('#EditMyData').click(function() {
        window.location = "/owner-edit-details";
    });
    $('#HomepageAfterLogin').click(function() {
        window.location = "/homepage-after-login";
    });
</script>

<script>
    $('.rmv').click(function removeRoom() {
        $.ajax({url: '/owner-rooms?roomid='+$(this).data('roomid'), method: "DELETE"})
            .then( function () {
        location.reload();
            })
        .catch(function (err) {
            console.log(err)
        })
    });
</script>

<script>
    $('.subedt').click(function editRoom() {
        $.ajax({url: '/owner-edit-room?editRoomId='+$(this).data('roomid'), method: "PUT", data:$("#editForm").serialize()})
            .then( function () {
                location.href="/owner-rooms";
            })
            .catch(function (err) {
                console.log(err)
            })
    });
</script>
<script>
    $('.edt').click(function goToRoomEdit() {

                location.href="/owner-edit-room?editRoomId="+$(this).data('roomid');

    });
</script>
<script>
    $('.rnt').click(function rentRoom() {
        $.ajax({url: '/owner-rooms?rentRoomId='+$(this).data('roomid'), method: "PUT", data:$("#rentForm").serialize()})
            .then( function () {
                location.reload();
            })
            .catch(function (err) {
                console.log(err)
            })
    });
</script>