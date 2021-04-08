# Memo

자바를 공부하고 궁금했던 혹은 알아야할 사항들 메모

## interface

1. interface에 private 추상 메서드는 생성 안되나?

1. interface의 변수는 private으로 선언 안되나?

1. interface의 static 메서드는 인스턴스 생성 없이 사용 되나?
    - `MyInterface.func();` 인스턴스 생성 안하고 interface의 static method 호출 가능하다

1. interface에 abstract 메서드는 없고 default 메서드만 있으면 인스턴스 생성 가능?

1. Java에서 왜 두 개 이상 클래스 상속 못해?


## Map


java Map의 get과 containsKey 메소드로 key값의 존재 유무를 판단하는데 쓸 수 있다. 그런데 둘 중 어떤 것이 더 좋을까..?


    key값이 무조건 존재하는 경우, map.get(key);
    결과 : 358 211 191 172 153 133 176 123 126 158 193 171 130 130 148 135 138 171 185 207 185 123 111 115 126 112 112 124 113 114 113 115 113 114 113 116 117 115 110 111 114 111 112 112 115 117 111 112 113 126 

    평균 : 138

    key값이 무조건 존재하는 경우, map.containsKey(key);
    결과 : 262 242 275 189 225 136 182 139 170 131 135 116 142 111 134 194 190 161 129 134 137 126 137 189 154 193 184 119 109 123 125 143 151 146 117 112 118 114 141 170 183 160 125 137 117 114 110 118 129 124 

    평균 : 150

    존재하지 않는 key값도 찾는 경우, map.get(key);
    결과 : 437 423 351 189 230 186 200 184 206 178 198 183 188 185 183 181 180 177 179 187 187 184 183 182 184 177 182 181 177 199 249 213 181 179 180 182 190 180 180 188 201 193 180 181 181 181 190 184 185 181 

    평균 : 200

    존재하지 않는 key값도 찾는 경우, map.containsKey(key);
    결과 : 425 296 283 225 265 201 219 183 206 201 204 202 205 331 270 185 180 181 187 202 214 207 207 228 218 198 176 184 210 204 207 216 202 218 192 194 187 176 386 458 232 218 266 364 276 179 205 182 183 188 

    평균 : 228


결론 : get 메소드가 아주 약간 빠르다!