$(".delete-user").each(function () {
    $(this).on('click', function () {
        const id = $('.delete-user').val();
        console.log(id);
        $.ajax({
            "url": '/owner-edit-details?id='+id,
            "method": 'DELETE',
            "success": function () {
                alert('user succesfully deleted');
                location.reload();

            },
            "error": function (error) {
                alert(error);

            }
        })

    })

})