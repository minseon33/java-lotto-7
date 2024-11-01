# java-lotto-precourse

## 과제 진행 요구사항

---
- 미션은 로또 저장소를 포크하고 클론하는 것으로 시작한다.
- 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
  - AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 기능 요구사항

---
간단한 로또 발매기를 구현한다.
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
### 입출력 요구사항
입력
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
~~~
14000
~~~
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
~~~
1,2,3,4,5,6
~~~
- 보너스 번호를 입력 받는다.
~~~
7
~~~

출력
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
~~~
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
~~~

---
### 필요 기능 정리
- [ ]  로또 구입금액 입력기능:
    - [ ]  구입금액 유효성 검증기능
        - 구입금액이 1000원 단위어야 한다.
        - 구입금액이 숫자여야 한다. (공통)
        - 구입금액이 양수여야 한다. (공통)
        - 입력이 잘못되었으면 구입금액을 다시 입력받아야 한다.
- [ ]  당첨번호 입력기능
    - [ ]  당첨번호 입력 유효성 검증
        - 당첨번호 입력이 숫자여야 한다. (공통)
        - 당첨번호가 중복되면 안된다.
        - 당첨번호는 1 ~ 45 사이의 값이어야 한다. (공통)
        - 번호는 쉼표를 기준으로 구분되어야 한다.
        - 입력이 잘못되었으면 당첨번호를 다시 받아야 한다.
- [ ]  보너스 번호 입력기능
    - [ ]  보너스 번호 입력 유효성 검증
        - 보너스 번호는 당첨번호와 겹치면 안된다.
        - 보너스 번호는  1 ~ 45 사이의 값이어야 한다.
- [ ]  로또번호 발행 기능
    - [ ]  금액에 따른 로또발행 수 계산 기능
    - [ ]  로또 번호 발행
- [ ]  당첨 번호 추첨기능
    - [ ]  발행 된 로또번호와 당첨번호 비교기능
    - [ ]  당첨된 숫자 개수 계산 기능
- [ ]  당첨 계산기능
    - [ ]  몇등에 당첨 되었는지 계산기능
- [ ]  수익률 계산기능
    - [ ]  당첨 금액 계산기능
- [ ]  발행된 로또번호 출력기능
- [ ]  당첨된 로또통계 출력기능
- [ ]  수익률 출력기능

---
