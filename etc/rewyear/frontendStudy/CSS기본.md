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
	
## 결합자
```html
  <div class="outer">
    <div>
      <div>
        <div></div>
      </div>
    </div>
    <div>
      <div></div>
      <div></div>
    </div>
  </div>
```

## 결합자
**자손결합자**   
	내부의 모든 요소들을 선택   
	
	```css
	div {
	  padding: 24px;
	  border: 1px solid black;
	  background-color: white;
	}

	.outer { background-color: green; }

	/* 앞 선택자 뒤에 스페이스를 둠으로써 자손 요소들을 선택*/
	/* outer 클래스 내부의 모든 div에 적용*/
	.outer div {
	  background-color: yellow;
	}
	```


**자식결합자**   
	바로 안 단계의 요소들에게만 적용   
	
	```css
	  /* 빈 공백이 아닌 > 을 넣어주면 자식(1촌 자손)만 선택 */
	  .outer > div {
	    background-color: yellow;
	  }
	```

**인접 형제 결합자**   
	바로 다음 요소에 적용   
	
	```html
		<div>첫줄</div>
  		<div>둘째줄</div>
  		<div class="selected">선택된 줄</div>
  		<div>넷째줄</div>
  		<div>다섯째 줄</div>
	```
	
	```css
	div {
	  padding: 12px 24px;
	  border-top: 1px solid black;
	}
	.selected {
	  border-top: 0;
	  color: white;
	  background-color: dodgerblue;
	}

	/* 아래부터 */
	.selected + div { border-top: 0; }
	```

**전체 선택자**   
	모든 태그에 적용
	```html
	  <section>
	    <h1>제목</h1>
	    <span>span 요소</span>
	    <div>
	      요소
	      <div>더 안쪽 요소</div>
	    </div>
	    일반 텍스트
	  </section>
	```

	```css
	div { background-color: white; }

	/* 특정 요소의 자손/자식으로 지정하지 않으면 body 등에도 적용 */
	section * {
	  display: inline-block;
	  background-color: orange;
	  padding: 24px;
	}
	```

## 가상 클래스   

**부정 가상 클래스**   
```html
  <h1 class="underline">부정 가상 클래스 사용예</h1>
  <ul>
    <li>특성 없음</li>
    <li class="blue">파랑글씨</li>
    <li class="blue underline">파랑글씨에 및줄</li>
    <li class="underline">파랑글씨는 아닌데 및줄</li>
  </ul>
```

```css
.blue { color: blue; }
.underline { text-decoration: underline; }

/* 아래부터 */
.underline:not(.blue) { color: red; }
.underline:not(.blue):not(li) { color: inherit; }
```

**순서 가상 클래스**   
태그에 :x-child를 통해 순서로 접근이 가능    

```html
  <ul>
    <li>첫번째 글</li>
    <li>두번째 글</li>
    <li>세번째 글</li>
    <li>네번째 글</li>
    <li>다섯번째 글</li>
    <li>여섯번째 글</li>
    <li>일곱번째 글</li>
    <li>여덟번째 글</li>
  </ul>
```

```css
ul { padding: 0; }
ul li {
  list-style: none;
  padding: 8px 16px;
  border-top: 1px solid lightgray;
}

ul li:first-child { border-top: 2px solid black; }
ul li:last-child { border-bottom: 2px solid black; }
ul li:nth-child(3) { color: purple; }
ul li:nth-child(even) { background-color: #eee; }
ul li:nth-child(3n+1) { text-decoration: underline; }
```

**마우스오버 가상클래스**    
해당 태그 객체에 마우스가 오버레이될떄 효과를 줄수 있음   

```html
  <button class="blue-button">
    클릭
  </button>

  <br><br>

  <div>
    파일
    <ul>
      <li>저장</li>
      <li>열기</li>
      <li>닫기</li>
    </ul>
  </div>
```
```css
.blue-button {
  font-size: 1em;
  padding: 16px 24px;
  color: white;
  background-color: dodgerblue;
  border: 0;
  cursor: pointer; // 오버레이 됬을때 마우스커서 
  border-radius: 4px;
}
.blue-button:hover {
  background-color: darkblue;
}

div {
  position: relative; display: inline-block;
  color: white; background-color: tomato;
  height: 56px; line-height: 56px; padding: 0 24px;
  cursor: pointer;
}
div ul {
  display: none;
  position: absolute;
  width: 100px; left: 12px; top: 56px; margin: 0; padding: 0;
}
div:hover ul { display: block; }


div ul li {
  background-color: #444;
  height: 44px; line-height: 44px; text-align: center;
}
div ul li:hover { background-color: #222; }

```
