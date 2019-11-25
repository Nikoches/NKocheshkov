<#import "parts/common.ftlh" as c>
<@c.page>
    List of Users
    <table>
        <thead>
        <tr>
            <th> Name</th>
            <th>Role</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>

            <tr>
                <td>${user.getUsername()}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list> </td>
                <td><a href="/user/${user.id}"> edit </a></td>
            </tr>
        </#list>

        </tbody>

    </table>
    <strong><a href="/main"> BACK to MAIN </a></strong>
</@c.page>