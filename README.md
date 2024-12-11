# Introduction.

이 샘플 프로젝트는 복잡한 개념을 최대한 덜어내고,
기본적인 CRUD 동작에 집중하여 코드 스타일에 적응할 수 있도록 안내합니다.

다음 항목을 포함합니다.

- 레이어드 아키텍처의 대표적인 구현을 따릅니다. (Controller - Service - Repository)
- Spring Data JPA를 사용합니다.
- 예외 처리
  - interface ErrorCode를 사용합니다. (그리고 구현은 여러 enum으로 합니다.)
  - Global Exception Handler를 사용합니다.
- Command 작업 (INSERT, UPDATE, DELETE)
  - JPA Repository 기반
- Query 작업 (조회)
  - JPA Repository 기반
  - Record Projection 사용
  - 단건 조회: Optional&lt;DetailProjection&gt;
  - 목록 조회: List&lt;SummaryProjection&gt;
    - 페이지 객체를 반드시 사용할 때만 Page&lt;SummaryProjection&gt;
- 

# Prerequisites

- JDK 21  
  You can use OpenJDK e.g. Amazon Corretto 21
- Docker Compose  
  If you install [docker desktop](https://www.docker.com/products/docker-desktop/),
  docker compose will be installed at the same time.

# Installation