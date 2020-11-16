# 기본적인 html 문법
웹 페이지의 화면을 표현하기 위해 정의된 문법. **<태그 속성="value">** 구조 형태   
   
   
### 기본 문법   
**```<html> </html>```**: html문서임을 표시하는 태그   

**```<head></head>```**: 문서정보를 표시할때쓰이는 tag로서, 화면에는 직접 출력되지 않으며 문서 정보등을 정의   

##### <head> 내부에 주로 들어가는 태그들: ```<title>, <meta>, <link>, <style>, <script>```   
* ```<title></title>```: 웹페이지의 제목   
* ```<meta>```: 웹페이지의 설명, 핵심 키워드, 제작자, 크롤링 정책등의 정보 등을 정의   
ex) 기본적으로 ```<meta name="속성 이름" content="속성 값">``` 형태로 사용됨

```
<head>
	<title>HTML 태그 study</title>
	<meta charset="utf-8"> <! 문자 인코딩 설정>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"> <! 엔진 설정>
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<meta name="description" content="태그에 대한 기본적인 문법을 알아보고 실습하는 페이지입니다."> <! 웹페이지에 대한 설명>
	<meta name="subject" content="기본적인 html tag study"> 
	<meta name="classification" content="html">
	<meta name="keywords" content="html,css,javascript"> <! 핵심키워드>
	<meta name="robots" content="ALL">
</head>
```   

* **```<body></body>```**: 웹페이지를 디스플레이할때 사용하는 tag   

### 문자 tag   
* ```<p></p>```: 문자를 적을 때 쓰는 태그(paragraph)   
* ```<h1></h1>```도 문자를 적을 때 쓰는 태그인데 문자의 크기가 정해져있음(h1 -> h6)   
* ```<br>```: 줄바꿈   
* ```<i></i>```: 이텔릭체   

### 입력 tag   
**```<form>```**: 웹페이지에서 입력 양식을 의미(login widget, 회원가입 form)   
* ```<name>```: 폼의 이름   
* ```<action>```: 폼의 데이터가 전송되는 서버 url   
* ```<method>```: 통신 방식(ex. GET, POST...)   

**```<input></input>```**: ```<form>```은 전체 양식을 의미하며 추상적인 태그, 실제로는 <input> 태그를 이용하여 구현.   
"type속성"을 이용하여 input의 종류를 나타내며, "name"을 통해 데이터의 이름, "value"를 통해 default 값 정의   

###### ex) 간단한 로그인 및 정보 입력 페이지   
```
<form>
	<p>
		<strong>아이디</strong>
		<input type="text" name="id" value="ID">
	</p>
	<p>
		<strong>비밀번호</strong>
		<input type="password" name="password" value="PWD">
	</p>
	<p>
		<strong>성별</strong>
		<input type="radio" name="gender" value="M">남자
		<input type="radio" name="gender" value="F">여자
	</p>
	<p>
		<strong>수신 설정</strong>
		<input type="checkbox" name="part" value="SNS">SNS
		<input type="checkbox" name="part" value="message">메시지
		<input type="checkbox" name="part" value="email">이메일
	</p>
	<p>
		<input type="submit" value="제출">
		<input type="reset" value="초기화">
	</p>
</form>
```


### 이미지 tag
**```<img src="image path"/ width="w value" height="h value">```**: 이미지를 표현할 때 사용   

### 링크 tag
**```<a></a>```**: 다른 사이트에 링크를 걸때 사용   
###### ex) ```<a href="https://www.naver.com"> 네이버 이동</a>```   

### 레이아웃 tag
layout을 나누는 태그. 코드상 가상의 레이아웃을 설계하는데 사용되며, 주로 css와 연동하여 사용   
* ```<div></div>```: display속성이 block, 줄바꿈
* ```<span></span>```: display속성이 inline, 줄바꿈 되지 않음

### 리스트 tag   
```<li></li>```: 목록을 만드는 태그로써 ```<ul></ul>```, ```<ol></ol>```와 같이 사용 됨.   
```<ol>```의 경우 ordering(순서가 매겨짐)이 적용되며, ```<ul>```의 경우 ordering되지 않음.   
