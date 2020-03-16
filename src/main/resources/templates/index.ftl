<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>UsersList</h1>
    <table>
        <tr>
            <th>Fullname</th>
            <th>Tabnum</th>
        </tr>
            <#list users as user>
                <tr>
                    <td>${user.getFullname()}</td>
                    <td>${user.getTabNum()}</td>
                </tr>
            </#list>
    </table>
</body>
</html>