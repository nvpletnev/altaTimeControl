<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Список опозданий за неделю</h1>
    <#list users as user>
        <h3>${user.getFullname()}<h3>

            <table>
            <#-- Шапка таблицы -->
                <tr><th>Время прихода</th></tr>
                <tr><th>Время ухода</th></tr>

            <#assign factShedules = user.getFactWeeklyShedule()>

            <#-- Поля таблицы -->
                <#list factShedules as factShedule>
                    <tr>
                        <td>${factShedule.getStartTime()?string("dd/MM/yyyy HH:mm:ss")}</td>
                        <td>${factShedule.getEndTime()?string("dd/MM/yyyy HH:mm:ss")}</td>
                    </tr>
                </#list>
            </table>

    </#list>
</body>
</html>