# CSS
html을 이용하여 웹페이지 구조를 설계하고 **CSS**로 디자인적인 요소를 부여한다.

**1) 요소에 직접 적용하기**
	```<span style="font-weight: bold; color:blue"> 테스트 </span>```
	요소마다 css를 적용해줘야하기때문에 자주 사용하지 않는 방법

**2) head 태그 내 style 태그에 적용**
``` 
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
    	span {
    		font-weight: bold;
    		color:blue;
    	}
    </style>
</head>
```

**3) 별도의 CSS파일에 분리**
``` 
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" type="text/css" href="style.css"/>
</head>
```
```
span{
	font-weight: bold;
    color:blue;
}
```

## CSS 선택자
head의 **```style```** 태그 또는 분리된 css파일을 적용할때, 적용내용을 선택하는 방법

**선택자의 종류**
* ```tag```선택자
	문서 내 **모든 태그**에 적용
	
	```
	<span> 해당 문서에서 <span>태그를 이용하면 모든 글자는 파란색 입니다.</span>
	

	<div> 해당 문서에서 <div>태그를 이용하면 여백이 적용된 분홍 배경의 div입니다.</div>
	```

	```
	span{
		color:blue;
	}

	div{
		margin: 24px;
		padding: 48px;
		background-color: pink;
	}

	```



* ```class```선택자
	문서 내 **다수 요소에 동일하게 적용**하기 위해 class를 이용하여 정의하여 적용
	
	```html
	<h1 class="important">할 일 목록</h1>
	<ul>
		<li class="important">빨래</li>
		<li class="finished">30분 운동</li>
		<li>마트 장보기</li>
		<li class="finished">책 50페이지 이상 읽기</li>
		<li class="finished important">코딩 강좌 실습</li>	
	</ul>
	```
	```css
	.finished { color: skyblue; }
.important { text-decoration: underline; }
	
	/* 특정 태그에 해당 클래스에 추가로 내용을 적용하고 싶을 때 */
li.important { background-color: yellow; }
	
	/* 하나 이상의 클래스를 중첩해서 적용 */
	.important.finished { font-style: italic; }
	```



* ```id```선택자
	문서 내 **유일한** 요소에 적용되는 내용
	
	```html
	<section id="intro">
		소개 섹션
	</section>
	<section id="board">
		게시판 섹션
	</section>
	```
	
	```css
	section { padding: 32px; }
	
	/* 아래부터 */
	#intro { background-color: yellowgreen; }
	#board { background-color: pink; }
	```

* ```attr```선택자
	태그의 속성 값에 따라 적용
	```html
	<p>
		<input id="ip-male" type="radio" name="gender" value="M">남자    
		<input id="ip-female" type="radio" name="gender" value="F">여자
	</p>
	<p>
		<input id="ip-sns" type="checkbox" name="part" value="SNS">
		<label for="ip-sns">SNS</label>
		<input id="ip-msg" type="checkbox" name="part" value="message">
		<label for="ip-msg">메시지</label>
		<input id="ip-email" type="checkbox" name="part" value="email">
		<label for="ip-email">이메일</label>
	</p>
	```
	
	```css
	label{
		display: inline-block;
  	width: 80px;
	}

	label[for=ip-sns] { background-color: hotpink;}
	label[for=ip-msg] { background-color: skyblue;}
	label[for=ip-email] { 
    	background-color: blue;
    	font-style: italic;
	}
	```
	
	