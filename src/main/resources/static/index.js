  $(document).ready(function() {
      
    $('#btnCheck').click(function (e) {

      e.preventDefault();

      let id = $('#txtId').val();

      $.ajax({
        type: "get",
        url: "http://localhost:8080/users/" + id,
        dataType: "json",
        success: function (response) {
          
        },
        error: function (response) {
          
        }
      });
      
    });

});