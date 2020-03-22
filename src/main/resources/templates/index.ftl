<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Список опозданий за неделю</h1>
    <#list users as employee>
        <h3>${employee.getFullname()}<h3>

            <table>
            <#-- Шапка таблицы -->
                <tr>
                    <th>Время прихода</th>
                    <th>Время ухода</th>
                </tr>
            <#assign factShedules = employee.getWorkingDays()>

            <#-- Поля таблицы -->
                <#list factShedules as factShedule>
                    <tr>
                        <td>${factShedule.getStart()?string("dd/MM/yyyy HH:mm:ss")}</td>
                        <td>${factShedule.getEnd()?string("dd/MM/yyyy HH:mm:ss")}</td>
                    </tr>
                </#list>
            </table>

    </#list>
</body>
</html>