<%-- 
    Document   : page_for_authorized_users
    Created on : 19.12.2017, 7:41:44
    Author     : Denis
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title>Страница с авторизацией</title>
	<link rel="stylesheet" href="style.css" type="text/css"  />
</head>

<body>

<div class="enter">
    <nav>
        <ul>
            <li><a href="#">Выйти</a></li>
            <li class=""><a href="#">Корзина</a></li>
        </ul>
    </nav>
</div>    
    
<table class="simple-little-table" cellspacing='0'>
	<tr>
        <th></th>
		<th>А92</th>
		<th>А95</th>
		<th>А95+</th>
        <th>ДТ</th>
        <th>ДТ+</th>
        <th>ГАЗ</th>
	</tr>
    
	<tr>
		<td>Neftek</td>
		<td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
		<td></td>
	</tr>
	
	<tr>
		<td>Авиас</td>
		<td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
		<td></td>
	</tr>

	<tr>
		<td>OKKO</td>
		<td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
		<td></td>
	</tr>
	
	<tr>
		<td>WOG</td>
		<td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
		<td></td>
	</tr>
    
</table>

<select>
    <option>Товар</option>
    <option>Neftec</option>
    <option>Авиас</option>
    <option>ОККО</option>
    <option>WOG</option>
</select>
<select>
    <option>Тип</option>
    <option>А92</option>
    <option>А95</option>
    <option>А95+</option>
    <option>ДТ</option>
    <option>ДТ+</option>
    <option>ГАЗ</option>
</select>
<select>
    <option>Кол-во</option>
    <option>20</option>
    <option>40</option>
    <option>60</option>
    <option>80</option>
    <option>100</option>
</select>
    
<span>Цена</span>
<span><a href="#" class="button_bue">Купить</a></span>    
    
</body>
</html>
