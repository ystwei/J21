


<#include "../commons/top.ftl" encoding="utf-8" parse="true"/>


<table align="left" bgcolor="#008800" border="0" cellspacing="2"
	cellpadding="2">
	<tr>
		<td bgcolor="#FFFF88">
			<a href="viewcategory.xhtml">
			
			</a>
		</td>
	</tr>
</table>

<p>

	<center>
		<h2>
			项目信息
		</h2>
	</center>

	<table align="center" bgcolor="#008800" border="0" cellspacing="2" cellpadding="3">
		<tr bgcolor="#CCCCCC">
			<td>
				项目编号
			</td>
			<td>
				产品编号
			</td>
			<td>
				产品名称
			</td>
			<td>
				单价
			</td>
			<td>
				描述
			</td>
            <td>
                &nbsp;
            </td>
		</tr>
		<#list plist as item>
		<tr bgcolor="#FFFF88">
			<td>
				<b> <a href="/pet/query/cat/null/pro/null/item/${item.itemid}">${item.itemid}</a>
				</b>
			</td>
			<td>
					${item.product.productid}
			</td>
			<td>
					${item.product.name}
			</td>
			<td>
					${item.listprice}
			</td>
            <td>
				${item.attr1}
            </td>
			<td>
				<a href="cartmain.xhtml"><img border="0"
						src="/static/images/button_add_to_cart.gif" />
				</a>
			</td>
		</tr>
		</#list>
		

		<tr>
			<td bgcolor="#FFFFFF" colspan="2">


			</td>
		</tr>
	</table>
<#include "../commons/bottom.ftl" encoding="utf-8" parse="true"/>