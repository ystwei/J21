


<#include "../commons/top.ftl" encoding="utf-8" parse="true"/>
<table border="0" width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td valign="top" width="20%" align="left">
			<table align="left" bgcolor="#008800" border="0" cellspacing="2"
				cellpadding="2">
				<tr>
					<td bgcolor="#FFFF88">
						<a href="main.xhtml"><b><font color="BLACK" size="2">&lt;&lt; 主菜单</font>
				</b></a>
					</td>
				</tr>
			</table>
		</td>
		<td valign="top" align="center">
			<h2 align="center">
				购物车
			</h2>
			<form name="form1" method="post"action="/cat/update">
				
				<table align="center" bgcolor="#008800" border="0" cellspacing="2"
					cellpadding="5" >
					<tr bgcolor="#cccccc">
						<td>
							项目编号
						</td>
						<td>
							产品编号
						</td>
						<td>
							产品描述
						</td>
						<td>
							<b>项目描述</b>
						</td>
						<td width="100">
							单价
						</td>
						<td>
							数量
						</td>
						<td>
							合计
						</td>
						<td>
							&nbsp;
						</td>
					</tr>

			
					<#assign total=0/>
					<#assign oid=""/>
					<#list clist as cart>
					
					<tr bgcolor="#FFFF88">
						<td>
							<b> 
							
							<input type="hidden" name="iid" value="${cart.item.itemid}">
							<input type="hidden" name="oid" value="${cart.orderid?c}">
								<#assign oid="${cart.orderid?c}"/>
							<a href="">${cart.item.itemid}</a>
							
							</b>
						</td>
						<td>
							${cart.item.productid}

						</td>
						<td>

							<img src="/static/images/${cart.item.product.pic}">

						</td>
						<td align="center">
						${cart.item.product.descn}
							
						</td>
						<td>
							${cart.item.listprice}


						</td>
						<td align="right">
							<input type="number" name="qty" value="${cart.quantity}">


							<br/>
						</td>
						<td align="right">
							${cart.item.listprice*cart.quantity}
							<#assign total=cart.item.listprice*cart.quantity+total/>
						</td>
						<td>
							<a href="/cat/del/itemid/${cart.item.itemid}/oid/${cart.orderid?c}"><img border="0"
									src="/static/images/button_remove.gif" />
							</a>
						</td>
					</tr>
					</#list>
					
			
					<tr bgcolor="#FFFF88">
						<td colspan="7" align="right">
							<b>
								总计:${total}
							</b>							
							
						</td>
						<td>
                            <input type="image"
                                                              src="/static/images/button_update_cart.gif" />

						</td>
					</tr>
				</table>
				<center>


				</center>
			</form>


			<br />
			<center>
				<a href="/cat/checkout/oid/${oid}/total/${total}"><img border="0"
						src="/static/images/button_checkout.gif" />
				</a>
			</center>


		</td>




	</tr>
</table>

<br>
<#include "../commons/bottom.ftl" encoding="utf-8" parse="true"/>