# 인사평가 시스템_Pesonal_Project

---

## 개발 언어

- Java
- SQL

## 개발 툴

- Eclipse
- Oracle SQL Developer

## 개발 목표

- 인사 평가를 위한 관리자 및 사원의 CRUD 활용을 위함
- Oracl DB를 기반으로 한 Java 및 SQL 언어 학습 및 Eclipse 와 Oracle SQL Developer 툴 활용 학습

## 인사평가 서비스 로직

### 1. 관리자와 사원

- 관리자 로그인
- 사원 로그인
- 나가기

### 2-1. 관리자 로그인(관리자의 권한 CRUD)

- 관리자 ID 및 password 입력

### 2-2. 사원 로그인(CRUD)

- 사원 번호 및 password 입력

### 3-1 관리자 서비스

- 사원 조회(부서별, 입사일별, 직급별) Read
- 3-1-1, 인사 평가
- 나가기

### 3-1-1 인사 평가 서비스

- 평가 항목 생성(부서 or 직급에 따른 평가 항목 생성) Create
- 평가 항목 제거 Delete
- 평가하기 Update

### 3-2 사원 서비스

- 평가 결과 조회 (평가 년도,부서, 직급 평가 확인 - 각 항목별 평과 점수 및 총 점수) Read
- 3-2-1, 자기 평가 - 고과점수에 포함X
- 나가기

### 3-2-1 자기 평가 서비스

- 평가 항목 생성(스스로 평가 하고 싶은 항목) Create
- 평가 항목 제거 Delete
- 평가하기 Update

---

### 시간이 된다면 추가 하고 싶은 항목

- 인사 평가에 따른 등급(A, B, C, D, E)을 통해 보너스 혹은 부서 운영비 차등 지급 입력 및 조회

## 요구분석

1. **시작**
    - 사용자가 사원인지 관리자인지 구별하기 위해 로그인 시스템 사용
    - 로그인 시스템
        - 사원은 입사 할 때 받은 사원번호(동명이인 구별)가 ID
        password는 생년월일 8자리로 가정
        - 관리자 ID와 password는 관리자의 번호와 동일하다고 가정
    - 회원가입 시스템을 만들지 않은 이유
        - 회사 내 인트라넷을 통해 회원가입을 입사 당시 자동으로 한다고 가정
2. **관리자 서비스**
    - CRUD
        - C : 인사 평가 항목을 생성 - 부서별, 직급별
            - 부서별 : 부서에서 진행하는 업무 프로세스에 따라 성과를 평가
            - 직급별 : 직급에 따라 주어지는 업무 역량에 따라 평가
        - R : 사원을 조회(전체, 부서별, 직급별, 입사일별)
        - U : 평가 항목에 따른 평가 점수 Insert,
        평가 항목 내용 수정
        평가 점수 수정
        - D : 생성했던 평가 항목들 제거
3. **사원 서비스**
    - CRUD - 자기 평가는 본인의 성장을 확인하기 위한 목적으로 인사고과에 포함되지 않음
        - C : 스스로 평가 하고싶은 항목을 생성(스스로 지난 평가에 비해 얼마나 성장했는가를 확인하기 위한 성장지표)
        - R : 평가된 자기 평가 점수 조회(인사평가 or 자기평가 - 연도별 조회)
        - U : 생성한 자기 평가 항목에 점수 입력
        생성한 자기 평가 항목 내용 수정
        - D : 생성했던 평가 항목들 제거

## ERD
![Performance_20240408_172229](https://github.com/DevHyun2/Performance_Evaluation_PP/assets/125541289/c7a11d12-4a18-41be-85ed-11783350234e)

