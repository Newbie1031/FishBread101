# 심화 프로젝트 - 붕어빵 101
- 강의를 등록하고 수강할 수 있는 API 구현
---
## 프로젝트 소개
- 튜터와 학생을 강의로 연결 해주는 클래스101에서 아이디어를 얻어 만들었습니다.
---
## 개발 기간
- **23.01.16 - 23.01.20**
1. **01.16**
- API 설계
- 엔티티 연관 관계 설정
- 기능별 Contorller 추가
2. **01.17 - 01.18**
- 기능별 Service 로직 추가
- DTO 추가
- 기능별 Repository 추가
- 쿼리문 작성
3. **01.19**
- 미완성 기능 구현
- 전체 코드 리뷰
- 코드 리팩토링
4. **01.20**
- 시연 영상 녹화
- 발표 자료 작성
- README 작성
---
## 개발 환경
- **IDE** : `IntelliJ IDEA 2022.3.1 Ultimate Edition`
- **Language** : `Java 11`
- **Framework** : `Spring boot 2.7.7`
- **Database** : `H2 Database`
- **ORM** : `JPA`, `Hibernate`
---
## 주요 기능
1. 회원가입
2. 로그인
3. 로그아웃
4. 토큰
---
### 학생
1. 프로필 작성 : 닉네임, 이미지, 설명글 작성
2. 프로필 조회 : 작성한 프로필 정보를 조회
3. 강의 목록 조회 : 전체 강의 목록을 페이징하며 조회
4. 튜터 목록 조회 : 전체 튜터 목록을 페이징하며 조회
5. 튜터 정보 조회 : 튜터의 프로필 정보를 조회 
6. 수강 신청 : 선택한 강의에 수강을 신청
7. 튜터 권한 요청 : 관리자에게 튜터 권한을 요청
---
### 튜터
1. 프로필 작성 : 닉네임, 이미지, 설명글 작성
2. 프로필 조회 : 작성한 프로필 정보를 조회
3. 강의 등록 : 강의 정보를 작성하여 목록에 등록
4. 강의 목록 조회 : 진행 중인 강의 목록을 페이징하며 조회
5. 강의 수정 : 강의 정보를 작성하여 목록에서 수정
6. 강의 삭제 : 강의 정보를 작성하여 목록에서 삭제
7. 수강 신청 승인 : 학생의 수강 신청을 승인
8. 수강 신청 거절 : 학생의 수강 신청을 거절
9. 강의 등록 학생 목록 조회 : 강의에 등록한 학생 목록을 페이징하며 조회
---
### 관리자
1. 학생 목록 조회 : 전체 학생 목록을 페이징하며 조회
2. 튜터 목록 조회 : 전체 튜터 목록을 페이징하며 조회
3. 튜터 권한 요청 목록 조회 : 전체 튜터 권한 요청 목록을 조회
4. 튜터 권한 승인 : 튜터 권한 요청을 승인
5. 튜터 권한 거절 : 튜터 권한 요청을 거절
