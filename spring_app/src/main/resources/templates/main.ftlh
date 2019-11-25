<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>
        <@l.logout />
    </div>
    <div>

    </div>
    <div>
        <a href="/user"> <span>UserList</span></a>
    </div>
    <div>

    </div>
    <div>
        <form method="post" enctype="multipart/form-data">
            <input type="text" name="text" placeholder="Введите сообщение" />
            <input type="text" name="tag" placeholder="Тэг">
            <input type="file" name="file">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
    <div>Список сообщений</div>
    <form method="get" action="/main">
        <label>
            <input type="text" name="filter" value="${filter}">
        </label>
        <button type="submit">Найти</button>
    </form>
    <#list messages as message>
        <div>
            <strong>${message.authorName}</strong>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <#if message.time??>
                <span>  ${message.time}</span>
            </#if>
            <div>
                <#if message.filename??>
                    <img src="/img/${message.filename}">
                </#if>
            </div>
        </div>
    <#else>
        No message
    </#list>
</@c.page>