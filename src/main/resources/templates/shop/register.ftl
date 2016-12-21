<#include "../commons/top.ftl" encoding="utf-8" parse="true"/>
<br/>
<form name="form1" id="form1" action="/account/reg" method="post" commandName="account">
	<TABLE cellpadding=10 cellspacing=0 align=center border=1 width="400"
		bgcolor=#dddddd>
		<TR>
			<TD>
				<FONT color=darkgreen>
					<H3>
						基本信息
					</H3>
				</FONT>
				<TABLE border=0  bgcolor=#FFFF88  width="100%">
					<TR bgcolor=#FFFF88>						
						<TD>
						 	用户名：<input type="text" id="username" name="username"/>
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>
						
						<TD>
                            密&nbsp;码：<input type="text" id="password" name="password"/>
							
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>
						
						<TD>
                            校密码：<input type="text" id="repassword" name="repassword"/>
							
						</TD>
					</TR>
				</TABLE>





				<FONT color=darkgreen><H3>
							附加信息
					</H3>
				</FONT>

				<TABLE bgcolor="#FFFF88" border=0 
					bgcolor=#FFFF88 width="100%">
					<TR bgcolor=#FFFF88>
						
						<TD>
                            邮&nbsp;箱：<input type="text" id="email" name="email"/>
						</TD>
					</TR>
					
					<TR bgcolor=#FFFF88>
						
						<TD>
                             姓&nbsp;名：<input type="text" id="xm" name="xm"/>
						</TD>
					</TR>
					
					<TR bgcolor=#FFFF88>
						
						<TD>
                            地&nbsp;址：<input type="text" id="address" name="address"/>
							
						</TD>
					</TR>
					
					
				</TABLE>


				<FONT color=darkgreen><H3>
						 爱好设置
					</H3>
				</FONT>

				<TABLE bgcolor="#FFFF88" border=0 cellpadding=3 cellspacing=1 width="100%">
					<TR bgcolor=#FFFF88>
						
						<TD>
                            语&nbsp;种：
							<select id="lan" name="profile.lang">
								<option value="eng">英语</option>
                                <option value="chi">中文</option>

							</select>
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>
						
						<TD>
                            宠&nbsp;物：
							<select id="catid" name="profile.catid">
								<#list clist as category>
								    <option value="${category.catid}">
										${category.name}

									</option>


								</#list>

							</select>
						</TD>
					</TR>
					
				</TABLE>
	</TABLE>
    <BR>
    <CENTER>
        <input border=0 type="image" src="/static/images/button_submit.gif" />
    </CENTER>
</form>


<#include "../commons/bottom.ftl" encoding="utf-8" parse="true"/>