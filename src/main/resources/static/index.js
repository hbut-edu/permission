let baseURL = "http://localhost:8080/";

function dataToHtml(permissions, listPermissions) {

  listPermissions.empty();

  permissions.forEach(permission => {

    let permissionHtml = $("#templatePermission").clone();

    permissionHtml.find(".header")[0].innerText = permission.department.name;
    permissionHtml.find(".description")[0].innerText = permission.permissionType;

    listPermissions.append(permissionHtml);

  });
}

$(document).ready(function () {

  $('#btnCheck').click(function (e) {
    e.preventDefault();

    let id = $('#txtId').val();

    if(id == undefined || id == null || id == NaN || id.trim() == ""){
      $("#message").text('Please enter your id.');
      return false;
    }

    $.ajax({
      type: "get",
      url: baseURL + "user/" + id,
      dataType: "json",
      success: function (user) {

        dataToHtml(user.permissions, $("#listPermissions"));

      },
      error: function (response) {
        $("#message").text(response.responseJSON.message);
      }
    });

  });

  $('.ui.form')
    .form({
      fields: {
        id: {
          identifier: 'txtFormId',
          rules: [
            {
              type: 'empty',
              prompt: 'Please enter your id.'
            }
          ]
        }
      },
      onSuccess: function (e) {
        e.preventDefault();

        let id = $('#txtFormId').val();

        $.ajax({
          type: "get",
          url: baseURL + "user/" + id,
          dataType: "json",
          success: function (user) {

            dataToHtml(user.permissions, $("#listFormPermissions"));

          },
          error: function (response) {
            console.log(response);
          }
        });
      }
    });

});