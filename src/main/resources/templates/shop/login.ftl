<#include "../commons/top.ftl" encoding="utf-8" parse="true"/>
<form id="form1" name="form1" action="/account/login" method="post">

<table align="center" border="0">
    <tr>
        <td colspan="2">
            <font color="red">
            <#if lerror??>
                        ${lerror}
                    </#if>
            </font>
            <br />
            &nbsp;
        </td>
    </tr>
    <tr>

        <td>
            用户名：<input type="text" name="username" id="username"/>
        </td>
    </tr>
    <tr>

        <td>
            密&nbsp;码：<input type="text" name="password" id="password"/>
        </td>
    </tr>
    <tr>
        <td>
            <input type="image" border="0" src="/static/images/button_submit.gif" />
            <a href="/account/rmain">
                <img border="0"
                                              src="/static/images/button_register_now.gif" />
            </a>
        </td>

    </tr>
</table>
</form>

</center>
<#include "../commons/bottom.ftl" encoding="utf-8" parse="true"/>