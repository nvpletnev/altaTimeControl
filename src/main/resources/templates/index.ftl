<!DOCTYPE html>
<html lang="en">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  </head>

  <body>
      <div class="container-fluid mb-2">
        <nav class="navbar navbar-dark bg-dark">
          <span class="navbar-brand mb-0 h1"><h1>Список опозданий за неделю</h1></span>
        </nav>
      </div>

        <div class="container-fluid">
          <table class="table table-striped">
            <thead class="thead-dark">
              <tr>
                <th><h3>ФИО</h3></th>
                <#list week as day>
                <th><h3><p class="text-center">${day}</p></h3></th>
                </#list>
              </tr>
            </thead>
            <tbody>
              <#list users as user>
              <tr>
                <th><h3><p class="text-uppercase">${user}</p></h3></th>

                <#list week as day>
                <td>
                  <#if user.hasLateForDay(day)>
                  <#assign late = user.getLateForDay(day)>
                  <h2><p class="text-center">
                    ${late.getStartTime()?string("HH:mm")} - ${late.getEndTime()?string("HH:mm")}
                  </p></h2>
                  <#elseif user.hasAbsenteesmForDay(day)>
                  <h3><p class="text-danger text-center">Нет отметки</p></h3>
                  <#else>
                  <h3><p class="text-center">--</p></h3>
                  </#if>
                </td>
                </#list>

              </tr>
              </#list>
            </tbody>
          </table>
          <#list users as employee>
          </#list>
      </div>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>
